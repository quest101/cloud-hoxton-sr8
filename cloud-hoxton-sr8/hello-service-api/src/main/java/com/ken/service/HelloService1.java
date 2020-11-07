package com.ken.service;

import com.ken.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/refactor")
public interface HelloService1 {

    @RequestMapping("/api/ribbon/index4")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/api/ribbon/index5")
    User hello(@RequestHeader("name") String name,
                 @RequestHeader("age") Integer age);

    @RequestMapping("/api/ribbon/index6")
    String hello(@RequestBody User user);
}
