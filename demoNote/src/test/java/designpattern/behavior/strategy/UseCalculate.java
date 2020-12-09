package designpattern.behavior.strategy;

/**
 * 计算的使用类
 * 策略模式的目的：对同类型的多种不同处理方式提供一种扩展性高的编码模板
 *
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
