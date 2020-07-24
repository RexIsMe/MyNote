package arithmetic.recursion;

import java.util.Collections;
import java.util.List;
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


    public static void main(String[] args) {
        Stream.iterate(new long[]{0, 1}, a -> new long[]{a[1], a[0] + a[1]})
                .limit(100)
                .map(a -> a[1] + ",")
                .forEach(System.err::print);
    }
}
