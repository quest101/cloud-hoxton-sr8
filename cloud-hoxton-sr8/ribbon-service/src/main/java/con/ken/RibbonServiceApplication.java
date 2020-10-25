package con.ken;

import con.ken.config.UserRibbonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.core.env.Environment;

/**
 * 开启eureka客户端
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "user-service", configuration = UserRibbonConfig.class)
})
public class RibbonServiceApplication {

    private final static Logger logger =
            LoggerFactory.getLogger(RibbonServiceApplication.class);

    public static void main(String[] args) {

        Environment env =
                SpringApplication.run(RibbonServiceApplication.class,args).getEnvironment();
        logger.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://localhost:{}{}"
                        + "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path") != null ? env.getProperty("server.servlet.context-path") : "");
    }
}
