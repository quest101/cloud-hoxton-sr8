package com.ken;

import com.ken.config.UserRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
//@RibbonClients({
//        @RibbonClient(name = "hello-service")
//})
@RibbonClients({
        @RibbonClient(name = "hello-service", configuration = UserRibbonConfig.class)
})
public class RibbonConsumerApplication {

    //@Bean
    //@LoadBalanced
    //RestTemplate restTemplate(){
    //    return new RestTemplate();
    //}

    public static void main(String[] args) {

        SpringApplication.run(RibbonConsumerApplication.class,args);
    }
}
