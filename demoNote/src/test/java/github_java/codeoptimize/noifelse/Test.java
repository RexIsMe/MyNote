package github_java.codeoptimize.noifelse;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author Rex
 * @title: Test
 * @projectName demoNote
 * @description: 使用策略模式替代ifelse代码，提高代码的扩展性和可读性
 * @date 2020/2/1416:51
 */
public class Test {

//    @Autowired
//    ParticularlyVipPayService particularlyVipPayService;
//    @Autowired
//    SuperVipPayService superVipPayService;
//    @Autowired
//    VipPayService vipPayService;

    public static void main(String[] args) {

        ParticularlyVipPayService particularlyVipPayService = new ParticularlyVipPayService();
        SuperVipPayService superVipPayServic = new SuperVipPayService();
        VipPayService vipPayService = new VipPayService();

        //ParticularlyVip  SuperVip  Vip
//        User user1 = new User("ParticularlyVip");
//        User user2 = new User("SuperVip");
//        User user3 = new User("Vip");
//        BigDecimal bigDecimal = calPrice3(new BigDecimal(100), user1);
//        BigDecimal bigDecima2 = calPrice3(new BigDecimal(100), user2);
//        BigDecimal bigDecima3 = calPrice3(new BigDecimal(100), user3);
//
//        System.out.println(bigDecimal);
//        System.out.println(bigDecima2);
//        System.out.println(bigDecima3);

        test2();

    }

    /**
     * 使用if else
     * @param orderPrice
     * @param buyerType
     * @return
     */
    public BigDecimal calPrice(BigDecimal orderPrice, String buyerType) {

//        if (用户是专属会员) {
//            if (订单金额大于30元) {
//                returen 7折价格;
//            }
//        }
//
//        if (用户是超级会员) {
//            return 8折价格;
//        }
//
//        if (用户是普通会员) {
//            if(该用户超级会员刚过期并且尚未使用过临时折扣){
//                临时折扣使用次数更新();
//                returen 8折价格;
//            }
//            return 9折价格;
//        }
//        return 原价;


        return new BigDecimal(1); //使不报错，无意义
    }


    /**
     * @author mhcoding
     *
     * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。
     */
    public BigDecimal calPrice2(BigDecimal orderPrice,User user) {

//        String vipType = user.getVipType();
//
//        if (vipType == 专属会员) {
//            //伪代码：从Spring中获取超级会员的策略对象
//            UserPayService strategy = Spring.getBean(ParticularlyVipPayService.class);
//            return strategy.quote(orderPrice);
//        }
//
//        if (vipType == 超级会员) {
//            UserPayService strategy = Spring.getBean(SuperVipPayService.class);
//            return strategy.quote(orderPrice);
//        }
//
//        if (vipType == 普通会员) {
//            UserPayService strategy = Spring.getBean(VipPayService.class);
//            return strategy.quote(orderPrice);
//        }
//        return 原价;



        return new BigDecimal(1); //使不报错，无意义
    }

    /**
     * 使用策略模式后
     */
    public static void test2() {
        UserPayService strategy = new VipPayService();
        BigDecimal quote = strategy.quote(new BigDecimal(300));
        System.out.println("普通会员商品的最终价格为：" + quote.doubleValue());

        strategy = new SuperVipPayService();
        quote = strategy.quote(new BigDecimal(300));
        System.out.println("超级会员商品的最终价格为：" + quote.doubleValue());
    }


    /**
     * @author mhcoding
     *
     * 通过策略+工厂，我们的代码很大程度的优化了，大大提升了可读性和可维护性。
     * 但是，上面还遗留了一个问题，那就是UserPayServiceStrategyFactory中用来保存所有的策略类的实例的Map是如何被初始化的？各个策略的实例对象如何塞进去的呢？
     */
    public static BigDecimal calPrice3(BigDecimal orderPrice, User user) {

        String vipType = user.getVipType();
        UserPayService strategy = UserPayServiceStrategyFactory.getByUserType(vipType);
        return strategy.quote(orderPrice);
    }



}
