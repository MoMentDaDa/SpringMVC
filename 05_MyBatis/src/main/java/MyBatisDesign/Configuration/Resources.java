package MyBatisDesign.Configuration;

import java.io.InputStream;

//使用类加载器读取配置文件的类
@SuppressWarnings("all")
public class Resources {
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
