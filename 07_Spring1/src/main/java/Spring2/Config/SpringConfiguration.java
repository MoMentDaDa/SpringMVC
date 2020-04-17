package Spring2.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Spring2")
@Import(JdbcConfig.class) // 导入数据库配置文件
@PropertySource("classpath:jdbcConfig.properties") //指定配置配置文件位置
public class SpringConfiguration {


}
