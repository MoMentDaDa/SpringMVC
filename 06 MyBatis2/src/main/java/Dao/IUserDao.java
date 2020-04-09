package Dao;

import Domain.User;

import java.util.List;

public interface IUserDao {
    // 查询所有操作
    List<User> findAll();


    User findById(int i);

    void updateUser(User user1);
}
