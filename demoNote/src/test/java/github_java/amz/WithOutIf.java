package github_java.amz;

/**
 * 一些替换if的情形
 *
 * @Author li zhiqang
 * @create 2021/7/14
 */
public class WithOutIf {

    public static void main(String[] args){
//        int[] arr = {1,2,3,257,258,259};
//        test1(arr);
//        test2(arr);
        int[] arr = {3,257};
        test3(arr);
    }

    /**
     * cpu执行if时会有分支预测，当预测错误时会舍弃之前错误分支的所有计算，造成计算资源浪费
     * @param arr
     */
    static void test1(int[] arr){
        long sum = 0L;
        for (int k = 0; k < 10000; k++){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 256)
                    sum += arr[i];
            }
        }
        System.out.println("sum : " + sum);
    }

    /**
     * 省去if判断
     *
     * 我们计算arr[i] - 256的值，并将其向右移动31位:
     * (arr[i] - 256) >> 31
     * 这样得到的数不是0 (0x00000000)，就是 -1 (0xffffffff)，然后我们对其取反，再次与上 arr[i] 即可：
     * sum += ~((arr[i] - 256) >> 31) & arr[i];
     * 也就是说如果arr[i] - 256 大于0 的话那么差值会与上 0xffffffff，其结果就是保持不变，否则会与上0，其结果就是sum会加上0，这样就不需要 if 判断了。
     *
     * @param arr
     */
    static void test2(int[] arr){
        long sum = 0L;
        for (int k = 0; k < 10000; k++){
            for (int i = 0; i < arr.length; i++) {
                sum += ~((arr[i] - 256) >> 31) & arr[i];
            }
        }
        System.out.println("sum : " + sum);
    }


    static void test3(int[] arr){
        long sum = 0L;
//        for (int k = 0; k < 10000; k++){
            for (int i = 0; i < arr.length; i++) {
                int i1 = (arr[i] - 256) >> 31;
                System.out.println("i1 : " + i1);
                int i2 = ~i1;
                System.out.println("i2 : " + i2);
                sum += i2 & arr[i];
            }
//        }
        System.out.println("sum : " + sum);
    }

}
