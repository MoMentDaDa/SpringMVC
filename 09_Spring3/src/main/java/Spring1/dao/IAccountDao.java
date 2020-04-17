package Spring1.dao;


import domain.Account;

public interface IAccountDao {

    Account findAccountById(Integer accountId);


    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
