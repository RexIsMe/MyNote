package newcoder._1_string;

import java.util.*;

/**
 * @author Rex
 * @title: _33
 * @projectName demoNote
 * @description: TODO
 * @date 2020/3/1116:21
 */
public class _3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String numStr = sc.nextLine();
            Integer num = new Integer(numStr);

            Integer[] intArr = new Integer[num];
            for(int i = 0; i < num; i++){
                intArr[i] = new Integer(sc.nextLine());
            }

            Integer[] test = test(intArr);
            int length = test.length;
            for (int i = 0; i < length; i++) {
                System.out.println(test[i]);
            }
        }


//        Integer[] intArr = new Integer[]{23,29,40,111,41,104,21,94,108,118,21,110,34,24,24,40,66,19,25,40,30,5,59,116,98,110,118,77,87,49,95,53,44,94,52,104,7,118,20,5,57,81,73,39,106,6,26,2,69,44,19,50,78,61,55,27,97,103,109,66,101,15,86,17,70,96,50,1,118,81,107,102,22,84,112,64,106,14,15,14,93,54,38,66,78,5,118,60,107,84,34,47,57,8,5,67,111,42,35,64,10,109,90,57,72,73,91,54,5,10,31,64,113,39,120,6,45,15,46,112,40,105,115,106,88,64,20,113,52,1,40,90,103,63,28,11,34,33,11,78,42,30,119,34,94,78,73,104,36,44,65,41,81,69,74,75,49,66,30,74,75,111,44,97,102,65,99,63,77,78,102,84,10,6,12,27,99,120,84,37,10,74,2,83,53,18,106,48,17,26,94,50,11,120,17,21,79,42,48,48,75,91,56,69,21,44,16,14,34,110,43,27,102,63,81,92,109,97,100,70,23,44,17,32,60,40,40,36,3,92,48,34,88,58,30,106,63,31,8,116,90,100,83,111,42,112,6,8,115,109,83,7,26,88,68,86,116,39,55,76,109,45,1,39,4,52,78,26,33,96,14,38,105,65,116,4,48,83,24,113,111,70,37,34,51,46,18,104};


    }


    public static Integer[] test(Integer[] input){
        Set<Integer> hashSet = new HashSet<Integer>();
        Collections.addAll(hashSet, input);
        int size = hashSet.size();
        Integer[] integers = hashSet.toArray(new Integer[size]);
        List<Integer> integers1 = Arrays.asList(integers);
        Collections.sort(integers1);
        return integers1.toArray(new Integer[size]);
    }

}
