package arithmetic.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * https://leetcode.cn/problems/generate-parentheses/
 *
 *
 * @Author li zhiqang
 * @create 2022/5/18
 */
public class GenerateBrecket {

    public static void main(String[] args){
        try {

        } catch (Exception e){
            e.printStackTrace();
        }
        int n = 3;
        List<String> strings = generateParenthesis(n);
//        List<String> strings = generateParenthesis1(n);
        System.out.println("=====================");
        strings.forEach(e ->System.out.println(e));

//        System.out.println("()".substring(0,1));
    }

    public static List<String> generateParenthesis1(int n){
        if (n == 1){
            return Arrays.asList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis1(n - 1)){
            for (int i = 0; i <= str.length()/2; i++) {
                set.add(str.substring(0,i) + "()" + str.substring(i,str.length()));
            }
        }
        return new ArrayList<>(set);

    }


    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            System.out.println(new String(current));
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
