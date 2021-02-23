package ThinkingInJava.annotation;

/**
 * 【弄懂java 注解】
 *  使用注解
 *
 * @Author li zhiqang
 * @create 2021/2/19
 */
@MyAnnotation(getValue = "on class")
public class Demo {

    @MyAnnotation(getValue = "on field")
    public String name;

    @MyAnnotation(getValue = "on method")
    public void hello(){}

    @MyAnnotation()
    public void defaultMethod(){}

}
