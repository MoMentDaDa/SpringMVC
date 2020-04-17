package FactoryDesign.AbstractFactory;


import FactoryDesign.AbstractFactory.Dao.ILogin;
import FactoryDesign.AbstractFactory.Dao.IUser;
import FactoryDesign.AbstractFactory.Dao.sqlFactory;
import FactoryDesign.AbstractFactory.Factory.OracleFactory;
import FactoryDesign.Domian.User;
import FactoryDesign.Domian.login;
import org.junit.Test;

public class testDemo {
    @Test
    public void test1() throws Exception {

        User user = new User();
        login login = new login();

        // 只需要确定实例化哪一个数据库访问对象给factory
        // IFactory factory=new MysqlFactory();
        sqlFactory factory = new OracleFactory();

        // 已与具体的数据库访问解除了耦合
        IUser userOperation = factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

        // 已与具体的数据库访问解除了耦合
        ILogin loginOperation = factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);

    }
}

