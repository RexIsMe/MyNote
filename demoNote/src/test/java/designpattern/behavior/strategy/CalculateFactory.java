package designpattern.behavior.strategy;

/**
 * @Author li zhiqang
 * @create 2021/12/2
 */
public class CalculateFactory {

    public Calculate getCalc(String calculateName){
        Calculate calculate = null;
        switch (calculateName){
            case "add":
                calculate = new AddCalculate();
                break;
            case "sub":
                calculate = new Subtraction();
                break;
            default:
                break;
        }
        return calculate;
    }

}
