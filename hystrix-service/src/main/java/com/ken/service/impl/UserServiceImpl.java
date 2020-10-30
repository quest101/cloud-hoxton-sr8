package com.ken.service.impl;

import com.ken.service.IUserService;
import com.ken.utils.RestTemplateUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private String userServiceUrl = "http://user-service";
    //    private String userServiceUrl = "http://localhost:8084";

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    /**
     * 注解@HystrixCommand中的常用参数
     * fallbackMethod：指定服务降级处理方法，此方法必须和hystrix的执行方法在相同类中；
     * ignoreExceptions：忽略某些异常，不发生服务降级；
     * commandKey：命令名称，用于区分不同的命令，默认值为注解方法的名称；
     * groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息，默认注解方法类的名称；
     * threadPoolKey：线程池名称，用于划分线程池，默认定义为groupKey。
     */
    @HystrixCommand(fallbackMethod = "getUserListFallbackMethod1", ignoreExceptions = {NullPointerException.class})
    public Map<String, Object> getUserList() {
        return restTemplateUtils.exchange(userServiceUrl + "/api/user/getUserList", HttpMethod.GET, null, null, null, Map.class);
    }

    /**
     * 缓存测试
     *
     * @return
     */
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getUserListFallbackMethod1", ignoreExceptions = {NullPointerException.class})
    public Map<String, Object> getCacheUserList() {
        return restTemplateUtils.exchange(userServiceUrl + "/api/user/getUserList", HttpMethod.GET, null, null, null, Map.class);
    }

    /**
     * commandKey 用的是 HystrixCommand的commandKey：默认值为注解方法的名称；
     *
     * @HystrixCommand 需要带上
     */
    @HystrixCommand
    @CacheRemove(commandKey = "getCacheUserList", cacheKeyMethod = "getCacheKey")
    public void removeCache() {
    }

    /**
     * 为缓存生成key的方法
     * 如果方法是由传参的话，getCacheKey这个方法也要带参数，主要用来处理是否是唯一的标识，如果你这里直接使用UUID，缓存就会失效，因为每次cacheKey都是不一样的
     * 如果是没有参数的话，返回一个常量就好了
     *
     * @return
     */
    public String getCacheKey() {
        return "1";
//        return UUID.randomUUID().toString();
    }

    /**
     * 降级处理方法
     *
     * @return
     */
    public Map<String, Object> getUserListFallbackMethod1() {
        logger.info("========调用失败，服务被降级========");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "500");
        resultMap.put("msg", "调用失败，服务被降级");
        resultMap.put("data", null);
        return resultMap;
    }
}
