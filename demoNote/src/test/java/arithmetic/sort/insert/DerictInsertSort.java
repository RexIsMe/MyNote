package arithmetic.sort.insert;

/**
 * 直接插入排序
 * 算法思想：选择一个元素作为有序数组，将剩余的元素依次插入到有序数组中
 *
 * @Author li zhiqang
 * @create 2020/12/8
 */
public class DerictInsertSort {

    /**
     * 算法实现
     * @return
     */
    public static int[] sort(int[] originalArray){
        int length = originalArray.length;
        int[] result = new int[length];
        result[0] = originalArray[0];

        for (int i = 1; i < originalArray.length; i++) {
            int ele = originalArray[i];
            for (int j = length - 1; j >= 0; j--) {
                if(result[j] == 0){
                    continue;
                } else if (ele > result[j]){
                    result[j+1] = result[j];
                    result[j] = ele;
                } else {
                    result[j+1] = ele;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        int[] test = {5,6,3,8,7,9,2,1,4};
        int[] sort = sort(test);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

}
