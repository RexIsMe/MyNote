package designpattern.structure.proxy;

import java.lang.reflect.Proxy;

/**
 * 【代理模式】
 * 理解：为被代理类扩展功能
 * 有点：不用以实现的方式造成不必要的耦合和抽象上的费解
 *
 *
 * @Author li zhiqang
 * @create 2021/1/22
 */
public class Common {

    public static void main(String[] args){
        //静态代理使用
        StudentService studentService1 = new StudentService();
        StudentServiceProxy studentServiceProxy = new StudentServiceProxy(studentService1);
        studentServiceProxy.insertStudent();
        studentServiceProxy.deleteStudent();

        //动态代理使用
        StudentService studentService2 = new StudentService();
        DynamicProxy dynamicProxy = new DynamicProxy(studentService2);
        IStudentService iStudentServiceProxy = (IStudentService)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), StudentService.class.getInterfaces(), dynamicProxy);
        iStudentServiceProxy.insertStudent();
        iStudentServiceProxy.deleteStudent();
    }

}
