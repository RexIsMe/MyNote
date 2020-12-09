package arithmetic.sort.swap;

/**
 * 选择排序
 * 算法思路：没循环依次找到当前待排序数组的最值，直至待排序数组中元素个数为1
 *
 * @Author li zhiqang
 * @create 2020/12/8
 */
public class SelectSort {

    public static int[] sort(int[] originalArray){
        int length = originalArray.length;

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            max = originalArray[i];
            for (int j = i ; j < length; j++) {
                if(max < originalArray[j]){
                    max = originalArray[j];
                    maxIndex = j;
                }
            }
            originalArray[maxIndex] = originalArray[i];
            originalArray[i] = max;
        }

        return originalArray;
    }

}
