package AnnotationDao;


import Domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

// 在mybatis中针对,CRUD一共有四个注解，@Select @Insert @Update @Delete，该Dao 演示的均为动态SQL，CacheNamespace 开启二级缓存机制
@SuppressWarnings("all")
@CacheNamespace(blocking = true)
public interface IUserDao2 {
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
    @InsertProvider(method = "insertNews", type = dySQL.class)
    // 主键自增，赋给java类
    @Options(useGeneratedKeys = true, keyProperty = "news.id")
    void saveUser(@Param("news") User user);


    @InsertProvider(method = "updateNews", type = dySQL.class)
    void updateUser(@Param("news") User user);


    @SelectProvider(method = "serchByCondition", type = dySQL.class)
    List<User> serchByCondition(@Param("news") User u);
}
