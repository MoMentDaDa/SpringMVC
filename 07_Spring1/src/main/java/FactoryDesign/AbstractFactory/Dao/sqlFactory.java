package FactoryDesign.AbstractFactory.Dao;

public interface sqlFactory {
    public IUser createUser();     //用于访问User表的对象

    public ILogin createLogin(); //用于创建 Login表对象
}
