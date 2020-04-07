import Utils.JDBC_Utils;

import java.sql.*;
import java.util.Scanner;

/**
 * @program: JDBC
 * @description: 演示JDBC工具类
 * @author: Mr.Wang
 * @create: 2020-03-17 10:37
 **/
@SuppressWarnings("all")
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输出密码");
        String password = sc.nextLine();
        boolean flag = login2(username, password);
        if (flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }

    public static boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //1.获取连接
        try {
            conn = JDBC_Utils.getConnection();
            //2.定义sql
            String sql = "select * from user where name = '" + username + "' and password = '" + password + "' ";
            stmt = conn.createStatement();
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            //如果有下一行，则返回true
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(rs, stmt, conn);
        }
        return false;
    }

    public static boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //1.获取连接
        try {
            conn = JDBC_Utils.getConnection();
            //2.定义sql
            String sql = "select * from user where name = ? and password = ?";
            //3.获取执行sql的对象
           pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.执行查询,不需要传递sql
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(rs, pstmt, conn);
        }
        return false;
    }
}
