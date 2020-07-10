package utils.common;

import org.junit.Test;

/**
 * @author Cytang
 * @title: ConversionOfNumberSystem
 * @projectName demoNote
 * @description: TODO
 * @date 2020/6/3011:36
 */
public class ConversionOfNumberSystem {

    public static void main(String[] args) {

        System.out.println("把2,8,16的数字的字符串形式，转化为10进制：");
        System.out.println(Integer.parseInt("10", 10));
        System.out.println(Integer.parseInt("10", 2));
        System.out.println(Integer.parseInt("10", 8));
        System.out.println(Integer.parseInt("10", 16));
        System.out.println();

        System.out.println("把10进制，转化为2,8,16进制：");
        System.out.println(Integer.toString(10));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toOctalString(10));
        System.out.println(Integer.toHexString(10));
        System.out.println();

    }

    @Test
    public void test(){
        long l = Long.parseLong("33627150750002", 8);
        System.out.println(l);
        System.out.println(Long.toOctalString(Long.parseLong(String.valueOf(l))));
    }

}
