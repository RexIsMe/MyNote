package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Rex
 * @title: MybatisConfig
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/810:40
 */

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class MybatisConfig {

    /**
     * url
     */
    private String url;

    /**
     * 驱动名称
     */
    private String driverClassName;

    /**
     * 数据库名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;


    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    /*
     *使用JNDI方式连接数据库
    @Bean
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:/comp/env/jdbc/test");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }
    */


}
