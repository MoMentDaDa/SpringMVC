package Domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

// 用户类,一个用户可以有多个账户，所以是一对多
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
    //一对多关系映射：主表实体应该包含从表实体的集合引用
    private List<Account> accounts;
}
