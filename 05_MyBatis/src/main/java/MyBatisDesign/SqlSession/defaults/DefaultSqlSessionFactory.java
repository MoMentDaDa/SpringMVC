package MyBatisDesign.SqlSession.defaults;


import MyBatisDesign.Configuration.Configuration;
import MyBatisDesign.SqlSession.SqlSession;
import MyBatisDesign.SqlSession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    // 用于创建一个新的操作数据库对象
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
