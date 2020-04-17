package Spring3.Web;


import Spring3.Service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

// 模拟一个表现层，用于调用业务层

@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConfig3.xml")
public class Client {
    @Resource(name = "accountServiceDao")
    private IAccountService as;

    // 获取增强后的类
    @Resource(name = "proxyAccountService")
    private IAccountService as2;

    // 基于手动实现的事务管理
    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }

    // 基于动态代理实现的事务管理
    @Test
    public void testTransfer2() {
        as2.transfer("aaa", "bbb", 100f);
    }
}

