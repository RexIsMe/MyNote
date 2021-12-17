package com.example.demo.create;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author li zhiqang
 * @create 2021/12/14
 */
public class CreateByClone {

    //TODO 为什么这里clone出来的对象和被克隆的对象的hashcode相等，但是又能互不影响呢
    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        Employee employee1 = new Employee();
        employee1.setName("rex");
        employee1.setSalary(28000D);
        employee1.setTime(new Date());
        Employee employee2 = new Employee();
        employee2.setName("rex2");
        employee2.setSalary(38000D);
        employee2.setTime(new Date());
        employee1.setEmployee(employee2);
        System.out.println(employee1);
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println(employee1.getName().hashCode());
        System.out.println(employee1.getSalary().hashCode());
        System.out.println(employee1.getTime().hashCode());



        Employee clone = (Employee)employee1.clone();
        System.out.println(clone);
        System.out.println(clone.hashCode());
        System.out.println(clone.getName().hashCode());
        System.out.println(clone.getSalary().hashCode());
        System.out.println(clone.getTime().hashCode());

        System.out.println(clone.equals(employee1));
        System.out.println("-------------------------------");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee employee3 = new Employee();
        employee3.setName("rex3");
        employee3.setSalary(49000D);
        employee3.setTime(new Date());
        employee1.setTime(simpleDateFormat.parse("2020-04-22"));
        employee1.setEmployee(employee3);

        System.out.println(employee1);
        System.out.println(clone);
    }


}

@Data
class Employee implements Cloneable{

    private String name;
    private Double salary;
    private Date time;
    private Employee employee;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
//        Employee employee =  (Employee)super.clone();
//        employee.time = (Date)time.clone();
//        return employee;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", salary=" + salary +
//                ", time=" + time +
//                ", employee=" + employee +
//                '}';
//    }
}
