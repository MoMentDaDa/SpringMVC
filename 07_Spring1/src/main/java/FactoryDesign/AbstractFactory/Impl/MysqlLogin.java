package FactoryDesign.AbstractFactory.Impl;

import FactoryDesign.AbstractFactory.Dao.ILogin;
import FactoryDesign.Domian.login;

// 真正的 MySql 实现类
public class MysqlLogin implements ILogin {
    @Override
    public void insert(login login) {
        System.out.println("对 MySQL 里的 Login 表插入了一条数据");
    }

    @Override
    public login getLogin(int id) {
        System.out.println("通过 uid 在 MySQL 里的 Login 表得到了一条数据");
        return null;
    }

}
