package arithmetic.enumeration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhiqiang
 * @title: Common
 * @projectName demoNote
 * @description: 枚举算法实践
 * @date 2020/7/2414:41
 */
public class Common {

    public static void main(String[] args) {



    }



    /**
     * 百钱买百鸡问题：
     * x + y + z = 100,5x + 3y + z/3 = 100;0 <= x,y,z <= 100
     * 假设
     * x = 100 - y - z => 5(100 - y - z) + 3y + z/3 = 100 => 3y + 7Z = 600
     */
    @Test
    public void test1(){
        int count = 1;
        List<Integer[]> resultList = new ArrayList<>();
        for (int x = 0; x <= 20 ; x++) {
            for (int y = 0; y <= 33; y++) {
                for (int z = 0; z <= 99; z += 3) {
//                    System.out.println("当前循环次数：" + count++);
//                    System.out.println("当前各变量值【" + "x:" + x + ",y:" + y +",z:" + z + "】");
                    if((x + y + z == 100) && (5* x + 3 * y + z/3 == 100)){
//                        System.err.println("x:" + x + ",y:" + y +",z:" + z);
                        resultList.add(new Integer[]{x,y,z});
                    }

                }
            }
        }


        resultList.forEach(e -> {
            for (int i = 0; i < e.length; i++) {
                System.out.println(e[i]);
            }
            System.out.println("====");
        });

    }


    /**
     * 无意中将+= 错写成了=+，改变程序逻辑
     * 验证得：=+ 等同于 =
     */
    public void testX(){
        int x = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println(x += 3);
            System.out.println(x =+ 3);
        }
    }

}
