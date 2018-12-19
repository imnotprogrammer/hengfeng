package com.hengfeng.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hengfeng.web.service.UserService;
import com.hengfeng.web.table.User;

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
