import Utils.JDBC_Utils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: JDBC
 * @description: 大文本
 * @author: Mr.Wang
 * @create: 2020-03-17 22:20
 **/
@SuppressWarnings("all")
public class Demo6 {
    @Test
    public void add() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBC_Utils.getConnection();
            String sql = "INSERT INTO test2 (bigTest) VALUES(?) ";
            preparedStatement = connection.prepareStatement(sql);
            //获取到文件的路径
            String path = Thread.class.getClassLoader().getResource("BigTest").getPath();
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            //第三个参数，由于测试的Mysql版本过低，所以只能用int类型的。高版本的不需要进行强转
            preparedStatement.setCharacterStream(1, fileReader, (int) file.length());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(null, preparedStatement, connection);
        }


    }

    //读取大文本数据，通过ResultSet中的getCharacterStream()获取流对象数据
    @Test
    public void read() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBC_Utils.getConnection();
            String sql = "SELECT * FROM test2";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Reader reader = resultSet.getCharacterStream("bigTest");
                FileWriter fileWriter = new FileWriter("d:\\abc.txt");
                char[] chars = new char[1024];
                int len = 0;
                while ((len = reader.read(chars)) != -1) {
                    fileWriter.write(chars, 0, len);
                    fileWriter.flush();
                }
                fileWriter.close();
                reader.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(null, preparedStatement, connection);
        }
    }
}
