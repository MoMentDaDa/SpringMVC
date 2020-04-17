package Spring3.Dao;


import Spring3.Domain.Account;

import java.util.List;

/**
 * @program: JavaWeb
 * @description: 用于演示 XML配置事务 操作数据的Dao
 * @author: Mr.Wang
 * @create: 2020-04-12 18:17
 **/
@SuppressWarnings("all")
public interface IAccountDao {
    // 查询所有
    List<Account> findAllAccount();

    // 查询一个
    Account findAccountById(Integer accountId);

    // 保存
    void saveAccount(Account account);

    // 更新
    void updateAccount(Account account);

    // 删除
    void deleteAccount(Integer acccountId);

    Account findAccountByName(String sourceName);
}
