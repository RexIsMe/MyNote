package arithmetic.cases;

/**
 * 以字符串的形式给出 n , 以字符串的形式返回 n 的最小 好进制  。
 * 如果 n 的  k(k>=2) 进制数的所有数位全为1，则称 k(k>=2) 是 n 的一个 好进制 。
 * https://leetcode-cn.com/problems/smallest-good-base/
 *
 *
 * @Author li zhiqang
 * @create 2022/5/17
 */
public class MinWeight {

    public static void main(String[] args){

        String n = "4681";
//        System.out.println(smallestGoodBase(n));
        System.out.println(mySmallestGoodBase(n));

//        GoodBaseVal(5, 100000000);
    }


    public static String mySmallestGoodBase(String n) {
        // 枚举法查找符合的k，二分法优化查找速度

        long num = Long.valueOf(n);
        // 因为k >= 2;那就从2开始；先计算logn/log2并进1取值，该值为最大的位数
        int maxBit = (int)Math.ceil(Math.log(num)/Math.log(2));
        long left;
        long right;
        for(int i = maxBit; i > 1; i--){
            left = 2;
            right = num - 1;
            while(left < right){
                long mid = left + (right - left) / 2;
                long tmp = GoodBaseVal(i, mid);
                if(tmp == num){
                    return String.valueOf(mid);
                } else if(tmp == -1 || tmp > num){
                    // 如果left和right两边都做缩放的话，会导致有些值取不到
                    right = mid;
                } else {
                    // 根据计算mid的表达式，当left和right为连续两个数时，且这时候正好又走到left=mid，会导致无限循环
                    left = mid + 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

    public static String smallestGoodBase(String n) {
        //将字符串转为long类型
        long num = Long.parseLong(n);
        //求得数位1的最大数量，即转为2进制时对应的数量
        int mMax = (int) Math.ceil(Math.log(num) / Math.log(2));
        for(int i = mMax; i > 1; i--) {
            //二分法查找是否存在对应k进制，第一个找到存在的就是答案
            long left = 2;
            long right = num - 1;
            while(left < right) {
                long mid = left + (right - left) / 2;
                if(GoodBaseVal(i, mid) == num) return Long.toString(mid);
                //溢出时也说明要找的k进制比当前mid小
                if(GoodBaseVal(i, mid) == -1 || GoodBaseVal(i, mid) > num) right = mid;
                else left = mid + 1;
            }
            if(GoodBaseVal(i, left) == num) Long.toString(left);
        }
        return Long.toString(num - 1);
    }
    //求 数位1数量为 n , 进制为 k 时对应的值
    public static long GoodBaseVal(int n, long k) {
        long sum = 1;
        long cur = 1;
        for(int i = 1; i < n; i++) {
            //溢出时返回-1
            if(cur * k / k != cur)
                return -1;
            cur *= k;
            if(sum > Long.MAX_VALUE - cur) return -1;
            sum += cur;
        }
        return sum;
    }

}
