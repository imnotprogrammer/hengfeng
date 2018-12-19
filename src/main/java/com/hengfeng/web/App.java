package com.hengfeng.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *web 应用程序入口
 *
 */
@SpringBootApplication
@MapperScan(basePackages="com.hengfeng.web.dao")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
