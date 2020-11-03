package com.ken.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class RestTemplateUtils {
    private final static Logger logger = LoggerFactory.getLogger(RestTemplateUtils.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param url           请求路径
     * @param method        请求方式？ HttpMethod.POST/HttpMethod.GET
     * @param uriVariables  表单传参的参数
     * @param jsonObject    JSON格式传参的参数
     * @param requestHeader 请求头
     * @param responseType  返回结果Class
     * @return
     * @Description: JSON格式参数和表单参数一起传
     */
    public <T> T exchange(String url, HttpMethod method, Map<String, Object> uriVariables, Object jsonObject, HttpHeaders requestHeader, Class<T> responseType) {
//		一般的表单传参
        String uriVariablesParam = "";
        if (null != uriVariables && 0 != uriVariables.size()) {
            StringBuffer uriSb = new StringBuffer("?");
            uriVariables.forEach((k, v) -> {
                uriSb.append(k).append("=").append("{").append(k).append("}").append("&");
            });
            uriVariablesParam = uriSb.substring(0, uriSb.length() - 1).toString();
        }
        HttpHeaders requestHeaders = requestHeader;
        if (null == requestHeaders) {
            requestHeaders = new HttpHeaders();
        }

        HttpEntity<Object> requestEntity = new HttpEntity<>(null, requestHeaders);
        if (null != jsonObject) {
            requestEntity = new HttpEntity<>(jsonObject, requestHeaders);
        }
        url += uriVariablesParam;
        long startTime = System.currentTimeMillis();
        if (null == uriVariables || 0 == uriVariables.size()) {
            T body = restTemplate.exchange(url, method, requestEntity, responseType).getBody();
            logger.info("【接口请求】【{}】【处理时间：{}】【普通参数：{}】【JSON参数：{}】【返回结果：{}】",
                    url, System.currentTimeMillis() - startTime, uriVariables, jsonObject, body);
            return body;
        }
        T body = restTemplate.exchange(url, method, requestEntity, responseType, uriVariables).getBody();
        logger.info("【接口请求】【{}】【处理时间：{}】【普通参数：{}】【JSON参数：{}】【返回结果：{}】",
                url, System.currentTimeMillis() - startTime, uriVariables, jsonObject, body);
        return body;
    }
}
