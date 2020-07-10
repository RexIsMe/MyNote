package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: ChickenBurger
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:21
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }

}
