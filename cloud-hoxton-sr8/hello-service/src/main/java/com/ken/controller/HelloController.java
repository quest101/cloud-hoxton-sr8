package com.ken.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/hello")
@RequestMapping("/api/ribbon")
public class HelloController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    //@Autowired
    //private DiscoveryClient client;

    @GetMapping("/index")
    public Map<String, Object> index(){
        logger.info("/hello, host:");
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        resultMap.put("data", "Hello World");
        return resultMap;
        //return "Hello World";
    }
}
