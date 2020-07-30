package datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Cytang
 * @title: Queue
 * @projectName demoNote
 * @description: 队列
 * @date 2020/7/2916:45
 */
public class Queue {

    public static void main(String[] args){
        Deque<Integer> integerDeque = new LinkedList<>();
        integerDeque.offer(122);
        integerDeque.add(122);

        Integer poll = integerDeque.poll();
        Integer remove = integerDeque.remove();

        Integer peek = integerDeque.peek();
        Integer element = integerDeque.element();

    }

}
