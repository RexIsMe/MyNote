package arithmetic.sort.swap;

/**
 * 交换类型排序算法
 *
 * @Author li zhiqang
 * @create 2020/12/8
 */
public class Common {
    
    public static void main(String[] args){
        int[] arr = {5,6,3,8,7,9,2,1,4};
//        int[] sort = BubbleSort.sort(arr);
        int[] sort = SelectSort.sort(arr);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
    
}
