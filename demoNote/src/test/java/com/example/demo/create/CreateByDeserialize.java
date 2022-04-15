package com.example.demo.create;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author li zhiqang
 * @create 2021/12/14
 */
public class CreateByDeserialize {

    /**
     * Java对象的序列化与反序列化
     */
    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 30, 170);
        Person lisi = new Person("lisi", 35, 175);
        Person wangwu = new Person("wangwu", 28, 178);

        String path = CreateByDeserialize.class.getResource("/").getPath();
        System.out.println(path);
        //序列化
        ObjectOutputStream out = null;
        try {
        //需要一个文件输出流和对象输出流；文件输出流用于将字节输出到文件，对象输出流用于将对象输出为字节
            out = new ObjectOutputStream(new FileOutputStream(path + "/person.ser"));
            out.writeObject(zhangsan);
            out.writeObject(lisi);
            out.writeObject(wangwu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //反序列化
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(path + "/person.ser"));
            Person one = (Person) in.readObject();
            Person two = (Person) in.readObject();
            Person three = (Person) in.readObject();
            System.out.println("name:" + one.name + " age:" + one.age + " height:" + one.height);
            System.out.println("name:" + two.name + " age:" + two.age + " height:" + two.height);
            System.out.println("name:" + three.name + " age:" + three.age + " height:" + three.height);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Person implements Serializable {
    int age;
    int height;
    String name;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
