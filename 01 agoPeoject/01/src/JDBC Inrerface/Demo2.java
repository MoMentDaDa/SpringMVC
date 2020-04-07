import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * @program: JDBC DQL 操作
 * @description: 2
 * @author: Mr.Wang
 * @create: 2020-03-11 11:45
 **/
@SuppressWarnings("all")
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "will", "will1234");
        String sql = "select * from user";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        //6.处理结果
        rs.next();
        //6.2 获取数据
        int id1 = rs.getInt(1);
        String name = rs.getString("name");
        int age = rs.getInt("age");
        Date d = rs.getDate("born_date");
        System.out.println(id1 + "---" + name + "---" + age + "---" + d);

        rs.next();
        int id2 = rs.getInt(1);
        String name2 = rs.getString("name");
        int age2 = rs.getInt("age");
        Date d2 = rs.getDate("born_date");

        System.out.println(id2 + "---" + name2 + "---" + age2 + "---" + d2);

        //循环判断游标是否是最后一行末尾,从而获取数据，如果前面移动了指针，后面将不会从头再来
        while (rs.next()) {
            int id3 = rs.getInt(1);
            String name3 = rs.getString("name");
            int age3 = rs.getInt("age");
            Date d3 = rs.getDate("born_date");
            System.out.println(id3 + "---" + name3 + "---" + age3 + "---" + d3);

        }
        //8.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }
}
