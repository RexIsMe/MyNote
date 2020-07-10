package designpattern.creation.builder;

/**
 * @author Cytang
 * @title: MealBuilder
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:25
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
