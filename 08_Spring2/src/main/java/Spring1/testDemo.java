package Spring1;

import Domian.Account;
import Spring1.Service.IAccountService;
import Spring1.Utils.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: JavaWeb
 * @description: 测试类
 * @author: Mr.Wang
 * @create: 2020-04-16 19:54
 **/

public class testDemo {
    @Test
    public void test1() throws Exception {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        //2.获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService2");
        //3.执行方法
        as.saveAccount(new Account());
        as.updateAccount(new Account());
        as.deleteAccount(1);
    }

    //基于注解的配置
    @Test
    public void test2() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) applicationContext.getBean("accountService2", IAccountService.class);
        //3.执行方法，增强方法执行的前后顺序不同
        as.saveAccount(new Account());
        as.updateAccount(new Account());
        as.deleteAccount(1);
    }


}
