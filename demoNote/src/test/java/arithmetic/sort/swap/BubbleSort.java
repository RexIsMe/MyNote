package arithmetic.sort.swap;

/**
 * 冒泡排序
 * 算法思想：循环比较待排序数组的相邻元素，大/小的就交换位置，直到只剩一个未排序元素
 *
 * @Author li zhiqang
 * @create 2020/12/8
 */
public class BubbleSort {

    public static int[] sort(int[] originalArray){
        int length = originalArray.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++){
                if(originalArray[j] < originalArray[j+1]){
                    int temp = originalArray[j];
                    originalArray[j] = originalArray[j+1];
                    originalArray[j+1] = temp;
                }
            }
        }

        return originalArray;
    }

}
