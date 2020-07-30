package datastructure;

import java.util.LinkedList;

/**
 * @author Cytang
 * @title: LinkedTable
 * @projectName demoNote
 * @description: 链表
 * @date 2020/7/2916:30
 */
public class LinkedTable {

    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("asd");
        linkedList.set(0, "ws");
        String s = linkedList.get(0);
        System.out.println(linkedList.contains("ws"));
        System.out.println(linkedList.remove("ws"));

    }



}
