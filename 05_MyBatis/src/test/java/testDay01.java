import Dao.IUserDao;
import Domain.QueryVo;
import Domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * @program: JavaWeb
 * @description: 第一天测试类
 * @author: Mr.Wang
 * @create: 2020-03-31 15:04
 **/
@SuppressWarnings("all")
public class testDay01 {
    private static final SqlSession session;
    private static InputStream in;
    private static IUserDao userDao;

    static {
        //1.读取配置文件
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void test1() throws Exception {
        // 使用代理对象执行方法
        //List<User> users = userDao.findAll();
        // 这句和上面是一样的效果，statement 指向mapper 命名空间，后接其SQL 语句ID，所有查询最后调用的都是 selectList
        List<User> users = session.selectList("Dao.IUserDao.findAll");
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        closes(in, session);
    }

    @Test
    public void test2() throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        User u = new User("明明", (byte) 34, "minging12", fmt.parse("2012-03-04"));
        userDao.saveUser(u);
        closes(in, session);
    }

    @Test
    public void test3() throws Exception {
        System.out.println(userDao.findById(2).toString());
        closes(in, session);
    }

    @Test
    public void test4() throws Exception {
        System.out.println(userDao.findTotal());
        closes(in, session);
    }

    @Test
    public void test5() throws Exception {
        System.out.println(userDao.findByName("l"));
        closes(in, session);
    }

    @Test
    public void test6() throws Exception {
        User u = new User();
        u.setName("ming");
        QueryVo v = new QueryVo(u);
        System.out.println(userDao.findUserByVo(v).toString());
        closes(in, session);
    }

    @Test
    public void test7() throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        User u = new User("lulu", (byte) 21, "dafdaf", fmt.parse("2012-03-4"));
        userDao.saveUser(u);
        // 该句与上一句是一样的作用，原理和查询一样
        // session.insert("Dao.IUserDao.saveUser",u);
        session.commit();
        closes(in, session);
    }

    @Test
    public void test8() throws Exception {
        User u = new User();
        u.setId(7);
        u.setName("明明");
        userDao.updateUser(u);
        // 该句与上一句是一样的作用，原理和查询一样
        // session.update("Dao.IUserDao.updateUser",u);
        session.commit();
        closes(in, session);
    }

    @Test
    public void test9() throws Exception {
        userDao.deleteUser(18);
        // 该句与上一句是一样的作用，原理和查询一样
        // session.delete("Dao.IUserDao.deleteUser",18);
        session.commit();
        closes(in, session);
    }


    private void closes(InputStream in, SqlSession session) {
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


