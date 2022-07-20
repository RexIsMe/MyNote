package com.example.demo.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author li zhiqang
 * @create 2022/6/20
 *
 * 体验一下springboot启动过程
 */
@Component
public class MyRunner implements ApplicationRunner, CommandLineRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(" 我是自定义的run方法1，实现 ApplicationRunner 接口既可运行"        );
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" 我是自定义的run方法2，实现 CommandLineRunner 接口既可运行"        );
    }
}
