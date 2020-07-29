package leetcode.label.dynamicprogramming;

import javax.swing.tree.TreeNode;

/**
 * @author Cytang
 * @title: MaxDepth
 * @projectName demoNote
 * @description: 求二叉树最大深度
 * @date 2020/7/289:06
 */
public class MaxDepth {

    public static void main(String[] args){

        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 2);
    }



    public static int maxDepth(Integer[] intArr){
        int result = 0;

        int maxIndex = 0;
        for (int i = 0; i < intArr.length; i++) {
            if(intArr[i] != null){
                maxIndex = i;
            }
        }

        int x = 0;
        while(true){
            maxIndex = maxIndex - (1 << x++);
            if(maxIndex <= 0){
                result = x;
                break;
            }
        }

        return result;
    }

}
