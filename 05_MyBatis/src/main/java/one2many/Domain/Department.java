package one2many.Domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Data
public class Department {
    private byte id;
    private String name;
    //一个部门对应多个员工，建议先 new 出来，这样可以避免空指针和方便添加
    public List<Employee> emps = new ArrayList<Employee>();
}