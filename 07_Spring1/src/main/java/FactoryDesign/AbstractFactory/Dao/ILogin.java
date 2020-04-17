package FactoryDesign.AbstractFactory.Dao;

import FactoryDesign.Domian.login;

@SuppressWarnings("all")
public interface ILogin {
    public void insert(login login);

    public login getLogin(int id);

}
