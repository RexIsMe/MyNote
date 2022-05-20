package interview.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author li zhiqang
 * @create 2022/5/12
 */
public class AboutArray {

    public static void main(String[] args){
//        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
//        rotate(nums, k);
//        for(int i = 0; i < nums.length; i++){
//            System.out.println(nums[i]);
//        }


        // ==============================================

        // 给出指定数值的所有连续数组
        int target = 15;
        int[][] continuousSequence = findContinuousSequence(target);
        for (int i = 0; i < continuousSequence.length; i++) {
            if(continuousSequence[i] == null){
                return;
            }
            for (int j = 0; j < continuousSequence[i].length; j++) {
                System.out.print(continuousSequence[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void rotate(Integer[] nums, int k) {
        int len = nums.length;
        Integer[] newNums = new Integer[len];
        for(int i = 0; i < k; i++){
            newNums[i] = nums[len - k + i];
        }
        for(int i = 0; i < len - k; i++){
            newNums[k + i] = nums[i];
        }
//        for(int i = 0; i < len; i++){
//            System.out.println(newNums[i]);
//        }
        nums = newNums;
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }


    public static int[][] findContinuousSequence(int target) {
        // 使用滑动窗口（或双指针）暴力检索;窗口由大到小，从左向右步长为1滑动
        int mid = target/2 + 1;
        int[][] result =  new int[mid][];
        int index = 0;

        int left;
        int right;
        for(int i = 0; i <= mid; i++){
            left = 1;
            right = mid;
            right -= i;

            // 快速判断这种条件下是否可能
            if(right * (right + 1) / 2 > target){
                continue;
            }
            while(right <= mid){
                int sum = 0;
                for(int j = left; j <= right; j++){
                    sum += j;
                }
                if(sum > target){
                    break;
                }
                if(sum == target){
                    int[] tmp = new int[right - left + 1];
                    for(int j = left; j <= right; j++){
                        tmp[j-left] = left + (j - left);
                    }
                    result[index] = tmp;
                    index++;
                    break;
                }

                left++;
                right++;

            }
        }

        int[][] result1 = new int[index][];
        for(int i = 0; i < index; i++){
            result1[i] = result[i];
        }

        return result1;
    }

    // 思路牛叉
    public int[][] findContinuousSequence2(int target) {
        List<int[]> resultList = new ArrayList<int[]>();
        int l = 1;
        int r = 1;
        int sum = 0;
        while(l <= target/2){
            if(sum < target){
                sum += r;
                r++;
            } else if(sum > target){
                sum -= l;
                l++;
            } else {
                int len = r - l + 1;
                int[] tmp = new int[len];
                for(int i = 0; i < len; i++){
                    tmp[i] = l + i;
                }
                resultList.add(tmp);
                sum += r;
                r++;
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

}
