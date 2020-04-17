package Spring2.Dao.Impl;


import Spring2.Dao.IAccountDao;
import Spring2.Domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//  账户的持久层实现类
@SuppressWarnings("all")
@Repository(value = "accountDao1") // Repository 一般用于持久层，value 属性用于指定 Beam 的Id ,不设置默认为 类的首字母改小写，
// @Scope(value = "singleton")  // @Scope 用于指定bean的作用范围，即指定单多例
public class AccountDaoImpl implements IAccountDao {

    // Autowired 用于属性注入，可用于方法和变量，可以不提供setter 方法
    // Autowired 单独使用的时候只能按照类型注入，即容器中有且只有一个该类型 bean 时，IoC 容器会自动注入，反之失败
    @Autowired
    private QueryRunner runner;

    @PostConstruct //用于指定初始化方法。
    public void init() {
        System.out.println("AccountDaoImpl 初始化方法执行了");
    }

    @PreDestroy  //用于指定销毁方法
    public void destroy() {
        System.out.println("AccountDaoImpl销毁方法执行了");
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ? ", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id=?", accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showThis() {
        System.out.println("这是第一个实现类。。");
    }
}