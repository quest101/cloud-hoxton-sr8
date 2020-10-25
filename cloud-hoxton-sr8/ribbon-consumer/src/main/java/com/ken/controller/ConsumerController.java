package com.ken.controller;

import com.ken.utils.RestTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
//@RequestMapping("/api/ribbon")
public class ConsumerController {

    private final static Logger logger =
            LoggerFactory.getLogger(ConsumerController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    private String userServiceUrl = "http://hello-service";

    @GetMapping("/hello")
    public Map<String, Object> helloConsumer() {
        logger.info("------------/helloConsumer-----------");
        return restTemplateUtils.exchange(userServiceUrl
                        + "/api/ribbon/index",
                HttpMethod.GET, null, null, null, Map.class);
        //return restTemplate.getForEntity(userServiceUrl+"/index",String.class).getBody();

    }
}
