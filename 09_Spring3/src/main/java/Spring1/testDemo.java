package Spring1;


import Spring1.config.SpringConfiguration;
import Spring1.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {
    @Test
    public void testTransfer() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("bean.xml");
        ap.getBean("accountService", IAccountService.class).transfer("aaa", "bbb", 100f);

    }

    @Test
    public void testTransfer2() {
        ApplicationContext ap = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ap.getBean("accountService", IAccountService.class).transfer("aaa", "bbb", 100f);

    }

}