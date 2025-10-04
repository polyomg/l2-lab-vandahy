package com.poly.lab8.springstarterproject;

import com.poly.lab8.interceptor.AuthInterceptor;
import com.poly.lab8.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Interceptor kiểm tra đăng nhập
        registry.addInterceptor(authInterceptor).addPathPatterns("/mail/**")
//                .addPathPatterns("/admin/**", "/account/change-password",
//                        "/account/edit-profile", "/order/**")
                .excludePathPatterns("/admin/home/index");

        // Interceptor ghi log (chỉ cho các URI bảo mật)
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/mail/**")
                .excludePathPatterns("/admin/home/index");
    }
}
