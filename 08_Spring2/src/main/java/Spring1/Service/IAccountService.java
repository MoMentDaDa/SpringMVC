package Spring1.Service;

// 单表 CRUD 操作服务层 Dao

import Domian.Account;

import java.util.List;

@SuppressWarnings("all")
public interface IAccountService {
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


    // 转账
    void transfer(String sourceName, String targetName, Float money);
}
