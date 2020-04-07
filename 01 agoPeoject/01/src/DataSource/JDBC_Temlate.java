package DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @program: JDBC
 * @description: 使用Spring工具
 * @author: Mr.Wang
 * @create: 2020-03-17 19:14
 **/
@SuppressWarnings("all")
public class JDBC_Temlate {
    DataSource ds = new ComboPooledDataSource();
    //1. 获取JDBCTemplate对象
    JdbcTemplate template = new JdbcTemplate(ds);

    static class Emp {
        private Integer empno;
        private String ename;
        private String job;
        private Integer mgr;

        public Emp() {
        }

        public Integer getEmpno() {
            return empno;
        }

        public void setEmpno(Integer empno) {
            this.empno = empno;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public Integer getMgr() {
            return mgr;
        }

        public void setMgr(Integer mgr) {
            this.mgr = mgr;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "empno=" + empno +
                    ", ename='" + ename + '\'' +
                    ", job='" + job + '\'' +
                    ", mgr=" + mgr +
                    '}';
        }
    }

    @Test
    public void test1() {
        String sql = "update emp set sal = 10000 where empno = 7369";
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp(empno,ename,sal) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where empno = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4.查询id为1001的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from emp where empno = ?";
        Map<String, Object> map = template.queryForMap(sql, 7369);
        System.out.println(map);
        //{empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17, sal=10000.00, comm=null, deptno=20}
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("empno");
                String ename = rs.getString("ename");
                int mgr = rs.getInt("mgr");
                double salary = rs.getDouble("sal");
                String job = rs.getString("job");
                emp.setEmpno(id);
                emp.setEname(ename);
                emp.setJob(job);
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    // 6. 查询所有记录，将其封装为Emp对象的List集合,BeanPropertyRowMapper会自动将列的值按列名和类属性名给赋予,内部类应加static
    @Test
    public void test7() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    // 7. 查询总记录数
    @Test
    public void test8() {
        String sql = "select count(empno) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }


}
