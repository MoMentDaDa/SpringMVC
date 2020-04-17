package Spring4;


import Spring4.Config.SpringConfiguration;
import Spring4.Service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class testDemo {

    @Autowired
    private IAccountService as;
    private IAccountService as2;

    // 基于 注解的事务配置实现
    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }

    @Test
    public void testTransfer2() {
        ApplicationContext ap = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ap.getBean("accountService", IAccountService.class).transfer("aaa", "bbb", 100f);

    }



}
