package one2many;

import one2many.Dao.DepartmentMapper;
import one2many.Dao.EmployeeMapper;
import one2many.Domain.Department;
import one2many.Domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class TestDemo {
    private static final SqlSession session;
    private static InputStream in;
    private static DepartmentMapper dDao;
    private static EmployeeMapper eDao;

    static {
        //1.读取配置文件
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        dDao = session.getMapper(DepartmentMapper.class);
        eDao = session.getMapper(EmployeeMapper.class);
    }

    // 查询 ACCOUNTING 工作的所有员工
    @Test
    public void test1() {
        Department d = dDao.get("ACCOUNTING");
        System.out.println(d.toString());
    }

    // 保存一个新工作
    @Test
    public void test2() {
        Department d = new Department();
        d.setId((byte) 50);
        d.setName("engineer");
        dDao.save(d);
        session.commit();
    }

    // 保存一个新员工
    @Test
    public void test3() {
        Employee e = new Employee();
        e.setName("令狐冲");
        e.setDeptId(50);
        eDao.save(e);
        session.commit();
    }

    // 根据 作ID 查找员工
    @Test
    public void test4() {
        Employee e = new Employee();
        List<Employee> u = eDao.selectByDeptID(40);
        System.out.println(u.toString());
    }

    // 保存一个部门和两个员工
    @Test
    public void test5() {
        Department d = new Department();
        d.setName("开发部");
        d.setId((byte) 51);
        Employee e1 = new Employee();
        e1.setName("张三");

        Employee e2 = new Employee();
        e2.setName("李四");

        // 维护对象之间的关系
        d.getEmps().add(e1);
        d.getEmps().add(e2);

        dDao.save(d);
        e1.setDeptId(d.getId());
        e2.setDeptId(d.getId());
        eDao.save(e1);
        eDao.save(e2);
        session.commit();
    }
}
