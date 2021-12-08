package arithmetic.cases;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断是否合法
 *
 * @Author li zhiqang
 * @create 2021/11/2
 */
public class IsLegal {

    public static void main(String[] args){
        String str = "{[()]}";
        System.out.println(isLegalForParentheses(str));
    }


    /**
     * 判断该字符串是否括号合法
     * 即括号成对出现且位子正确， 可能出现 {}、[]、()
     * @param str
     * @return
     */
    private static boolean isLegalForParentheses(String str){
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                list.add(chars[i]);
                continue;
            }
            if(chars[i] == ')'){
                if(list.size() == 0 || list.getLast() != '('){
                    return false;
                }
                list.removeLast();
                continue;
            }
            if(chars[i] == ']'){
                if(list.size() == 0 || list.getLast() != '['){
                    return false;
                }
                list.removeLast();
                continue;
            }
            if(chars[i] == '}'){
                if(list.size() == 0 || list.getLast() != '{'){
                    return false;
                }
                list.removeLast();
                continue;
            }
        }
        return list.size() == 0;
    }

}
