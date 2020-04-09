package MyBatisDesign.SqlSession;


import MyBatisDesign.Configuration.Configuration;
import MyBatisDesign.SqlSession.defaults.DefaultSqlSessionFactory;
import MyBatisDesign.utils.XMLConfigBuilder;

import java.io.InputStream;

//用于创建一个SqlSessionFactory对象
@SuppressWarnings("all")
public class SqlSessionFactoryBuilder {
    //根据参数的字节输入流来构建一个SqlSessionFactory工厂
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
