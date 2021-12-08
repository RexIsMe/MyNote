package designpattern.structure.decorator;

/**
 * 牛仔裤
 *
 * @Author li zhiqang
 * @create 2021/12/2
 */
public class Jeans extends Finery {

    @Override
    public void wear() {
        super.wear();
        System.out.println("wear jeans");
    }
}
