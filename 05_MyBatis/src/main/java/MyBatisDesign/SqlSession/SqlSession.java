package MyBatisDesign.SqlSession;

//自定义Mybatis中和数据库交互的核心类，它里面可以创建dao接口的代理对象
@SuppressWarnings("all")
public interface SqlSession {

    ///根据参数创建一个代理对象
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
