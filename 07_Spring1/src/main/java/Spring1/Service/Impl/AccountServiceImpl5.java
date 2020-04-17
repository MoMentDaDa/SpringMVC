package Spring1.Service.Impl;


import Spring1.Dao.IAccountDao2;
import Spring1.Domain.Account;
import Spring1.Service.IAccountService2;
import lombok.Setter;

import java.util.List;

// 账户的业务层实现类
@Setter
public class AccountServiceImpl5 implements IAccountService2 {
    private IAccountDao2 accountDao;

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
