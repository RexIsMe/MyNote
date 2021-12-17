package designpattern.structure.bridge;

/**
 * @Author li zhiqang
 * @create 2021/12/10
 */
public abstract class MobileBrand {

    protected MobileMenu mobileMenu;

    public void setMobileMenu(MobileMenu mobileMenu){
        this.mobileMenu = mobileMenu;
    }
}
