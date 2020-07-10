package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: VegBurger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:21
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }

}
