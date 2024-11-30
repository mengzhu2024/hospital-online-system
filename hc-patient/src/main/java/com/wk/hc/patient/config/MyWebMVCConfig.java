package com.wk.hc.patient.config;

import com.wk.hc.patient.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类
//介入springmvc的配置
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {


    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/cart/*","/uc/**")
                .excludePathPatterns("/cart/save");
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/cart/*")
                .excludePathPatterns("/cart/save");
    }*/


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //发的是/u/**请求,就去下面地址去找
        registry.addResourceHandler("/u/**")//请求地址
                .addResourceLocations("file:" + System.getProperty("user.dir") + "\\images\\")
        ;
    }
}
