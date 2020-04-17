package Spring2.Web;


import Spring2.Config.SpringConfiguration;
import Spring2.Dao.IAccountDao;
import Spring2.Dao.Impl.AccountDaoImpl;
import Spring2.Dao.Impl.AccountDaoImpl2;
import Spring2.Domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

// 模拟一个表现层，用于调用业务层
@SuppressWarnings("all")
 @RunWith(SpringJUnit4ClassRunner.class) // 导入 Spring 改造后的单元测试类，同时junit 版本要高于4.12
@ContextConfiguration(classes = Spring2.Config.SpringConfiguration.class) // 该注解用于指定配置类的路径
public class Client {
    @Autowired
    @Qualifier("accountDao1") // 为了规避单独使用 Autowired 的缺陷，可以通过配合 Qualifier 共同使用实现按类型和id 自动注入。
    private IAccountDao as;

    @Resource(name = "accountDao2")
    private IAccountDao as2;

    @Test
    public void test1() {
        // 使用该方法不能包含任何关于引入配置的注解，当使用该方法直接传入SpringConfiguration字节码时，其配置类的Configuration可以省略
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountDaoImpl as3 = (AccountDaoImpl) applicationContext.getBean("accountDao1", IAccountDao.class);
        AccountDaoImpl2 as4 = (AccountDaoImpl2) applicationContext.getBean("accountDao2", IAccountDao.class);
        as3.showThis();
        as4.showThis();
        as4.print();
    }

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test anno");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findAccountById(5);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(5);
    }

}
