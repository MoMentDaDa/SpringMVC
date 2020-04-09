package MyBatisDesign.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 查询的注解

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@SuppressWarnings("all")
public @interface Select {
    String value();
}
