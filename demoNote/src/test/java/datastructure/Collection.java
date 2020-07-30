package datastructure;

import java.util.HashSet;

/**
 * @author Cytang
 * @title: Collection
 * @projectName demoNote
 * @description: 集合
 * @date 2020/7/308:45
 */
public class Collection {

    public static void main(String[] args){

        HashSet<Integer> integers = new HashSet<>();
        integers.add(12121);
        integers.contains(121);
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());

    }

}
