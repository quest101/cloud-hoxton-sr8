package com.ken.service;

import com.ken.utils.RestTemplateUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    RestTemplateUtils restTemplateUtils;

    private String userServiceUrl = "http://hello-service";

    @HystrixCommand(fallbackMethod ="helloFallBack")
    public Map<String, Object> helloConsumer() {
        long start = System.currentTimeMillis();

        //logger.info("------------/helloConsumer-----------")  ;
        Map<String, Object> restMap = restTemplateUtils.exchange(userServiceUrl
                        + "/api/ribbon/helloHystrix",
                HttpMethod.GET, null, null, null, Map.class);
        long end = System.currentTimeMillis();

        logger.info("Spend time："+(end-start));
        return restMap;
        //return restTemplate.getForEntity(userServiceUrl+"/index",String.class).getBody();
    }

    public Map<String, Object> helloFallBack(){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "500");
        resultMap.put("msg", "调用失败，服务被降级");
        resultMap.put("data", null);
        return resultMap;
        //return "error";
    }
}
