package github_java.basis;

/**
 * @author Rex
 * @title: Demo_genericity
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1218:16
 */
public class Demo_genericity {

    public static void main(String[] args) {

        int minInteger = min(new Integer[]{1, 2, 3});//result:1
        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
//        String typeError = min(new String[]{"1","3"});//报错

        System.out.println(minInteger);
        System.out.println(minDouble);

    }


    //注意：Number并没有实现Comparable
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

}
