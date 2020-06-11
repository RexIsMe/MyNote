package github_java.codeoptimize.noifelse;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rex
 * @title: UserPayServiceStrategyFactory
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1417:02
 */
public class UserPayServiceStrategyFactory {

    private static Map<String,UserPayService> services = new ConcurrentHashMap<String,UserPayService>();

    public  static UserPayService getByUserType(String type){
        return services.get(type);
    }

    public static void register(String userType,UserPayService userPayService){
        Assert.notNull(userType,"userType can't be null");
        services.put(userType,userPayService);
    }
}

