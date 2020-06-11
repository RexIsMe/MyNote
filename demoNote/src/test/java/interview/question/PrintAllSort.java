package interview.question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Rex
 * @title: PrintAllSort
 * @projectName demoNote
 * @description: TODO
 * @date 2019/12/618:45
 */
public class PrintAllSort {


    public static void main(String[] args) {
        ArrayList<String> adv = Permutation("adv");
        for (String s : adv) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length()==0 ||str == null){
            return result;
        }
        PermutationHelper(str.toCharArray(),0,result);
        Collections.sort(result);
        return result;
    }
    private static void PermutationHelper(char[] chars,int i,ArrayList<String> result){
        //已经递归到了字符串最后一位，判断集合中有没有这个字符串，没有则加入
        if(i== chars.length-1){
            if(!result.contains(new String(chars))){
                result.add(new String(chars));
                return;
            }
        }else{
            //首次传进来的i为0，代表首位字符
            //依次处理i与i后面的每个字符(索引j)交换
            for(int j=i; j<chars.length; j++){
                swap(chars,i,j);//交换
                PermutationHelper(chars,i+1,result);//继续递归交换后的子串
                swap(chars,i,j);//还原
            }
        }
    }
    private static void swap(char[] chars,int i,int j){
        if(i != j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }


}
