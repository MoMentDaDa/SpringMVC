package MyBatisDesign;

import Dao.IUserDao;
import Domain.User;
import MyBatisDesign.Configuration.Resources;
import MyBatisDesign.SqlSession.SqlSession;
import MyBatisDesign.SqlSession.SqlSessionFactory;
import MyBatisDesign.SqlSession.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

//  用于测试自己的写的实现类
@SuppressWarnings("all")
public class testDay02 {
    private InputStream in;
    private IUserDao userDao;
    SqlSessionFactory factory;

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //6.释放资源
        in.close();
    }


    @Test
    public void test1() throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //7.释放资源
        session.close();
        in.close();

    }

    @Test
    public void test2() throws Exception {
    }

}


