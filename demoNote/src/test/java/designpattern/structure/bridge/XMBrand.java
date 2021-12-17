package designpattern.structure.bridge;

import designpattern.structure.bridge.MobileBrand;

/**
 * @Author li zhiqang
 * @create 2021/12/10
 */
public class XMBrand extends MobileBrand {


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
