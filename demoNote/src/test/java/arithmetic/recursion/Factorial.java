package arithmetic.recursion;

/**
 * @author Cytang
 * @title: Factorial
 * @projectName demoNote
 * @description: 递归实现阶乘
 * @date 2020/7/1316:01
 */
public class Factorial {

    /** 计算n到1的阶乘 */
    private int calc(int n){
        if(n <= 1){
            return 1;
        }

        return n * calc(n-1);
    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.calc(5));
        System.out.println(factorial.calc(-5));
        System.out.println(factorial.calc(20));
    }


}
