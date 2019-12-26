package com.sly.baseplatform.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SLY
 * @time 2019/12/23
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sly.baseplatform.system.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
