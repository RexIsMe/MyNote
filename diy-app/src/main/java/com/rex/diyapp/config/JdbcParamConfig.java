package com.rex.diyapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author li zhiqang
 * @create 2021/2/19
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.datasource.click")
@Data
public class JdbcParamConfig {
    private String driverClassName ;
    private String url ;
    private Integer initialSize ;
    private Integer maxActive ;
    private Integer minIdle ;
    private Integer maxWait ;
}
