package Spring1.Factory;


import Spring1.Service.IAccountService;
import Spring1.Service.Impl.AccountServiceImpl;

// 模拟使用工厂中的静态方法创建对象
public class StaticFactory {

    public static IAccountService getAccountService() {

        return new AccountServiceImpl();
    }
}
