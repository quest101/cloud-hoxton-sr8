package com.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}",request.getMethod(),
                request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(null == accessToken){
            logger.warn("access token is empty");
            //过滤该请求，不对其路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            //返回内容
            //ctx.setResponseBody("access token is empty");
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
