package com.ken;

import com.ken.config.UserRibbonConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;


/**
 * 开启断路器功能
 */
@EnableCircuitBreaker
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

    /*@Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/
}
