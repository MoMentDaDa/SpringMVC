package FactoryDesign.AbstractFactory.Dao;

import FactoryDesign.Domian.User;

public interface IUser {
    public void insert(User user);

    public User getUser(int uid);
}
