package arithmetic.recursion;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Cytang
 * @title: FibonacciSequence
 * @projectName demoNote
 * @description: 递归实现斐波那契数列
 * @date 2020/7/1316:09
 */
public class FibonacciSequence {

    /** 获取n位斐波那契数列 */
    private List<Integer> getFibonacci(int n, List<Integer> result){
        int size = result.size();
        int num = n + size;

        if(n < 1){
            return result;
        } else if(n >= 1 && size <= 0){
            result.add(0);
            return result;
        } else if(n >= 1 && size == 1){
            result.add(1);
            return getFibonacci(n-1, result);
        } else {

//            if(size == 1){
//                result.add(1);
//                getFibonacci(n, result);
//            } else if(n == 0){
//                result.add(0);
//            } else {
//                result.re
//            }
        }




        Collections.reverse(result);
        return result;
    }


    /**
     * 得到第N位斐波那契数列的值（未优化）
     * @param N
     * @return
     */
    static int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    // -------------------------------------------带备忘录-----------------------------------------

    /**
     * 得到第N位斐波那契数列的值（带备忘录，优化后）
     * @param N
     * @return
     */
    static int fib2(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
//        vector<int> memo(N + 1, 0);
        Map<Integer, Integer> memo = new HashMap<>(N/2*2<<1);
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    static int helper(Map<Integer, Integer> memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        Integer nEle = memo.get(n);
        if (nEle != null && nEle != 0) {
            return nEle;
        }
        memo.put(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }

    // -------------------------------------------DP TABLE-----------------------------------------

    /**
     *
     * @param N
     * @return
     */
    static int fib3(int N) {
        Map<Integer, Integer> dp = new HashMap<>(N/2*2<<1);
        // base case
        dp.put(1, 1);
        dp.put(2, 1);
        for (int i = 3; i <= N; i++)
            dp.put(i, dp.get(i -1) + dp.get(i -2));
        return dp.get(N);
    }

    // ===========================================================================================

    /**
     * 求使用个数无限的指定币值的硬币集合凑出“目标总额”所需的最小硬币个数
     * 状态转移方程式见：D:\workspace\own\mygithub\MyNote\demoNote\src\test\java\arithmetic\recursion\凑硬币问题状态转移方程.png
     * 如 amount = 11 , coins = {1, 2, 5} 则返回值为3，对应的硬币为1，5，5
     * @param coins 多种币值的硬币集合
     * @param amount 目标总额
     * @return
     */
    static int coinChange(List<Integer> coins, Integer amount){
        return dp(coins, amount);
    }

    static int dp(List<Integer> coins, int amount){
        //base case
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }

        //求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.size(); i++) {
            int subProblem = dp(coins,amount - coins.get(i));
            if(subProblem == -1){
                continue;
            } else {
                res = Math.min(res, 1 + subProblem);
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }


    // -------------------------------------------带备忘录-----------------------------------------
    static int coinChange2(List<Integer> coins, Integer amount){
        Map<Integer, Integer> memo = new HashMap<>(amount/2*2<<1);
        int i = dp2(coins, amount, memo);
        return i;
    }

    static int dp2(List<Integer> coins, int amount, Map<Integer, Integer> memo){
        // 查备忘录，避免重复计算
        for (Map.Entry<Integer, Integer> integerIntegerEntry : memo.entrySet()) {
            if(integerIntegerEntry.getKey() == amount){
                return integerIntegerEntry.getValue();
            }
        }

        //base case
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }

        //求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.size(); i++) {
            int subProblem = dp2(coins,amount - coins.get(i), memo);
            if(subProblem == -1){
                continue;
            } else {
                res = Math.min(res, 1 + subProblem);
            }
        }

        //记入备忘录
        memo.put(amount, res != Integer.MAX_VALUE ? res : -1);
        return memo.get(amount);
    }


    // -------------------------------------------DP TABLE-----------------------------------------

    static int coinChange3(List<Integer> coins, Integer amount){
        Map<Integer, Integer> dp = new HashMap<>(amount/2*2<<1);
        for (int i = 0; i < amount/2*2<<1; i++) {
            dp.put(i, amount + 1);
        }
        // base case
        dp.put(0, 0);
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.size(); i++) {
            // 内层 for 循环在求所有选择的最小值
            for (Integer coin : coins) {
                // 子问题无解，跳过
                if(i - coin < 0){
                    continue;
                }
                dp.put(i, Math.min(dp.get(i), 1 + dp.get(i -coin)));
            }
        }
        if(dp.get(amount) == amount + 1){
            return -1;
        }
        return dp.get(amount);
    }


    public static void main(String[] args) {
//        Stream.iterate(new long[]{0, 1}, a -> new long[]{a[1], a[0] + a[1]})
//                .limit(20)
//                .map(a -> a[1] + ",")
//                .forEach(System.err::print);
        long begin = System.currentTimeMillis();
        System.out.println(begin);

        //获取菲波那切数列第N个元素
//        System.out.println(fib(40));
        //递归太深，内存方法栈超限溢出了
//        System.out.println(fib2(100000));
//        System.out.println(fib3(100000));

        //凑硬币问题
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        int amount = 16;
//        System.out.println(coinChange(coins, amount));
//        System.out.println(coinChange2(coins, amount));
        System.out.println(coinChange3(coins, amount));

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("耗时:【" + (end - begin) + "ms】");
    }
}
