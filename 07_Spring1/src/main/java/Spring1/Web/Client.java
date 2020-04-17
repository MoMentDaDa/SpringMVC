package Spring1.Web;


import Spring1.Dao.IAccountDao;
import Spring1.Domain.Account;
import Spring1.Service.IAccountService;
import Spring1.Service.IAccountService2;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

// 模拟一个表现层，用于调用业务层
@SuppressWarnings("all")
public class Client {
    @Test
    public void test1() throws Exception {
        //1.获取核心容器对象，单例对象适用，加载完文件就创建,通过 XML 方式读取配置
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        // ApplicationContext ac = new FileSystemXmlApplicationContext("C:\Users\Desktop\bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
        // 执行该方法，应该在该 Bean 中配置 DI 注入，否则对象为空
        as.saveAccount();
        // ApplicationContext 是 ClassPathXmlApplicationContext 子类，关闭方法存在于父类中
       // ac.close();
    }

    @Test
    public void test2() throws Exception {
        // 多例对象使用,延迟加载的方式
        Resource resource = new ClassPathResource("SpringConfig.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as2 = (IAccountService) factory.getBean("accountService");
        System.out.println(as2);
    }

    // 构造函数注入
    @Test
    public void test3() throws Exception {
        Resource resource = new ClassPathResource("SpringConfig.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as2 = (IAccountService) factory.getBean("accountService2");
        System.out.println(as2);
    }

    // Set 方法注入
    @Test
    public void test4() throws Exception {
        Resource resource = new ClassPathResource("SpringConfig.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as2 = (IAccountService) factory.getBean("accountService3");
        System.out.println(as2);
    }

    // 集合注入
    @Test
    public void test5() throws Exception {
        Resource resource = new ClassPathResource("SpringConfig.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as2 = (IAccountService) factory.getBean("accountService4");
        System.out.println(as2);
    }


    // 演示 XML 配置，操作CRUD
    @Test
    public void testFindAll() {
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountServiceDao2", IAccountService2.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        IAccountService2 as = ac.getBean("accountServiceDao2", IAccountService2.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        IAccountService2 as = ac.getBean("accountServiceDao2", IAccountService2.class);
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountServiceDao2", IAccountService2.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountServiceDao2", IAccountService2.class);
        //3.执行方法
        as.deleteAccount(4);
    }
}
