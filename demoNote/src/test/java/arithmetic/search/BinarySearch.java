package arithmetic.search;

import java.util.Arrays;

/**
 * @Author li zhiqang
 * @create 2021/11/2
 */
public class BinarySearch {

    public static void main(String[] args){

        int[] ints = {8,5,2,6,3,1,4,7,9};
        for (int i = 0; i < 11; i++) {
            System.out.println(isContains(ints, i));
        }

    }

    /**
     * 判断数组ints中是否包含元素k
     * @param ints
     * @param k
     * @return
     */
    private static boolean isContains(int[] ints, int k){
        if(ints.length == 0){
            return false;
        }

        Arrays.sort(ints);
        int mid = ints.length / 2;
        if (ints[mid] == k){
            return true;
        } else if(ints[mid] > k){
            return isContains(Arrays.copyOfRange(ints, 0, mid), k);
        } else {
            return isContains(Arrays.copyOfRange(ints, mid + 1, ints.length), k);
        }
    }

}
