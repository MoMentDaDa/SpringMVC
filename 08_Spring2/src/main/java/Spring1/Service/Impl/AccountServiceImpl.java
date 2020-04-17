package Spring1.Service.Impl;

import Domian.Account;
import Spring1.Service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

// 账户的业务层实现类
@SuppressWarnings("all")
@Service("accountService2")
public class AccountServiceImpl implements IAccountService {

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {
    }

    @Override
    public void deleteAccount(Integer acccountId) {
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

    }
}
