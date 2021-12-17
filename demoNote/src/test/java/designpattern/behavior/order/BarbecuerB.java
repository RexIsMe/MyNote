package designpattern.behavior.order;

/**
 * 烧烤师傅类
 *
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class BarbecuerB implements Barbecuer{

    public void fragrantFlower(){
        System.out.println("烤韭菜");
    }

    public void eggPlant(){
        System.out.println("烤茄子");
    }

    public void chickenWing(){
        System.out.println("烤鸡翅");
    }

}
