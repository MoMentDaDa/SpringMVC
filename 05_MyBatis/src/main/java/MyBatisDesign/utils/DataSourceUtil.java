package MyBatisDesign.utils;


import MyBatisDesign.Configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

// 用于创建数据源的工具类
@SuppressWarnings("all")
public class DataSourceUtil {

    //用于获取一个连接
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
