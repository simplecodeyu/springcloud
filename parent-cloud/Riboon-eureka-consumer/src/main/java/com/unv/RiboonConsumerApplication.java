package com.unv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RiboonConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiboonConsumerApplication.class,args);
    }
}
