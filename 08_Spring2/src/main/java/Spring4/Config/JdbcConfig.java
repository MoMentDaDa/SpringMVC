package Spring4.Config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

// spring 连接数据库相关的配置类，相当于子配置类
public class JdbcConfig {
    // 利用 EL 给属性值注入
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // 用于创建一个QueryRunner对象
    @Bean(name = "myRunner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }


    // 创建数据源对象，模拟两个数据源的情况
    @Bean(name = "ds1")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
