package com.ken.controller;

import com.ken.entity.User;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/hello")
@RequestMapping("/api/ribbon")
public class HelloController {

    private final Logger logger =
            Logger.getLogger(String.valueOf(getClass()));

    //@Autowired
    //private DiscoveryClient client;

    @GetMapping("/index")
    public Map<String, Object> index(HttpServletRequest requst){
        logger.info("============<hello>,TraceId=,SpanId============");
        logger.info(requst.getHeader("X-B3-TraceId"));
        logger.info(requst.getHeader("X-B3-SpanId"));
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        resultMap.put("data", "Hello World");
        return resultMap;
        //return "Hello World";
    }

    @GetMapping("/index1")
    public Map<String, Object> index(@RequestParam String name ){
        logger.info("=========hello============");
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        resultMap.put("data", name);
        return resultMap;
    }

    @GetMapping("/index2")
    public Map<String, Object> index(@RequestHeader String name,
                                      @RequestHeader Integer age){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        User user = new User();
        user.setName(name);
        user.setAge(age);
        resultMap.put("data", user);
        return resultMap;
    }

    //@GetMapping("/index3")
    @PostMapping("/index3")
    public Map<String, Object> index(@RequestBody User user){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        User user1 = new User();
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        resultMap.put("data", user1);
        return resultMap;
    }

    @GetMapping("/helloHystrix")
    public Map<String, Object> helloHystrix() throws Exception{

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);

        logger.info("/helloHystrix, host:");
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        resultMap.put("data", "Hello World");
        return resultMap;
        //return "Hello World";
    }
}
