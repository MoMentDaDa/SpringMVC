package JNDI;


import JNDI.Dao.IUserDao;
import JNDI.Domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



@SuppressWarnings("all")
public class testDemo {
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

    private void closes(InputStream in, SqlSession session) {
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


