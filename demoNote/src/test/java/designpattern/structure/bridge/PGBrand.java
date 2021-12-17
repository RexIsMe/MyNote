package designpattern.structure.bridge;

/**
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class PGBrand extends MobileBrand {

    public void call(){
        mobileMenu.call();
    }

    public void video(){
        mobileMenu.video();
    }

    public void playGame(){
        mobileMenu.playGame();
    }
}
