package com.kang.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SSOClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSOClientApplication.class, args);
    }
}
