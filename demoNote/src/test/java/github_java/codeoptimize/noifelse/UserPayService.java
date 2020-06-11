package github_java.codeoptimize.noifelse;

import java.math.BigDecimal;

/**
 * @author Rex
 * @title: UserPayService
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1416:45
 */

public interface UserPayService {

    /**
     * 计算应付价格
     */
    public BigDecimal quote(BigDecimal orderPrice);
}

