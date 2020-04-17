package Spring4.Config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("Spring4")
@Import(JdbcConfig.class) // 导入数据库配置文件
@PropertySource("classpath:jdbcConfig.properties") //指定配置配置文件位置
@EnableAspectJAutoProxy  //开启切面注解
public class SpringConfiguration {


}
