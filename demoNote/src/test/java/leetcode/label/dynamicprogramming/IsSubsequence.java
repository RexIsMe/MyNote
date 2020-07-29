package leetcode.label.dynamicprogramming;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cytang
 * @title: IsSubsequence
 * @projectName demoNote
 * @description: 动态规划
 * @date 2020/7/2710:32
 */
public class IsSubsequence {

    public static void main(String[] args){
        String str1 = "b";
        String str2 = "c";
//        System.out.println(isSubsequence(str2, str1));

        String str3 = "abb";
//        System.out.println(longestPalindrome(str3));
        System.out.println(longestPalindrome2(str3));
    }


    public boolean isMatch2(String s, String p) {
        // S串当前下标位置，刚开始为0
        int index = 0;
        // 下一个状态集合
        // 这里状态用p串的下标表示，代表下一次可以从p的这些下标开始匹配
        Set<Integer> nextState = new HashSet<>();
        // 由于是刚开始匹配，这时候p下一个下标是0
        nextMatch(p, 0, nextState);
        // nextState不为空时，表示还有合法的下一个状态，匹配继续
        while (!nextState.isEmpty()){
            // 当前状态就是上一次的nextState
            Set<Integer> nowState = nextState;
            // 创建新的nextState
            nextState = new HashSet<>();
            // 测试s[index]和集合里的状态是否有匹配
            for (int state : nowState){
                // 如果同时到达s和p串末尾，匹配成功
                if (state >= p.length() && index >= s.length()){
                    return true;
                }
                // 仅仅p到达末尾还不行
                else if (state >= p.length()){
                    continue;
                }
                // s和p都未到达末尾
                else if (index < s.length()){
                    // 这里是匹配上的情况
                    if (p.charAt(state) == '.' || s.charAt(index) == p.charAt(state)){
                        // 如果p串的下一个字符是'*'，当前状态可以匹配任意多次，所以下一个状态还是当前
                        if (state+1 < p.length() && p.charAt(state+1) == '*'){
                            nextMatch(p, state, nextState);
                        }
                        // 否则，下一个状态就是state+1
                        else {
                            nextMatch(p, state+1, nextState);
                        }
                    }
                }
            }
            index++;
        }
        // 此时，nextState为空，代表没有合法的下一个状态了，匹配失败
        return false;
    }

    // p:正则表达式
    // state:下一个状态
    // nextState:下一个状态集合，无重复
    private void nextMatch(String p, int state, Set<Integer> nextState){
        // 首先加上下一个状态到状态集中
        nextState.add(state);
        // 这里是判断下一个字符是'*'的情况，由于此时匹配次数可以是0，所以state+2也是合法的下一个状态
        if (state+1 < p.length() && p.charAt(state+1) == '*'){
            nextMatch(p, state+2, nextState);
        }
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean result = Boolean.FALSE;
//
//        if(p.equals(".*")){
//            return result;
//        }
//
//        //拿到s、p的字符数组，遍历根据'.'和'*'的规则比较对应位置的字符是否相等
//        //拿到p中“.*”的下标，
//        char[] sChars = s.toCharArray();
//        char[] pChars = p.toCharArray();
//        char pChar;
//        int sIndex = 0;
//        for (int i = 0; i < pChars.length; i++) {
//            pChar = pChars[i];
//            if(pChar == '.'){
//                sIndex++;
//            } else if(pChar == '*') {
//                if(pChars[i - 1] == '.'){
//                    pIndex++;
//                }
//            } else if(pChar == sChars[sIndex]){
//
//            }
//
//        }
//
        return result;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *  中心展开法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(s == null || s.length() ==0){
            return "";
        }

        if(s.length() ==1){
            return s;
        }

        char[] chars = s.toCharArray();
        int length = chars.length;
        String result = String.valueOf(chars[0]);
        boolean flag0, flag1;
        int m, n;
        int leftLength, rightLength, lessSide;
        for (int i = 0; i < length; i++) {
            //每次循环时判断一次当前取得结果的长度是否大于可能取得的结果长度
            leftLength = i;
            rightLength = length - i;
            lessSide = leftLength < rightLength ? leftLength : rightLength;
            if(lessSide >= 1 && result.length() >= 2 * lessSide + 1){
                continue;
            }


            m = i;
            n = i + 1;
            //无“中心”
            while(m >= 0 && n < length){
                if(chars[m] != chars[n]){
                    String substring = s.substring(m + 1, n);
                    result = result.length() < substring.length() ? substring : result;
                    break;
                }

                if(m - 1 < 0 || n + 1 >= length){
                    String substring = s.substring(m, n + 1);
                    result = result.length() < substring.length() ? substring : result;
                    break;
                }

                m--;
                n++;
            }

            //有“中心”
            m = i - 1;
            n = i + 1;
            while(m >= 0 && n < length){
                if(chars[m] != chars[n]){
                    String substring = s.substring(m + 1, n);
                    result = result.length() < substring.length() ? substring : result;
                    break;
                }

                if(m - 1 < 0 || n + 1 >= length){
                    String substring = s.substring(m, n + 1);
                    result = result.length() < substring.length() ? substring : result;
                    break;
                }

                m--;
                n++;
            }
        }

        return result;
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if(s == null){
            return "";
        }

        if(s.length() == 0 || s.length() == 1){
            return s;
        }

        //拿到S的顺序和倒序字符数组
        char[] sChars = s.toCharArray();
        String result = String.valueOf(sChars[0]);
        int length = sChars.length;

        //遍历s字符数组，顺序取每一个字符倒序与每一个字符比对
        //如果不等，下一个
        //如果相等，比较顺序和倒序的下一个字符，直到两个字符的下标相等或者相邻
        boolean flag;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if(sChars[i] == sChars[j]){
                    int m = i;
                    int n = j;
                    flag = Boolean.TRUE;
                    while(n > m){
                        if(sChars[m++] != sChars[n--]){
                            flag = Boolean.FALSE;
                            break;
                        }
                    }

                    //找到一个回文子串
                    if(flag){
                        String substring = s.substring(i, j + 1);
                        result = result.length() < substring.length() ? substring : result;
                        //比较剩余的未遍历子串长度与当前结果长度
                        if(length - i < result.length()){
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }



    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return Boolean.TRUE;
        }

        boolean result = Boolean.FALSE;

        //拿到s、t的字符数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int length = s.length();

        //遍历t的字符数组，并与s的字符数组一个一个比较，
        // 相同则比较s字符数组的下一个，不同则重新开始比较s的第一个字符，知道比对到s的最后一个字符，或者t的末尾
        int sIndex = 0;
        for (char tChar : tChars) {
            if(tChar == sChars[sIndex]){
                sIndex++;
            }

            if(sIndex == length){
                result = Boolean.TRUE;
                break;
            }
        }

        return result;
    }


}
