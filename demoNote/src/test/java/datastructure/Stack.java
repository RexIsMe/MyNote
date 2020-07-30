package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cytang
 * @title: Stack
 * @projectName demoNote
 * @description: 栈
 * @date 2020/7/2916:51
 */
public class Stack {

    public static void main(String[] args){

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        Integer pop = stack.pop();
        Integer peek = stack.peek();


    }

}
