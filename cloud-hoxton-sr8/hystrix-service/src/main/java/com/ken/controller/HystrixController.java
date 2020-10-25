package com.ken.controller;

import com.ken.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/hystrix")
public class HystrixController {

    @Autowired
    private IUserService userService;

    /**
     * 正常测试
     *
     * @return
     */
    @GetMapping("/getUserList")
    public Map<String, Object> getUserList() {
        return userService.getUserList();
    }

    /**
     * 缓存测试
     *
     * @return
     */
    @GetMapping("/getCacheUserList")
    public Map<String, Object> getCacheUserList() {
        userService.getCacheUserList();
        userService.getCacheUserList();
        userService.getCacheUserList();
        userService.getCacheUserList();
        return userService.getCacheUserList();
    }

    /**
     * 缓存删除测试
     *
     * @return
     */
    @GetMapping("/getRemoveCacheUserList")
    public Map<String, Object> getRemoveCacheUserList() {
        userService.getCacheUserList();
        userService.removeCache();
        return userService.getCacheUserList();
    }
}
