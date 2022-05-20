package interview.question;

/**
 * @author Rex
 * @title: AboutString
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/2017:02
 */
public class AboutString {

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder("123");
//        StringBuilder reverse = sb.reverse();
//        System.out.println(reverse);

        System.out.println(LCS("1AB2345CD", "12345EF"));


    }

    /**
     * 求最长公共子串，没有返回"-1"
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS (String str1, String str2) {
        // write code here
        // 取出length较小的那个作为外层循环的字符串a,另一个就是字符串b
        String a = str1;
        String b = str2;
        if(str1.length() > str2.length()){
            a = str2;
            b = str1;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        // 以a中每个字符作为子串的开始，在b中比对，得到它的最长的公共子串，并与目前记录下的最长子串比较，保留较长着，直至a的最后一个字符
        String maxSubStr = "-1";
        int flag;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                flag = i;
                while(aChars[flag] == bChars[j]){
                    flag++;
                    j++;
                    if(flag >= a.length() || j >= b.length()){
                        break;
                    }
                }
                if(flag != i){
                    //进到while循环后，j已经+1了,再在for语句中+1就会跳过一个元素，造成错误
                    j--;
                    if(maxSubStr.length() <= a.substring(i, flag).length()){
                        maxSubStr = a.substring(i, flag);
                    }
                }
            }
        }
        return maxSubStr;
    }

    public static String LCS2 (String str1, String str2) {
        // write code here
        // 以a中每个字符作为子串的开始，在b中比对，得到它的最长的公共子串，并与目前记录下的最长子串比较，保留较长着，直至a的最后一个字符
        String maxSubStr = "-1";
        int flag;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                flag = i;
                while(str1.charAt(flag) == str2.charAt(j)){
                    flag++;
                    j++;
                    if(flag >= str1.length() || j >= str2.length()){
                        break;
                    }
                }
                if(flag != i){
                    //进到while循环后，j已经+1了,再在for语句中+1就会跳过一个元素，造成错误
                    j--;
                    if(maxSubStr.length() <= str1.substring(i, flag).length()){
                        maxSubStr = str1.substring(i, flag);
                    }
                }
            }
        }
        return maxSubStr;
    }

    /**
     * 动态规划解法
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS3(String str1, String str2){
        String maxSubStr = "-1";



        return maxSubStr;
    }


    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty() || s == null){
            return true;
        }

        int jIndex = 0;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            flag = false;
            for(int j = jIndex; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    flag = true;
                    jIndex = j + 1;
                    if(i == s.length() - 1){
                        return true;
                    }
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return false;
    }

}
