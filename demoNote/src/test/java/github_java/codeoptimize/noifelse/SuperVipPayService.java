package github_java.codeoptimize.noifelse;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author Rex
 * @title: SuperVipPayService
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1416:49
 */
public class SuperVipPayService implements UserPayService, InitializingBean {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
//        return 8折价格;
        return new BigDecimal(0.8);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("SuperVip",this);
    }
}
