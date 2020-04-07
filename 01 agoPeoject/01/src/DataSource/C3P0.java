package DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: JDBC
 * @description: C3P0连接池使用
 * @author: Mr.Wang
 * @create: 2020-03-17 16:19
 **/
@SuppressWarnings("all")
public class C3P0 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2. 获取连接对象，默认获取默认配置DataSource，也可以使用传递参数来获取指定名称配置
        DataSource ds2 = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 1; i <= 9; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "insert into student values(1,'王五',30)";
        if (stmt.executeUpdate(sql) > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    ;
}
