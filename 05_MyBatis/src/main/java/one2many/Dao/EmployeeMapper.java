package one2many.Dao;

import one2many.Domain.Employee;

import java.util.List;

@SuppressWarnings("all")
public interface EmployeeMapper {
    //保存员工
    void save(Employee e);

    //根据工作查找
    List<Employee> selectByDeptID(long id);

}
