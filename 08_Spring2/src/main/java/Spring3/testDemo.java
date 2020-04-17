package Spring3;


import Spring3.Service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")

public class testDemo {

    // 基于 XML 的配置实现
    @Test
    public void test1() throws Exception {
        //1.从容器获取数据源
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig3.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.transfer("aaa", "bbb", 100f);
    }

}
