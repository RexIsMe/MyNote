package github_java.codeoptimize.noifelse;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author Rex
 * @title: ParticularlyVipPayService
 * @projectName demoNote
 * @description:
 *
 * 接下来，我们就想办法调用register方法，把Spring通过IOC创建出来的Bean注册进去就行了。这种需求，可以借用Spring种提供的InitializingBean接口，
 * 这个接口为Bean提供了属性初始化后的处理方法，它只包括afterPropertiesSet方法，凡是继承该接口的类，在bean的属性初始化后都会执行该方法。

 * @date 2020/2/1416:46
 */
public class ParticularlyVipPayService implements UserPayService , InitializingBean {

    static{
        System.out.println("ParticularlyVipPayService init");
    }

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
//        if (消费金额大于30元) {
//            return 7折价格;
//        }
        if (orderPrice.compareTo(new BigDecimal(30)) > 0) {
            return new BigDecimal(0.7);//使不报错
        }
        return new BigDecimal(1.0);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ParticularlyVipPayService afterPropertiesSet");
        UserPayServiceStrategyFactory.register("ParticularlyVip",this);
    }


}
