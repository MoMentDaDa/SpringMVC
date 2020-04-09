package Dao;

import Domain.QueryVo;
import Domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: JavaWeb
 * @description: IUserDao实现
 * @author: Mr.Wang
 * @create: 2020-04-03 15:02
 **/
@SuppressWarnings("all")
public class IUserImpl implements IUserDao {
    private SqlSessionFactory factory;

    public IUserImpl(SqlSessionFactory factory) {
        System.out.println("这是自己实现类");
        this.factory = factory;
    }


    @Override
    public List<User> findAll() {
        //2.调用SqlSession中的方法，实现查询列表,参数就是能获取配置信息的key
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("Dao.IUserDao.findAll");

        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.insert("Dao.IUserDao.saveUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    @Override
    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现更新
        session.update("Dao.IUserDao.updateUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    @Override
    public void deleteUser(long userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现更新
        session.update("Dao.IUserDao.deleteUser", userId);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public List<User> findByName(String username) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }

    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    @Override
    public List<User> findUserByCondition(User user) {
        return null;
    }

    @Override
    public List<User> findUserInIds(QueryVo vo) {
        return null;
    }
}
