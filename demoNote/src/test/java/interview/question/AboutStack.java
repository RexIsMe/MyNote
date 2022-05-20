package interview.question;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author li zhiqang
 * @create 2022/5/11
 */
public class AboutStack {

    public static void main(String[] args){
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 2, 1};
        System.out.println(judgePossible(pushed, popped));


    }

    /**
     * 判断poped数组是否可能是pushed数组对应压栈顺序的出栈顺序
     * 解体思路：
     *      使用模拟法，按pushed数组的顺序依次将元素压栈，在这个操作过程中同时根据poped数组顺序判断是否是可能的出栈顺序，直至poped数组为空，否则返回false
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean judgePossible(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
