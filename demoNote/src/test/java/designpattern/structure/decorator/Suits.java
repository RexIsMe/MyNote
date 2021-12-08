package designpattern.structure.decorator;

/**
 * 套装
 *
 * @Author li zhiqang
 * @create 2021/12/2
 */
public class Suits extends Finery {

    @Override
    public void wear() {
        super.wear();
        System.out.println("wear suits");
    }
}
