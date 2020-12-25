package com.kang.sso.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
