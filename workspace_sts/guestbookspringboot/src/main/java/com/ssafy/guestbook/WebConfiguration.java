package com.ssafy.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.guestbook.interceptor.ConfirmInterceptor;

public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    ConfirmInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/article/write", "/article/modify", "/article/delete");
    }

}
