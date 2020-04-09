package one2many.Dao;

import one2many.Domain.Department;

@SuppressWarnings("all")
public interface DepartmentMapper {
    // 保存新的工作
    void save(Department d);

    //查询本工作的所有员工
    Department get(String name);

}
