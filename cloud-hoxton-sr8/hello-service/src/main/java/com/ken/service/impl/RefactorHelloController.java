package com.ken.service.impl;

import com.ken.dto.User;
import com.ken.service.HelloService1;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService1 {
    @Override
    public String hello(String name) {
        return "Hello"+name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(User user) {
        return "Hello"+user.getName()+", "+user.getAge();
    }
}
