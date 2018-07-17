package com.yrd.demo.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/6
 * Time:17:04
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    @Autowired
    IpFilterService ipFilterService;

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
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String ip = getIpAddr(request);
        log.info("请求源IP：" + ip);

        if (ip.contains("0:0:0:0"))
            ip = "127.0.0.1";
        if (!ipFilterService.isValidIp(ip)) {
            log.warn("非白名单ip，无法访问：" + ip);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            try {
                ctx.getResponse().getWriter().write("ip is invalid");
            } catch (Exception e) {
            }

            return null;
        }

        log.info("ok");
        return null;
    }

    public String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
