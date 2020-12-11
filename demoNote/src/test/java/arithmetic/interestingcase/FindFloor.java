package arithmetic.interestingcase;

import java.util.Map;

/**
 * 动态规划练习
 * 鸡蛋找楼层问题
 * 描述：现拥有n个鸡蛋，和h层楼，鸡蛋在m层及以上落下时会碎，求最少需要几次找到m层
 *
 * @Author li zhiqang
 * @create 2020/12/11
 */
public class FindFloor {

    public static void main(String[] args){

    }

    /**
     * 1、先固定变量n为2，h为100，求找到m最少需要几次
     * 分析：
     * 问题转化：有2个鸡蛋，用x次测试，最多可以测试多少层
     * 假设：第一个鸡蛋在y层丢下，此时会有两种情况：①鸡蛋碎了，还剩一个鸡蛋，只能从第一层一层一层丢下，最坏的情况是到y-1层才能得到结果，此时 x = 1 + (y-1)
     * ②鸡蛋没碎，下一层丢哪？基于①的分析，我们知道如果这个鸡蛋第二次碎了，因为尝试次数总共就是想，那么，剩下的鸡蛋可以丢x-2次，可以测x-2 + 1 = (x-1)层；
     * 以此类推到极限情况，第一个鸡蛋丢h-1层没碎，下一次丢h层碎了，所以是一直加到1
     * f(x) = x + (x-1) + (x-2) + ...+ 2 + 1= 1 + 2 + ...+ (x-2) + (x-1) + x
     * => 2 * f(x) = x*(x+1) => f(x) = x*(x+1)/2
     * 测100层最少需要几次？即：f(x) = x*(x+1)/2 >= 100，取x的最小值 得到x=14
     *
     * 扩展：2个鸡蛋h层最少需要几次
     * 有上面得到
     * f(x) = x*(x+1)/2 >= h
     * x = 进一取整( 1/2 * (开平方(8h + 1) - 1) )
     *
     * 扩展：3个鸡蛋h层最少需要几次 => 3个鸡蛋x次可以测试多少层楼
     * 假设第一次从z层丢下，碎了，则剩下的两个鸡蛋根据前面推断可以测试 (x-1)*x/2 层，则有z = (x-1)*x/2 + 1
     *
     *
     * @param h
     * @return
     */
    public static Try findWith1Egg(int h){



        return null;
    }

}

/**
 * 需要几次、以及分别从哪些位置尝试
 */
class Try{
    private Map<String, Integer[]> eggWithTryWay;
}
