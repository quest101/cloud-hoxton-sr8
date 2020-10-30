package com.ken.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务类
 */
@RestController
@RequestMapping("/api/user")
public class UserApiController   {

    @Value("${server.port}")
    private int port;

    @GetMapping("/getUserList")
    public Map<String, Object> getUserList() {
        System.out.println("我是：" + port + "有人调用我啦");
        ArrayList<User> dataList = new ArrayList<>();
        User user = new User();
        user.setUserId(1);
        user.setUserName("我是测试1");
        dataList.add(user);
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("我是测试2");
        dataList.add(user2);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("msg", "获取成功");
        resultMap.put("data", dataList);
        return resultMap;
    }

    // 为了方便演示，所以我就直接在这里创建了一个类，大家不要照搬哦
    class User {
        private Integer userId;
        private String userName;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
