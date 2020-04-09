package Domain;

import lombok.Data;

import java.io.Serializable;

// 账户类，一个账户外键ID 只能对应一个用户，所以是一对一
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
    //一对一关系映射
    private User u;


}
