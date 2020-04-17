package Spring1.Factory;


// 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）

import Spring1.Service.IAccountService;
import Spring1.Service.Impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
