package Spring1.Service.Impl;


import Spring1.Service.IAccountService;
import lombok.ToString;

import java.util.Date;

// 有参构造方法注入
@SuppressWarnings("all")
@ToString
public class AccountServiceImpl2 implements IAccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl2(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public AccountServiceImpl2() {
        System.out.println("AccountServiceImpl2 对象创建了，默认构造。。。。");
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
