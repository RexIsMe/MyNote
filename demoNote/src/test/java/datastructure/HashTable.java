package datastructure;

import java.util.HashMap;

/**
 * @author Cytang
 * @title: HashTable
 * @projectName demoNote
 * @description: 散列表
 * @date 2020/7/308:52
 */
public class HashTable {

    public static void main(String[] args){
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "adsdf");
        System.out.println(integerStringHashMap.get(1));
        System.out.println(integerStringHashMap.size());
    }

}
