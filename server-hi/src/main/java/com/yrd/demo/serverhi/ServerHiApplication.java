package com.yrd.demo.serverhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHiApplication.class, args);
    }

}
