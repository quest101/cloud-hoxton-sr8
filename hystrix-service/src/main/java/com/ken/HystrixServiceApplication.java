package com.ken;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * 开启断路器功能
 */
@EnableCircuitBreaker
/**
 * 开启服务发现客户端
 * @EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixServiceApplication {

    private final static Logger logger = LoggerFactory.getLogger(HystrixServiceApplication.class);

    public static void main(String[] args) {
        Environment env = SpringApplication.run(HystrixServiceApplication.class, args).getEnvironment();
        logger.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://localhost:{}{}"
                        + "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path") != null ? env.getProperty("server.servlet.context-path") : "");
    }

    /**
     * 解决问题：Dashboard显示Unable to connect to Command Metric Stream。
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
