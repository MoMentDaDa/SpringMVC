package Spring1.Service.Impl;


import Spring1.Service.IAccountService;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 使用 Setter 方法注入
@SuppressWarnings("all")
@ToString
@Setter
public class AccountServiceImpl3 implements IAccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl3() {
        System.out.println("AccountServiceImpl3 对象创建了，默认构造。。。。");
    }

    public void init() {

        System.out.println("对象初始化了。。。");
    }

    public void destroy() {

        System.out.println("对象销毁了。。。");
    }

    @Override
    public void saveAccount() {

    }
}
