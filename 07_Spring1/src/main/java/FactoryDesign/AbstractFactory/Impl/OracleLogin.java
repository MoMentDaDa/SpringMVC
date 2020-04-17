package FactoryDesign.AbstractFactory.Impl;

import FactoryDesign.AbstractFactory.Dao.ILogin;
import FactoryDesign.Domian.login;

// Oracle 操作的实现类
public class OracleLogin implements ILogin {
    @Override
    public void insert(login login) {
        System.out.println("对 Oracle 里的 Login 表插入了一条数据");
    }

    @Override
    public login getLogin(int id) {
        System.out.println("通过 uid 在 Oracle 里的 Login 表得到了一条数据");
        return null;
    }
}
