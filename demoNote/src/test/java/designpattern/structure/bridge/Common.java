package designpattern.structure.bridge;

/**
 * 【桥接模式】是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
 *
 *  具体到《大话设计模式》中手机品牌和手机功能的例子，因为品牌和功能都是会发生变化的，为了避免出现变化时的互相影响，手机功能和品牌就不建议通过继承来拥有对象的功能；
 *  更好的方式是通过组合/聚合的方式，一方持有另一方的对象，通过对象来实现功能，这样才满足开闭原则
 *
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class Common {

    public static void main(String[] args){
        XMBrand xmBrand = new XMBrand();
        xmBrand.setMobileMenu(new XiaoMi());
        xmBrand.call();
        xmBrand.video();
        xmBrand.playGame();

        PGBrand pgBrand = new PGBrand();
        pgBrand.setMobileMenu(new PingGuo());
        pgBrand.call();
        pgBrand.video();
        pgBrand.playGame();
    }

}
