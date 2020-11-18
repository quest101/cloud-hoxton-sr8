package com.ken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 开启服务发现客户端
 */
@EnableDiscoveryClient
/**
 * 开启监控
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
