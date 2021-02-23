package ThinkingInJava.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 【弄懂java 注解】
 *  自定义注解
 *
 * @Author li zhiqang
 * @create 2021/2/19
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String getValue() default "no description";

}
