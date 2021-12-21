package designpattern.behavior.order;

/**
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class FragrantFlowerOrder extends Command {

    private Barbecuer barbecuer;

    public void setBarbecuer(Barbecuer barbecuer){
        this.barbecuer = barbecuer;
    }

    public FragrantFlowerOrder(Barbecuer barbecuer, int num) {
        this.barbecuer = barbecuer;
        this.num = num;
    }

    @Override
    public void doIt() {
        for (int i = 0; i < num; i++) {
            barbecuer.fragrantFlower();
        }
    }

}
