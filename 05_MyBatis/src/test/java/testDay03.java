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
import java.util.ArrayList;
import java.util.List;

//  动态 sql 演示
@SuppressWarnings("all")
public class testDay03 {
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
        // 查询所有
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 测试foreach标签的使用
    @Test
    public void test2() {
        User u = new User();
        u.setId(4L);
        u.setAge((byte) 12);
        u.setPassword("wang1234");
        userDao.updateUser(u);
        session.commit();
    }

    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setName("乔峰");
        u.setAge((byte) 32);
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 测试foreach标签的使用
    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(12);
        vo.setIds(list);
        //5.执行查询所有方法
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

}


