package domian;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: JavaWeb
 * @description: bean 类，用于演示jstl
 * @author: Mr.Wang
 * @create: 2020-03-20 13:20
 **/
@SuppressWarnings("all")
public class user2 {
    private String name;
    private int age;
    private Date birthday;

    public user2(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public user2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    // 逻辑视图
    public String getBirStr() {
        if (birthday != null) {
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //2.返回字符串即可
            return sdf.format(birthday);
        } else {
            return "";
        }
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
