package designpattern.structure.proxy;

import java.lang.reflect.Proxy;

/**
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
