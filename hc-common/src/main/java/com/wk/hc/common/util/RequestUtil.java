package com.wk.hc.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestUtil {
    private static final String CURRENT = "currentUser";

    //获取当前请求
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static void setCurrent(Object u) {
        getSession().setAttribute(CURRENT, u);
    }

    public static Object getCurrent() {
        return getSession().getAttribute(CURRENT);
    }
}
