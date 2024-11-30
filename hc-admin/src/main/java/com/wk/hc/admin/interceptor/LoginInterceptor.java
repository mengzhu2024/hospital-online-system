package com.wk.hc.admin.interceptor;

import com.wk.hc.common.exception.NoLoginException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object o = request.getSession().getAttribute("currentUser");

        if (o == null) {
            //不是ajax请求的话就重定向,是ajax换一种处理方式
            if (isAjax(request)) {
                throw new NoLoginException();
            } else {
                response.sendRedirect("/login");
            }
        }
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
        return o != null;

    }

    private boolean isAjax(HttpServletRequest request) {
        String s = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(s);
    }
}
