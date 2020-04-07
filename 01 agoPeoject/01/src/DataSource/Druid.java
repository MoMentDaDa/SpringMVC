package DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @program: JDBC
 * @description: 德鲁伊连接池
 * @author: Mr.Wang
 * @create: 2020-03-17 16:48
 **/
@SuppressWarnings("all")
public class Druid {
    private static DataSource ds;

    //1.定义成员变量 DataSource
    static {
        try {
            Properties pro = new Properties();
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

    private static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        String sql = "insert into student values(2,'王五',33)";
        if (stmt.executeUpdate(sql) > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }
}