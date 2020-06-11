package newcoder._1_string;

import java.util.Scanner;

/**
 * @author Rex
 * @title: _2
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1115:54
 */
public class _2 {

    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String str2 = scanner.nextLine();
        if(str2 != null && str2.length() != 0){
            System.out.println(charNum(str, str2.toCharArray()[0]));
        } else {
            System.out.println(0);
        }

    }

    public static int charNum(String str, char c){
        char[] ca = str.toCharArray();
        int len = ca.length;
        int count = 0;
        for(int i = 0; i<len; i++){
            if(ca[i] == c){
                count++;
            }
        }
        return count;
    }

}
