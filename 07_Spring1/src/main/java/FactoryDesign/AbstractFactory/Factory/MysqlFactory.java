package FactoryDesign.AbstractFactory.Factory;

import FactoryDesign.AbstractFactory.Dao.ILogin;
import FactoryDesign.AbstractFactory.Dao.IUser;
import FactoryDesign.AbstractFactory.Dao.sqlFactory;
import FactoryDesign.AbstractFactory.Impl.MysqlLogin;
import FactoryDesign.AbstractFactory.Impl.MysqlUser;


public class MysqlFactory implements sqlFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

    @Override
    public ILogin createLogin() {
        return new MysqlLogin();

    }
}
