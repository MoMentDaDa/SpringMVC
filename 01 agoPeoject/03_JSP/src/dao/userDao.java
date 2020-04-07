package dao;

import domian.User;

import java.util.List;
import java.util.Map;

// 用户操作的DAO
@SuppressWarnings("all")
public interface userDao {
    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int i);

    void update(User user);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    //页查询每页记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
