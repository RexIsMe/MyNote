package newcoder.interview;

import java.util.Scanner;

/**
 * @author Rex
 * @title: _test2
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1210:04
 */
public class _test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

}
