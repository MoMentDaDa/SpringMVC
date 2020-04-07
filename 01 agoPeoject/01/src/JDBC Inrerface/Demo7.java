import Utils.JDBC_Utils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: JDBC
 * @description: 二进制
 * @author: Mr.Wang
 * @create: 2020-03-17 22:20
 **/
@SuppressWarnings("all")
public class Demo7 {
    @Test
    public void add() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBC_Utils.getConnection();
            String sql = "INSERT INTO test3 (blobtest) VALUES(?)";
            preparedStatement = connection.prepareStatement(sql);
            //获取文件的路径和文件对象
            String path = Demo6.class.getClassLoader().getResource("1.wmv").getPath();
            File file = new File(path);
            //调用方法
            preparedStatement.setBinaryStream(1, new FileInputStream(path), (int) file.length());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void read() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBC_Utils.getConnection();
            String sql = "SELECT * FROM test3";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //如果读取到数据，就把数据写到磁盘下
            if (resultSet.next()) {
                InputStream inputStream = resultSet.getBinaryStream("blobtest");
                FileOutputStream fileOutputStream = new FileOutputStream("d:\\aa.jpg");
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read(bytes)) > 0) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileOutputStream.close();
                inputStream.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(null, preparedStatement, connection);
        }
    }
}
