package newcoder._1_string;

import java.util.*;

/**
 * @author Rex
 * @title: _4
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/129:20
 */
public class _4 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String str = sc.nextLine();
                String[] result = test(str);
                printArr(result);
            }

        }

        public static String[] test(String str){
            if(str == null || str == " "){
                String[] strArr = new String[1];
                strArr[0] = "00000000";
                return strArr;
            }
            int len = str.length();
            if(len == 8){
                String[] strArr = new String[1];
                strArr[0] = str;
                return strArr;
            } else if(len < 8){
                String[] strArr = new String[1];
                int num = 8 - len;
                String zero = "";
                for(int i = 0; i < num; i++){
                    zero = zero + "0";
                }
                strArr[0] = str + zero;
                return strArr;
            } else {
                int length = len/8;
                int rest = len%8;
                if(rest == 0){
                    String[] strArr = new String[length];
                    for(int i = 0; i < length; i++){
                        strArr[i] = str.substring(i * 8, (i + 1) * 8);
                    }
                    return strArr;
                } else {
                    String[] strArr = new String[length + 1];
                    for(int i = 0; i < length; i++){
                        strArr[i] = str.substring(i * 8, (i + 1) * 8);
                    }
                    int num = 8 - rest;
                    String zero = "";
                    for(int i = 0; i < num; i++){
                        zero = zero + "0";
                    }
                    strArr[length] = str.substring(length * 8) + zero;

                    return strArr;
                }
            }
        }

        public static void printArr(String[] strArr){
            int len = strArr.length;
            for(int i = 0; i < len; i++){
                System.out.println(strArr[i]);
            }
        }

}
