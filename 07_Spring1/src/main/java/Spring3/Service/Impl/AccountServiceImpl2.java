package Spring3.Service.Impl;


import Spring3.Dao.IAccountDao;
import Spring3.Domain.Account;
import Spring3.Service.IAccountService;
import lombok.Setter;

import java.util.List;

// 账户的业务层实现类，事务控制应该都是在业务层til.List;
@Setter
@SuppressWarnings("all")
public class AccountServiceImpl2 implements IAccountService {

    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        List<Account> accounts = accountDao.findAllAccount();
        return accounts;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        Account account = accountDao.findAccountById(accountId);
        return account;
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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        System.out.println("这是动态代理");
        // 模拟异常
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
