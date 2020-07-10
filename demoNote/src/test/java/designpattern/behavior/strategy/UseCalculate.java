package designpattern.behavior.strategy;

/**
 * 计算的使用类
 * @author Rex
 */
public class UseCalculate {

    private Calculate calculate;

    public UseCalculate(Calculate calculate) {
        this.calculate = calculate;
    }

    public String cal(int a, int b){
        return calculate.cal(a, b);
    }

    public String cal(double a, double b){
        return calculate.cal(a, b);
    }


    public static void main(String[] args) {

        UseCalculate useCalculate1 = new UseCalculate(new AddCalculate());
        UseCalculate useCalculate2 = new UseCalculate(new Subtraction());


        System.out.println(useCalculate1.cal(1, 2));
        System.out.println(useCalculate2.cal(1, 2));


    }

}
