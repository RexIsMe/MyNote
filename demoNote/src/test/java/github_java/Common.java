package github_java;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import github_java.utils.MyBloomFilter;

/**
 * @author Rex
 * @title: Common
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1218:10
 */
public class Common {

    public static void main(String[] args) {

//        BloomTest();

        GoogleBloomTest();
    }

    public static void GoogleBloomTest(){
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }

    public static void BloomTest(){

        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter1 = new MyBloomFilter();
        System.out.println(filter1.contains(value1));
        System.out.println(filter1.contains(value2));
        filter1.add(value1);
        filter1.add(value2);
        System.out.println(filter1.contains(value1));
        System.out.println(filter1.contains(value2));


        Integer value11 = 13423;
        Integer value22 = 22131;
        MyBloomFilter filter3 = new MyBloomFilter();
        System.out.println(filter3.contains(value11));
        System.out.println(filter3.contains(value22));
        filter3.add(value1);
        filter3.add(value2);
        System.out.println(filter3.contains(value11));
        System.out.println(filter3.contains(value22));

    }

}
