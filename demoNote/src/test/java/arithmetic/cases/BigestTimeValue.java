package arithmetic.cases;

/**
 * 给定一个int数组，用这个数组中的4个元素组成一个24进制的时间值
 * 求这个最大的时间值，如果不能组成一个合法的时间值，就输出invalid
 *
 * @Author li zhiqang
 * @create 2021/11/2
 */
public class BigestTimeValue {

    public static void main(String[] args){
        int[] ints = {5,2,3,4};
        System.out.println(getBigestTimeValue1(ints));
    }

    /**
     * 暴力穷举法
     *
     * 根据提供的整型数组，取它能得到的最大24禁止时间值,如23:59
     * 不能则返回invalid
     * @param ints
     * @return
     */
    private static String getBigestTimeValue1(int[] ints){
        int time1;
        int time2;
        int time3;
        int time4;
        int max = 0;
        String result = "invalid";
        for (int i = 0; i < ints.length; i++) {
            time1 = ints[i];
            for (int j = 0; j < ints.length; j++) {
                if(time1 != ints[j]){
                    time2 = ints[j];
                    for (int k = 0; k < ints.length; k++) {
                        if(time1 != ints[k] && time2 != ints[k]){
                            time3 = ints[k];
                            for (int l = 0; l < ints.length; l++) {
                                if(time1 != ints[l] && time2 != ints[l] && time3 != ints[l]){
                                    time4 = ints[l];
                                    if(getTime(time1, time2, time3, time4) > max){
                                        max = getTime(time1, time2, time3, time4);
                                        result = getTimeString(time1, time2, time3, time4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * 判断这4个值组成的时间值是否合法
     * 不合法，返回0;
     * 合  法，计算由这4个组成的24进制时间的分钟数值
     *
     * @param time1
     * @param time2
     * @param time3
     * @param time4
     * @return
     */
    private static int getTime(int time1, int time2, int time3, int time4){
        int hours = time1 * 10 + time2;
        int minutes = time3 * 10 + time4;
        if (hours < 24 && minutes < 60){
            return hours * 60 + minutes;
        }
        return 0;
    }

    private static String getTimeString(int time1, int time2, int time3, int time4){
        return time1 + "" + time2 + ":" + time3 + "" + time4;
    }
}
