package Spring2;

import Domian.Account;
import Spring2.Dao.IAccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@SuppressWarnings("all")
public class testDemo {
    // 使用Spring 的注解CRUD，直接使用
    @Test
    public void test1() throws Exception {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("will");
        ds.setPassword("will1234");
        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money)values('ccc',1000)");

        //1.从容器获取数据源
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        JdbcTemplate jt2 = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.execute("insert into account(name,money)values('ddd',2222)");

    }

    // 基本用法演示
    @Test
    public void test2() throws Exception {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
        jt.update("insert into account(name,money)values(?,?)", "eee", 3333f);
        //更新
        jt.update("update account set name=?,money=? where id=?", "test", 4567, 7);
        //删除
        jt.update("delete from account where id=?", 8);
        //查询所有
        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
        List<Account> accounts2 = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for (Account account : accounts2) {
            System.out.println(account);
        }
        //查询一个
        List<Account> accounts3 = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(accounts.isEmpty() ? "没有内容" : accounts3.get(0));

        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);

    }

    class AccountRowMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setMoney(rs.getFloat("money"));
            return account;
        }
    }

    // 基于Dao的配置实现
    @Test
    public void test3() throws Exception {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig2.xml");

        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        IAccountDao accountDao2 = ac.getBean("accountDao2", IAccountDao.class);
        Account account = accountDao2.findAccountById(2);
        System.out.println(account);
        account.setMoney(30000f);
        accountDao.updateAccount(account);
    }

}
