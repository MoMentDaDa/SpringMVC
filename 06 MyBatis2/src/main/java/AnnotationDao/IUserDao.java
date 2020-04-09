package AnnotationDao;


import Domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

// 在mybatis中针对,CRUD一共有四个注解，@Select @Insert @Update @Delete，该Dao 演示的均为静态SQL，CacheNamespace 开启二级缓存机制
@SuppressWarnings("all")
@CacheNamespace(blocking = true)
public interface IUserDao {
    // 查询所有操作
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "AnnotationDao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    //保存用户
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    // 删除用户
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);

    // 根据id查询用户
    @Select("select * from user  where id=#{id} ")

    @ResultMap("userMap")
    User findById(int i);

    // 根据用户名称模糊查询
    // @Select("select * from user where username like #{username} ")
    @Select("select * from user where username like '%${value}%' ")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

    @Update("update user set sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user1);

    // 查询总用户数量
    @Select("select count(*) from user ")
    int findTotalUser();
}
