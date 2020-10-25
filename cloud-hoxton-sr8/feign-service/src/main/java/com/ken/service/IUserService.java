package com.ken.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "user-service",
        fallback = IUserService.UserFallbackService. class)
public interface IUserService {

    @GetMapping("/api/user/getUserList")
    Map<String, Object> getUserList();

    /**
     * 容错处理类，当调用失败时，简单返回空字符串
     */
    @Component
    class UserFallbackService implements IUserService {

        public Map<String, Object> getUserList() {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code", "500");
            resultMap.put("msg", "调用失败，服务被降级");
            resultMap.put("data", null);
            return resultMap;
        }
    }

//    不同传参方式样例
//    JSON格式传参
//    @PostMapping("/user/save")
//    Map<String, Object> save(@RequestBody User user);

//    路径传参
//    @GetMapping("/user/{id}")
//    Map<String, Object> getUser(@PathVariable Long id);

//    表单传参
//    @GetMapping("/user/listUsersByIds")
//    Map<String, Object> listUsersByIds(@RequestParam List<Long> ids);

//    表单传参
//    @GetMapping("/user/getUserByUsername")
//    Result<User> getUserByUsername(@RequestParam String username);
}
