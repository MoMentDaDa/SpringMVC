package Spring4.Dao;


import Domian.Account;

import java.util.List;

@SuppressWarnings("all")
public interface IAccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer acccountId);

    Account findAccountByName(String accountName);
}
