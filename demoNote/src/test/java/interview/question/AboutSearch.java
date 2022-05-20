package interview.question;

import java.util.Arrays;

/**
 * @Author li zhiqang
 * @create 2022/5/11
 */
public class AboutSearch {

    public static void main(String[] args){
        int[] a = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(a, 9));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid;
        while(low < high){
            mid = (high - low)/2 + low;

            if(isBadVersion(mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //防止代码报错而已...
    private boolean isBadVersion(int index){
        // TODO ...
        return false;
    }


    /**
     * 从数组中查找目标元素
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
