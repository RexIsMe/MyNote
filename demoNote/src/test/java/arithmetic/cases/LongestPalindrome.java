package arithmetic.cases;

/**
 * 找到字符串中的最长回文子串
 * 回文串就是正着读和反着读都一样的字符串。比如说字符串 aba 和 abba 都是回文串
 *
 * @Author li zhiqang
 * @create 2020/12/14
 */
public class LongestPalindrome {

    public static void main(String[] args){
        String str = "12sadfsadfas12345678987654321ksajdhfkajf";
        System.out.println(getResult(str));
    }


    /**
     * 取得最长回文子串
     * 思路：
     * 定一个中心点，从这个中心点向两边扩散，返回
     * 注意：回文有aba 和 abba 奇偶两种类型，在定义中心点的时候分两种情况
     *
     * 时间复杂度：两个循环 O(N^2)
     * 空间复杂度：只需两个临时字符串存储过程值 O(N^2)
     *
     * @param str 原始字符串
     * @return
     */
    public static String getResult(String str){
        int length = str.length();
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < length; i++) {
            String palindrome1 = getPalindrome(str, i, i);
            temp1 = temp1.length() > palindrome1.length() ? temp1 : palindrome1;

            if(i < length - 1){
                String palindrome2 = getPalindrome(str, i, i + 1);
                temp2 = temp2.length() > palindrome2.length() ? temp2 : palindrome2;
            }
        }
        return temp1.length() > temp2.length() ? temp1 : temp2;
    }


    /**
     * 以左右下标对应元素作为中心点，向两边扩散得到回文串
     *
     * @param str
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static String getPalindrome(String str, int leftIndex, int rightIndex){
        char[] chars = str.toCharArray();
        while (leftIndex >= 0 && rightIndex < chars.length && chars[leftIndex] == chars[rightIndex]){
            leftIndex--;
            rightIndex++;
        }
        return str.substring(leftIndex + 1, rightIndex);
    }


}
