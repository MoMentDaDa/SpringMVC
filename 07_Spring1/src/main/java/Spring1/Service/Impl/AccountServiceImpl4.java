package Spring1.Service.Impl;


import Spring1.Service.IAccountService;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

// 集合注入
@SuppressWarnings("all")
@ToString
@Setter
public class AccountServiceImpl4 implements IAccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;


    public AccountServiceImpl4() {
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
