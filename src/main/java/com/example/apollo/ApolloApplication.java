package com.example.apollo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DongChengLong
 * @desc SpringBoot启动类
 * @date 2021/01/13 20:47
 */
@MapperScan("com.example.apollo.dao")
@SpringBootApplication
public class ApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class, args);
    }

}
