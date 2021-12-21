package designpattern.behavior.order;

/**
 * 【命令模式】 是一种数据驱动的设计模式，它属于行为型模式。请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 *  解决问题：在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，比如需要对行为进行记录、撤销或重做、事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。
 *
 *
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class Common {

    public static void main(String[] args){

        //准备营业
        BarbecuerA barbecuerA = new BarbecuerA();
        BarbecuerB barbecuerB = new BarbecuerB();
        Waiter waiter = new Waiter();

        //客人A来了，3韭菜、2鸡翅、1茄子
        FragrantFlowerOrder fragrantFlowerOrder = new FragrantFlowerOrder(barbecuerA, 3);
        ChickenWingOrder chickenWingOrder = new ChickenWingOrder(barbecuerB, 2);
        EggPlantOrder eggPlantOrder = new EggPlantOrder(barbecuerA, 1);
        waiter.reciveCommand(fragrantFlowerOrder);
        waiter.reciveCommand(chickenWingOrder);
        waiter.reciveCommand(eggPlantOrder);

        //客人B来了，2韭菜、1鸡翅
        FragrantFlowerOrder fragrantFlowerOrder2 = new FragrantFlowerOrder(barbecuerA, 2);
        ChickenWingOrder chickenWingOrder2 = new ChickenWingOrder(barbecuerB, 1);
        waiter.reciveCommand(fragrantFlowerOrder2);
        waiter.reciveCommand(chickenWingOrder2);

        waiter.execute();

    }

}
