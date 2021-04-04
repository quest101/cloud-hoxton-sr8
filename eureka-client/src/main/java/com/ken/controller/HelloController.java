package com.ken.controller;

import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    //private final Logger logger = Logger.getLogger(getClass());

    //@Autowired
    //private DiscoveryClient client;

    @RequestMapping(value="hello",method= RequestMethod.GET)
    public String index(){
        return "Hello World";
    }

}
