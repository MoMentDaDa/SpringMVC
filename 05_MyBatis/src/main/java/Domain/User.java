package Domain;

import java.io.Serializable;
import java.util.Date;

/* 实体类，未使用结果集映射，属性名和列名一样*/
@SuppressWarnings("all")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
