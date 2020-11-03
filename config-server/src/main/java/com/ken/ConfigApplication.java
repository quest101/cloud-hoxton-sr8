package com.ken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

    private final static Logger logger =
            LoggerFactory.getLogger(ConfigApplication.class);

    public static void main(String[] args) {

        Environment env =
                SpringApplication.run(ConfigApplication.class,args).getEnvironment();
        logger.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "/getUserListocal: \t\thttp://localhost:{}{}"
                        + "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path") != null ? env.getProperty("server.servlet.context-path") : "");
    }
}
