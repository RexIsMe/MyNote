package newcoder._1_string;

import java.util.Scanner;

/**
 * @author Rex
 * @title: _1
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1115:25
 */
public class _1_1 {

        public static void  main(String[] args){
//            String str = "ABSIB T";
            String str = "XSUWHQ";
            System.out.println(lastWordLen(str));
        }

    public static int lastWordLen(String str){
        int c = str.lastIndexOf(str);
        if(c == -1){
            c = 0;
        } else {
            c = c + 1 ;
        }
        return str.length() - c;
    }

}
