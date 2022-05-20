package arithmetic.dp;

/**
 * 掷骰子问题
 * https://leetcode.cn/problems/dice-roll-simulation/
 *
 * 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
 * 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 * 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 * 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 *
 *
 * @Author li zhiqang
 * @create 2022/5/16
 */
public class RollTheDice {

    public static void main(String[] args){
        int[] rollMax = {8,5,10,8,7,2};
        int n = 20;
        System.out.println(dieSimulator(n, rollMax));
        System.out.println(myDiseSimulator(n, rollMax));
//        System.out.println(myDiseSimulator2(n, rollMax));
    }

    public static int dieSimulator(int n, int[] rollMax) {

        int dp[][] =new int[n+1][7];
        int reduce=0;
        int mod = 1000000007;
        dp[0][6]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j]=dp[i-1][6];
                if(i-rollMax[j]>0){
                    reduce = dp[i-rollMax[j]-1][6]-dp[i-rollMax[j]-1][j];
                    dp[i][j]= ((dp[i][j] - reduce) % mod + mod) % mod;
                    // 这里在执行是会被优化成dp[i][j]%mod - reduce%mod来计算，而如12%10-9%10 = -6 不等于 (12-9)%10 = 3
//                    dp[i][j]= (dp[i][j] - reduce) % mod;
                }
                dp[i][6]=(dp[i][6]+dp[i][j])%mod;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "=========================");
            for (int j = 0; j < 7; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        return dp[n][6];
    }

    public static int myDiseSimulator(int n, int[] rollMax) {
        // dp解法：
        // dp[i][j]表示:第i次掷骰子为j时在rollMax限制下可能的序列个数
        // 迭代关系：
        //     第i次掷骰子得到数字j的所有可能的序列个数 等于 第i-1次掷骰子得到数字为1~6的和 减去 第i次掷骰子为j时超过rollMax限定次数的可能的序列个数
        //     不满足的序列数 等于 第i-1-rollMax[j][!j]的和 (对应最后的rollMax[j]位都是j的可能序列个数)
        // 迭代公式：
        // dp[i][j] = sum(dp[i-1][j]) - sum(dp[i-1-rollMax[j-1]][!j])

        int mod = 1000000007;
        //这里index和次数、骰子数字保持一致方便理解，0下标不用
        int[][] dp = new int[n + 1][7];
        // 第一次掷骰子数字为1 ~ 6的序列个数都为1
        for(int j = 1; j <= 6; j++){
            dp[1][j] = 1;
        }
        //计算dp各个元素的值，直至i = n都填满
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= 6; j++){
                int sum1 = 0;
                int sum2 = 0;
                for(int sumJ = 1; sumJ <= 6; sumJ++){
                    sum1 = (sum1 + dp[i-1][sumJ]) % mod;
                    if(i-1-rollMax[j-1] > 0 && sumJ != j){
                        sum2 = (sum2 + dp[i-1-rollMax[j-1]][sumJ]) % mod;
                    }
                    //当掷第n次，且n-1=rollMax[j-1]时，这种临界情况上面的判断会漏，这里补全
                    if(i-1-rollMax[j-1] == 0 && sumJ == j){
                        sum1--;
                    }
                }
                dp[i][j] = ((sum1 - sum2) % mod + mod)%mod;
//                dp[i][j] = sum1 - sum2;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "=========================");
            for (int j = 1; j <= 6; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        int result = 0;
        for (int i = 1; i <= 6; i++) {
            result = (result + dp[n][i]) % mod;
        }
        return result;

    }

    public static long myDiseSimulator2(int n, int[] rollMax) {
        // dp解法：
        // dp[i][j]表示:第i次掷骰子为j时在rollMax限制下可能的序列个数
        // 迭代关系：
        //     第i次掷骰子得到数字j的所有可能的序列个数 等于 第i-1次掷骰子得到数字为1~6的和 减去 第i次掷骰子为j时超过rollMax限定次数的可能的序列个数
        //     不满足的序列数 等于 第i-1-rollMax[j][!j]的和 (对应最后的rollMax[j]位都是j的可能序列个数)
        // 迭代公式：
        // dp[i][j] = sum(dp[i-1][j]) - sum(dp[i-1-rollMax[j-1]][!j])

        int mod = 1000000007;
        //这里index和次数、骰子数字保持一致方便理解，0下标不用
        long[][] dp = new long[n + 1][7];
        // 第一次掷骰子数字为1 ~ 6的序列个数都为1
        for(int j = 1; j <= 6; j++){
            dp[1][j] = 1;
        }
        //计算dp各个元素的值，直至i = n都填满
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= 6; j++){
                long sum1 = 0;
                long sum2 = 0;
                for(int sumJ = 1; sumJ <= 6; sumJ++){
                    sum1 += dp[i-1][sumJ];
                    if(i-1-rollMax[j-1] > 0 && sumJ != j){
                        sum2 += dp[i-1-rollMax[j-1]][sumJ] ;
                    }
                    //当掷第n次，且n-1=rollMax[j-1]时，这种临界情况上面的判断会漏，这里补全
                    if(i-1-rollMax[j-1] == 0 && sumJ == j){
                        sum2++;
                    }
                }
                dp[i][j] = ((sum1 - sum2) % mod + mod)%mod;
//                dp[i][j] = sum1 - sum2;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "=========================");
            for (int j = 1; j <= 6; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        return (dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5] + dp[n][6]) % mod;

    }

}
