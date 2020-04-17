package FactoryDesign.AbstractFactory.Factory;


import FactoryDesign.AbstractFactory.Dao.ILogin;
import FactoryDesign.AbstractFactory.Dao.IUser;
import FactoryDesign.AbstractFactory.Dao.sqlFactory;
import FactoryDesign.AbstractFactory.Impl.OracleLogin;
import FactoryDesign.AbstractFactory.Impl.OracleUser;

public class OracleFactory implements sqlFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }

    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }

}
