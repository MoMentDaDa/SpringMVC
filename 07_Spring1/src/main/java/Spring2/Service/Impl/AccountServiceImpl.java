package Spring2.Service.Impl;


import Spring2.Dao.IAccountDao;
import Spring2.Domain.Account;
import Spring2.Service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// 账户的业务层实现类
@Service("accountService")  //@Service 一般用于指定服务层的bean 配置，和持久层的作用一样
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
    @Resource(name = "accountDao1")  //Resource 也可用于属性注入，该属性直接根据 id 自动注入
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }
}
