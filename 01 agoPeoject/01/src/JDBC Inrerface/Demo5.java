import Utils.JDBC_Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: JDBC
 * @description: 其他补充
 * @author: Mr.Wang
 * @create: 2020-03-17 22:20
 **/
@SuppressWarnings("all")
public class Demo5 {
    public static void main(String[] args) throws SQLException {
        /*
         * Statement执行批处理
         * 优点：
         *       可以向数据库发送不同的SQL语句
         * 缺点：
         *       SQL没有预编译
         *       仅参数不同的SQL，需要重复写多条SQL
         * */
        Connection connection = JDBC_Utils.getConnection();
        Statement statement = connection.createStatement();
        String sql1 = "UPDATE users SET name='zhongfucheng' WHERE id='3'";
        String sql2 = "INSERT INTO users (id, name, password, email, birthday)" +
                " VALUES('5','nihao','123','ss@qq.com','1995-12-1')";
        //将sql添加到批处理
        statement.addBatch(sql1);
        statement.addBatch(sql2);
        //执行批处理
        statement.executeBatch();
        //清空批处理的sql
        statement.clearBatch();

        /*
         * PreparedStatement批处理
         *   优点：
         *       SQL语句预编译了
         *       对于同一种类型的SQL语句，不用编写很多条
         *   缺点：
         *       不能发送不同类型的SQL语句
         *
         * */
        Connection connection2 = JDBC_Utils.getConnection();
        String sql = "INSERT INTO test(id,name) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 1; i <= 205; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, (i + "zhongfucheng"));
            //添加到批处理中
            preparedStatement.addBatch();
            if (i % 2 == 100) {
                //执行批处理
                preparedStatement.executeBatch();
                //清空批处理【如果数据量太大，所有数据存入批处理，内存肯定溢出】
                preparedStatement.clearBatch();
            }
        }
        //不是所有的%2==100，剩下的再执行一次批处理
        preparedStatement.executeBatch();
        //再清空
        preparedStatement.clearBatch();
        JDBC_Utils.close(null,preparedStatement,connection2);
    }
}
