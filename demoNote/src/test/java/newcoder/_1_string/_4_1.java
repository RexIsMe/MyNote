package newcoder._1_string;

import java.util.Scanner;

/**
 * @author Rex
 * @title: _4
 * @projectName demoNote
 * @description: 使用递归
 * @date 2020/3/129:20
 */
public class _4_1 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String str = sc.nextLine();
                String[] result = test(str, getStringArr(str), 0);
                printArr(result);
            }

        }

        public static String[] getStringArr(String str){
            int length = str.length();
            int i = length % 8;
            int len = length/8;
            if(i != 0){
                len = len + 1;
            }
            return new String[len];
        }

        public static String[] test(String str, String[] strArr, int index){
            if(strArr == null){
                strArr = new String[1];
                index = 0;
            }

            if(str == null || str == " "){
                strArr[index] = "00000000";
                return strArr;
            }
            int len = str.length();
            if(len == 8){
                strArr[index] = str;
                return strArr;
            } else if(len < 8){
                int num = 8 - len;
                String zero = "";
                for(int i = 0; i < num; i++){
                    zero = zero + "0";
                }
                strArr[index] = str + zero;
                return strArr;
            } else {
                strArr[index] = str.substring(0, 8);
                strArr = test(str.substring(8), strArr, index + 1);
                return strArr;
            }
        }

        public static void printArr(String[] strArr){
            int len = strArr.length;
            for(int i = 0; i < len; i++){
                System.out.println(strArr[i]);
            }
        }

}
