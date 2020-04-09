package one2many.Domain;


import lombok.Data;

@Data
@SuppressWarnings("all")
public class Employee {
    private long id;
    private String name;
    private String salary;
    private String birth;
    private int age;
    private int deptId;
}
