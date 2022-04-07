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


    /**
     * 网上获取的“插入排序”算法代码
     * @param arr
     */
    public static void sort2(int arr[]) {
        for(int i =1; i<arr.length;i++)
        {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i-1;
            //如果插入的数比被插入的数小
            while(index>=0&&insertVal<arr[index])
            {
                //将把 arr[index] 向后移动
                arr[index+1]=arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index+1]=insertVal;
        }
    }

    public static void main(String[] args){
        int[] test = {5,6,3,8,7,9,2,1,4};
//        test = sort(test);
        sort2(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

}
