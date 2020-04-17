package Spring1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 @Configuration
@ComponentScan("Spring1")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("classpath:jdbcConfig.properties") //指定配置配置文件位置
@EnableTransactionManagement
public class SpringConfiguration {


}
