package org.sample.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardmain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardmain9001.class, args);
    }
}
