package designpattern.creation.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cytang
 * @title: Meal
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:24
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }

}
