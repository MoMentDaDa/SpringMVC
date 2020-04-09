package JNDI.Domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/* 实体类，未使用结果集映射，属性名和列名一样*/
@SuppressWarnings("all")
@Data
public class User implements Serializable {
    private long id;
    private String name;
    private byte age;
    private String password;
    private Date birthday;

    public User() {
    }

    public User(String name, byte age, String password, Date birthday) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.birthday = birthday;
    }
}
