package AnnotationDao;


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
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class testDemo {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    private IUserDao userDao;
    private IUserDao2 userDao2;

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
        userDao2 = sqlSession.getMapper(IUserDao2.class);
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

    //编写测试，注解开发
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("科比");
        user.setAddress("美国洛杉矶");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(49);
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }


    @Test
    public void testDelete() {
        userDao.deleteUser(51);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(49);
        System.out.println(user);
    }


    @Test
    public void testFindByName() {
//        List<User> users = userDao.findUserByName("%mybatis%");
        List<User> users = userDao.findUserByName("小");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }

    // 一对一注解查询，未开启懒加载
    @Test
    public void test8() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("----每个账户的信息-----");
            System.out.println(account);
            System.out.println(account.getU());
        }
    }

    // 一对多注解查询，开启懒加载
    @Test
    public void test9() {
        User user = userDao.findById(46);
        System.out.println(user);
    }

    // 测试缓存
    @Test
    public void test10() {
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


    //编写测试，注解SQL
    @Test
    public void test11() {
        User user = new User();
        user.setUsername("科比");
        user.setAddress("美国洛杉矶");
        userDao2.saveUser(user);
    }

    @Test
    public void test12() {
        User user = new User();
        user.setId(50);
        user.setSex("男");
        user.setBirthday(new Date());
        userDao2.updateUser(user);
    }

    @Test
    public void test13() {
        User user = new User();
        user.setUsername("小");
        user.setSex("男");
        System.out.println(userDao2.serchByCondition(user).toString());
    }

}



