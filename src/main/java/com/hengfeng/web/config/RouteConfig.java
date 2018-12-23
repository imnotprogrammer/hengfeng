package com.hengfeng.web.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RouteConfig implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        /*String pathInfo = httpServletRequest.getServletPath();
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getQueryString());
        //System.out.println(httpServletRequest.get);
        Pattern pattern = Pattern.compile("^/([\\S]+).html");
        Matcher matcher = pattern.matcher(pathInfo);
        if (matcher.find()) { //如何
            System.out.println("Found value: " + matcher.group(0) );
            System.out.println("Found value: " + matcher.group(1) );
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index?resource=" + matcher.group(1));
            return false;
        }*/
        return true;
    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
