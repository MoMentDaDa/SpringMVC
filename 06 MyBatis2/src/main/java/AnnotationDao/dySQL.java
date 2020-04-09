package AnnotationDao;

import Domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

// 用于返回动态拼接SQL的方法类
@SuppressWarnings("all")
public class dySQL {

    public String insertNews(@Param("news") User news) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if (news.getId() != null) {
                    VALUES("id", "#{news.id}");
                }
                if (news.getUsername() != null) {
                    VALUES("username", "#{news.username}");
                }
                if (news.getAddress() != null) {
                    VALUES("address", "#{news.address}");
                }
                if (news.getSex() != null) {
                    VALUES("sex", "#{news.sex}");
                }
                if (news.getBirthday() != null) {
                    VALUES("birthday", "#{news.birthday}");
                }
            }
        }.toString();
    }

    // 更新用户
    public String updateNews(@Param("news") User news) {
        return new SQL() {
            {
                UPDATE("user");
                if (news.getUsername() != null) {
                    SET("username = #{news.username}");
                }
                if (news.getAddress() != null) {
                    SET("address=#{news.address}");
                }
                if (news.getSex() != null) {
                    SET("sex=#{news.sex}");
                }
                if (news.getBirthday() != null) {
                    SET("birthday=#{news.birthday}");
                }
            }
        }.toString();
    }


    public String serchByCondition(@Param("news") User news) {
        String s = new SQL() {
            {
                SELECT("*");
                FROM("user");
                if (news.getUsername() != null) {
                    WHERE("username like CONCAT('%',#{news.username},'%')");
                }
                if (news.getAddress() != null) {
                    WHERE("address=#{news.address}");
                }
                if (news.getSex() != null) {
                    WHERE("sex=#{news.sex}");
                }
                if (news.getBirthday() != null) {
                    WHERE("birthday=%#{news.birthday}%");
                }
            }

        }.toString();
        System.out.println(s);
        return s;

    }
}
