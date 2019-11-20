package com.jw.resume.config.mvc;

import com.jw.resume.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: simpleton
 * @Date: 2018/11/2 10:13
 * @Description: springMVC配置
 */
@SpringBootConfiguration
@Slf4j
public class MySpringMVCConfig implements WebMvcConfigurer {


    @Autowired
    private LoginInterceptor loginInterceptor;


    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/druid/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/upload/img")
                .excludePathPatterns("/upload/imgs")
                // swagger2页面
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/error/");
    }

}
