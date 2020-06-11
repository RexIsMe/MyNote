package newcoder.interview;

import java.util.Scanner;

/**
 * @author Rex
 * @title: Test
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1210:07
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(indexLen(str));
        }
    }

    /**
     * 获取该字符列表的指定索引最小长度
     * @param str
     * @return
     */
    public  static int indexLen(String str){
        if(str == null){
            return 0;
        }

        String[] strArr = str.split(",");
        int length = strArr.length;
        StringBuilder result = new StringBuilder(strArr[0] + "#");
        String tem = "";
        for (int i = 1; i < length; i++) {
            tem = strArr[i] + "#";
            if(result.indexOf(tem) == -1){
                result = result.append(tem);
            } else {
                continue;
            }
        }

        return result.length();
    }

}
