package com.yuxiu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"com.yuxiu.edu.controller","com.yuxiu.edu.service","com.yuxiu.edu.mapper"})
@MapperScan(basePackages = "com.yuxiu.edu.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
