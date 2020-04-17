package Spring1.Dao.Impl;


import Spring1.Dao.IAccountDao;

//  账户的持久层实现类
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
