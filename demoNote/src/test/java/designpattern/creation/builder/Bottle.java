package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: Bottle
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:19
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
