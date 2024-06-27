package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 囍崽
 * version 1.0
 */
@SpringBootApplication
@EnableAsync
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }
}
