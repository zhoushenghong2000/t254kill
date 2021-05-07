package com.zking.killprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zking.killprovider.mapper")
public class KillproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillproviderApplication.class, args);
    }

}
