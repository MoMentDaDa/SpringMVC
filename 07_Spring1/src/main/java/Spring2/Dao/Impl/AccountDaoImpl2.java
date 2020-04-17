package Spring2.Dao.Impl;


import Spring2.Dao.IAccountDao;
import Spring2.Domain.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;


//  账户的持久层实现类
@SuppressWarnings("all")

@Repository(value = "accountDao2") // Repository 一般用于持久层，value 属性用于指定 Beam 的Id ,不设置默认为 类的首字母改小写，
// @Scope(value = "singleton")  // @Scope 用于指定bean的作用范围，即指定单多例
public class AccountDaoImpl2 implements IAccountDao {
    //用于基本类型和String 类型注入，它可以使用spring中SpEL(也就是spring的el表达式），SpEL的写法：${表达式}
    @Value(value = "汪大大")
    String username;
    @Value(value = "14")
    int age;
    public void print() {
        System.out.println(username + age);
    }
    @PostConstruct //用于指定初始化方法。
    public void init() {
        System.out.println("AccountDaoImpl2 初始化方法执行了");
    }
    @PreDestroy  //用于指定销毁方法
    public void destroy() {
        System.out.println("AccountDaoImpl2 销毁方法执行了");
    }



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
    public void deleteAccount(Integer accountId) {
    }

    @Override
    public void showThis() {
        System.out.println("这是第二个实现类。。");
    }
}