import Dao.IAccountDao;
import Dao.IUserDao;
import Domain.Account;
import Domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class testDemo {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    private IUserDao userDao;

    //用于在测试方法执行之前执行
    @Before
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    //用于在测试方法执行之后执行
    @After
    public void destroy() throws Exception {
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    // 一对一，编写测试，未开启时，默认会主动将用户信息查询出来，同时由于打印输出也会触发查询，所以当只查询不输出时只会查询账户信息
    @Test
    public void test1() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    // 一对多，编写测试
    @Test
    public void test2() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);

        }
    }


    // 测试一级缓存，只要 SqlSession 没有 flush 或 close，它就存在。
    @Test
    public void test3() {
        User user1 = userDao.findById(41);
        System.out.println(user1);
        // 当 SqlSession 未关闭时，重复查询，其对象都指向同一个内存地址，这就是一级缓存的作用
       // sqlSession.close();
        //再次获取SqlSession对象，被动清空刷新
       // sqlSession = factory.openSession();
        //此方法也可以清空缓存，主动清空刷新
        // sqlSession.clearCache();
        //userDao = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    // 测试缓存的同步，即验证执行 commit 操作（执行插入、更新、删除）时刷新缓存
    @Test
    public void test4() {
        //1.根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("习大大");
        user1.setAddress("北京市海淀区");
        userDao.updateUser(user1);
        //3.再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    // 测试二级缓存，二级缓存需要配置,二级缓存是存数据，谁用给谁，一级是存的是对象，查询同一个即调用同一个对象，所以对象不同
    @Test
    public void test5() {
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }
}



