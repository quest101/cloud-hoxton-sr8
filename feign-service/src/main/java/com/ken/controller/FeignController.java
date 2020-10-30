package com.ken.controller;

import com.ken.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/feign")
public class FeignController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUserList")
    public Map<String, Object> getUserList() {
        return userService.getUserList();
    }
}
