package Spring1.service.impl;


import Spring1.dao.IAccountDao;
import Spring1.service.IAccountService;
import domain.Account;
import lombok.Setter;


@Setter
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

       // int i = 1 / 0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
