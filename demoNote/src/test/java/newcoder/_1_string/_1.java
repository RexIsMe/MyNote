package newcoder._1_string;

import java.util.Scanner;

/**
 * @author Rex
 * @title: _1
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1115:25
 */
public class _1 {

        public static void  main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.out.println(lastWordLen(str));
        }

        public static int lastWordLen(String str){
            int i = str.lastIndexOf(str);
            return str.length() - i - 1;
        }

}
