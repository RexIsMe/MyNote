package arithmetic.interestingcase;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组，记录的是某只股票的历史价格，求获取最大利润的买入、卖出点
 *
 * @Author li zhiqang
 * @create 2020/12/10
 */
public class StockProfit {

    public static void main(String[] args){
        int[] arr = {9,2,7,4,3,1,8,4};
//        System.out.println(getMaxProfit1(arr));
        List<Target> maxProfit2 = getMaxProfit2(arr);
        int profit = 0;
        for (int i = 0; i < maxProfit2.size(); i++) {
            System.out.println(maxProfit2.get(i));
            profit += maxProfit2.get(i).getProfit();
        }
        System.out.println(profit);

        System.out.println(maxProfitFor2TimeV2(arr, 2));

//
//        int[] arr1 = {1,2,4,8,3,9,6,7};
//        int[][] ints = maxProfitFor2Time(arr1);
//        int rowNum = ints.length;
//        int columeNum = ints[0].length;
//        for (int i = 0; i < rowNum; i++) {
//            for (int j = 0; j < columeNum; j++) {
//                System.out.print(ints[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    /**
     * 前提：卖出点必须在买入点之后;限制只能买入、卖出一次
     * 思路：遍历数组，找到当前为止的价格最小值，并假设当前价格为卖出价格，计算利润，并记录利润最大时的买入、卖出点
     *
     * @param originalArray
     * @return
     */
    public static Target getMaxProfit1(int[] originalArray){
        Target target = new Target();
        target.setMin(originalArray[0]);
        target.setMinIndex(0);
        target.setProfit(0);
        for (int i = 0; i < originalArray.length; i++) {
            int tempSale = originalArray[i];
            //更新最小值
            if(target.getMin() >= tempSale){
                target.setMin(tempSale);
                target.setMinIndex(i);
                continue;
            }

            //比较利润
            int tempProfit = tempSale - target.getMin();
            if(tempProfit > target.getProfit()){
                target.setProfit(tempProfit);
                target.setSaleIndex(i);
                target.setSale(tempSale);
            }
        }
        return target;
    }


    /**
     * 不限买卖次数
     * 思路：按顺序找到相邻的相对最小最大值，然后求利润和
     *
     * @return
     */
    public static List<Target> getMaxProfit2(int[] originalArray){
        if (originalArray.length < 2){
            return Collections.emptyList();
        }

        List<Target> targetList = new ArrayList<>();
        int tempMin = originalArray[0];
        int minIndex = 0;
        int tempMax = 0;
        int maxIndex = 0;
        for (int i = 1; i < originalArray.length; i++) {
            int currentVal = originalArray[i];
            //边界情况：遍历到倒数第二天时
            if(i == originalArray.length - 1){
                if (currentVal > tempMin){
                    if(currentVal > tempMax){
                        tempMax = currentVal;
                        maxIndex = i;
                    }

                    Target target = new Target();
                    target.setMin(tempMin);
                    target.setSaleIndex(minIndex);
                    target.setSale(tempMax);
                    target.setSaleIndex(maxIndex);
                    target.setProfit(tempMax - tempMin);
                    targetList.add(target);
                }
            } else {
                //找到相对最低点和最高点，当做一次买入、卖出
                if(currentVal < tempMin){
                    tempMin = currentVal;
                    minIndex = i;
                } else if(currentVal > tempMax) {
                    tempMax = currentVal;
                    maxIndex = i;
                } else {
                    Target target = new Target();
                    target.setMin(tempMin);
                    target.setMinIndex(minIndex);
                    target.setSale(tempMax);
                    target.setSaleIndex(maxIndex);
                    target.setProfit(tempMax - tempMin);
                    targetList.add(target);

                    tempMin = currentVal;
                    tempMax = currentVal;
                    minIndex = i;
                    maxIndex = i;
                }
            }
        }
        return targetList;
    }


    /**
     * 限制2次交易，求最大收益
     * 动态规划来分析该需求：
     * 【1、确定相关变量，定义状态方程】
     * 因为限制交易两次，设置状态为m,则m的5中情形,分别是：0:没有发生买卖、1:第一次买入、2:第一次卖出、3:第二次买入、4:第二次卖出
     * 设置股票数据天数为n，则有最大收益F = f(m, n)  条件：m 属于（0,1,2,3,4）；n > 1
     *
     * 首先分析初始化状态
     * 【2、得到初始值】
     * 当不发生任何买卖，即m = 0时，不论有多少天的数据，总有收益F = f(0, n) = 0;
     *
     * 【3、分析情况，找到状态方程】
     * 再来分析第n天的情形, p(n) 为第n天买入/卖出的价格
     * 第n天可以做操作也可以不做操作，基于前面n-1天的操作情况，分为以下9种
     * 1、当 n-1 的m = 0时，第n天当天也不做操作，有F = f(0, n) = 0
     * 2、当 n-1 的m = 0时，第n天当天做操作即第一次买入，m = 1，有F = f(1, n) = f(0, n-1) - p(n)
     * 3、当 n-1 的m = 1时，第n天当天不做操作，有F = f(1, n) = f(1, n-1)
     * 4、当 n-1 的m = 1时，第n天当天做操作即第一次卖出，m = 2，有F = f(2, n) = f(1, n-1) + p(n)
     * 5、当 n-1 的m = 2时，第n天当天不做操作，有F = f(2, n) = f(2, n-1)
     * 6、当 n-1 的m = 2时，第n天当天做操作即第一次卖出，m = 3，有F = f(3, n) = f(2, n-1) - p(n)
     * 7、当 n-1 的m = 3时，第n天当天不做操作，有F = f(3, n) = f(3, n-1)
     * 8、当 n-1 的m = 3时，第n天当天做操作即第一次卖出，m = 4，有F = f(4, n) = f(3, n-1) + p(n)
     * 5、当 n-1 的m = 4时，第n天当天不能做操作（因为只允许2次买卖），有F = f(4, n) = f(4, n-1)
     *
     * 合并【2,3】【4,5】【6,7】【8,9】,得到：
     * F = f(0, n) = 0 ;  m = 0 , n > 0
     * F = f(1, n) = MAX(f(0, n-1) - p(n) , f(1, n-1))
     * F = f(2, n) = MAX(f(1, n-1) + p(n) , f(2, n-1))
     * F = f(3, n) = MAX(f(2, n-1) - p(n) , f(3, n-1))
     * F = f(4, n) = MAX(f(3, n-1) + p(n) , f(4, n-1))
     *
     * 归纳上述表达式得到：
     *             = f(0, n) = 0 ;  m = 0 , n > 0
     * F = f(m, n) = MAX(f(m-1, n-1) - p(n) , f(m, n-1)) ; m 为奇数
     *             = MAX(f(m-1, n-1) + p(n) , f(m, n-1)) ; m 为偶数
     *
     * 以数组int[] arr = {9,2,7,4,3,1,8,4}为例, 则有p(n) = arr[n-1],
     * 得到如下关系矩阵：
     *     n\m     | 0:没有发生买卖 |   1:第一次买入   |   2:第一次卖出   |   3:第二次买入   |   4:第二次卖出
     *     1:9     |        0       |        -9        |         0        |        -9        |         0
     *     2:2     |        0       | MAX(-9, -2) = -2 | MAX(-7, -2) = -2 | MAX(-2, -9) = -2 | MAX(-7, 0) = 0
     *     3:7     |        0       | MAX(-7, -2) = -2 | MAX( 5, -2) =  5 | MAX(-9, -2) = -2 | MAX( 5, 0) = 5
     *     4:4     |        0       | MAX(-4, -2) = -2 | MAX( 2,  5) =  5 | MAX(-1, -2) = -1 | MAX( 2, 5) = 5
     *     5:3     |        0       | MAX(-3, -2) = -2 | MAX(-1,  5) =  5 | MAX( 2, -1) =  2 | MAX( 2, 5) = 5
     *     6:1     |        0       | MAX(-1, -2) = -1 | MAX(-1,  5) =  5 | MAX( 4,  2) =  4 | MAX( 3, 5) = 5
     *     7:8     |        0       | MAX(-8, -1) = -1 | MAX( 7,  5) =  7 | MAX(-3,  4) =  4 | MAX(12, 5) = 12
     *     8:4     |        0       | MAX(-4, -1) = -1 | MAX( 3,  7) =  7 | MAX(11,  4) = 11 | MAX( 8,12) = 12
     *
     * @param originalArray
     * @return
     */
    //最大买卖次数
    private static int MAX_DEAL_TIMES = 2;

    /**
     * 交易两次的最大收益
     * @param prices
     * @return
     */
    public static int[][] maxProfitFor2Time(int[] prices) {
        if(prices==null || prices.length==0) {
            return null;
        }
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = MAX_DEAL_TIMES*2+1;
        //使用二维数组记录数据
        int[][] resultTable = new int[n][m];
        //填充初始状态
        resultTable[0][1] = -prices[0];
        resultTable[0][3] = -prices[0];
        //自底向上，填充数据
        for(int i=1;i<n;++i) {
            for(int j=1;j<m;j++){
                //判断j的奇偶性
                if((j&1) == 1){
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-1]-prices[i]);
                }else {
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-1]+prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable;
    }

    /**
     * 优化后的代码
     * 优化思路：由递推表达式可知，后一行的数值只和上一行有关；而最大收益是最后一个值，所以只需用一维数组记录上一行的数值就行
     *
     * @param prices
     * @return
     */
    public static int maxProfitFor2TimeV2(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = MAX_DEAL_TIMES*2+1;
        //使用一维数组记录数据
        int[] resultTable = new int[m];
        //填充初始状态
        resultTable[1] = -prices[0];
        resultTable[3] = -prices[0];
        //自底向上，填充数据
        for(int i=1;i<n;++i) {
            for(int j=1;j<m;j++){
                if((j&1) == 1){
                    resultTable[j] = Math.max(resultTable[j], resultTable[j-1]-prices[i]);
                }else {
                    resultTable[j] = Math.max(resultTable[j], resultTable[j-1]+prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable[m-1];
    }

    /**
     * 允许k次交易，求最大收益
     *
     * @param prices
     * @return
     */
    public static int maxProfitFor2TimeV2(int[] prices, int k) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = k*2+1;
        //使用一维数组记录数据
        int[] resultTable = new int[m];
        //填充初始状态
        resultTable[1] = -prices[0];
        resultTable[3] = -prices[0];
        //自底向上，填充数据
        for(int i=1;i<n;++i) {
            for(int j=1;j<m;j++){
                if((j&1) == 1){
                    resultTable[j] = Math.max(resultTable[j], resultTable[j-1]-prices[i]);
                }else {
                    resultTable[j] = Math.max(resultTable[j], resultTable[j-1]+prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable[m-1];
    }

}

/**
 * 买入、卖出点信息
 */
@Data
class Target{
    //买入点下标
    private int minIndex;
    //买入点价格
    private int min;
    //卖出点下标
    private int saleIndex;
    //卖出点价格
    private int sale;
    //利润
    private int profit;
}
