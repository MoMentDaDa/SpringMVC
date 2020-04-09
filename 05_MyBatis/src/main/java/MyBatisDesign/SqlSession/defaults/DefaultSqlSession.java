package MyBatisDesign.SqlSession.defaults;

import MyBatisDesign.Configuration.Configuration;
import MyBatisDesign.SqlSession.Proxy.MapperProxy;
import MyBatisDesign.SqlSession.SqlSession;
import MyBatisDesign.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@SuppressWarnings("all")
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    // 用于创建代理对象
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
    }

    // 用于释放资源
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
