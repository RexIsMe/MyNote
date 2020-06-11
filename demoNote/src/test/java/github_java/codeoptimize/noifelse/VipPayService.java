package github_java.codeoptimize.noifelse;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author Rex
 * @title: VipPayService
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1416:50
 */
public class VipPayService implements UserPayService, InitializingBean {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
//        if(该用户超级会员刚过期并且尚未使用过临时折扣){
//            临时折扣使用次数更新();
//            returen 8折价格;
//        }
//        return 9折价格;


        return new BigDecimal(0.9);//使不报错
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("Vip",this);
    }
}
