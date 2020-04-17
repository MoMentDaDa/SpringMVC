package Spring1.Service;

import Spring1.Domain.Account;

import java.util.List;

// 单表 CRUD 操作服务层 Dao
@SuppressWarnings("all")
public interface IAccountService2 {
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
}
