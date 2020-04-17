package Spring1.Service.Impl;


import Spring1.Dao.IAccountDao;
import Spring1.Service.IAccountService;
import lombok.Setter;

// 账户的业务层实现类
@SuppressWarnings("all")
@Setter
public class AccountServiceImpl implements IAccountService {
    private IAccountDao Dao;

    public AccountServiceImpl() {
        System.out.println("对象创建了，默认构造。。。。");
    }

    public void init() {
        System.out.println("对象初始化了。。。");
    }

    public void destroy() {
        System.out.println("对象销毁了。。。");
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。");
        Dao.saveAccount();
    }
}
