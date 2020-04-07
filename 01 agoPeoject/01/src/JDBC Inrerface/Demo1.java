import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @program: JDBC
 * @description: 初始JDBC
 * @author: Mr.Wang
 * @create: 2020-03-11 11:44
 **/
public class Demo1 {


    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //1. 导入驱动jar包，不一定要显示导入，因为在META-INF\services\java.sql.Driver，已经隐式声明
        // Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "will", "will1234");
        //下面语句可能由于密码问题导致出错
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root ", "admin");
        // 4.定义DDL语句
        String sql = "create table student (id int , name varchar(20),age int)";
        //4.获取执行sql对象
        stmt = conn.createStatement();
      /*  //建表操作
        if (stmt.executeUpdate(sql) > 0) {
            System.out.println("建表失败" );
        } else {
            System.out.println("建表成功" );
        }*/

        //定义DML
        /*String sql2 = "insert into student values(1,'王五',20)";//定义插入语句
        if (stmt.executeUpdate(sql2) > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }*/


        //定义修改操作
        /*String sql3 = "update student set age = 32 where id=\"1\"";
        if (stmt.executeUpdate(sql3) > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败");
        }*/
        String sql4 = "delete from student where id = 1";
        if (stmt.executeUpdate(sql4) > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败");
        }
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
