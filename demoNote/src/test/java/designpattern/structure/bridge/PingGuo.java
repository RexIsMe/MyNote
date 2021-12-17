package designpattern.structure.bridge;

/**
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class PingGuo implements MobileMenu {
    @Override
    public void call() {
        System.out.println("苹果手机 call");
    }

    @Override
    public void video() {
        System.out.println("苹果手机 video");
    }

    @Override
    public void playGame() {
        System.out.println("苹果手机 playGame");
    }
}
