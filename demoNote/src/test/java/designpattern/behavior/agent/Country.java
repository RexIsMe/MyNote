package designpattern.behavior.agent;

/**
 * @Author li zhiqang
 * @create 2021/12/14
 */
public abstract class Country {

    protected UnitedNations unitedNations;

    public void setUnitedNations(UnitedNations unitedNations){
        //TODO 这里为什么会访问不到啊？
//        this.unitedNations = unitedNations;
    }

}
