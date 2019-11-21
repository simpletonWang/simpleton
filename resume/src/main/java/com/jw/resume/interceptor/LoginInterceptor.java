package com.jw.resume.interceptor;

import com.alibaba.fastjson.JSON;
import com.jw.resume.common.constants.Constants;
import com.jw.resume.common.service.RedisService;
import com.jw.resume.exception.CommonException;
import com.jw.resume.sys.pojo.User;
import com.jw.resume.thread.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisService redisService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 判断是否登录
        String token = request.getHeader(Constants.SUPERVISE_TOKEN);
        if (StringUtils.isBlank(token)) {
                throw new CommonException(Constants.UNAUTHORIZED, "请先登录！");
        }
        String userJson = redisService.get(Constants.USER + token);
        if (StringUtils.isBlank(userJson)) {
            log.warn("token失效：{}，用户请求uri：{}", token, request.getRequestURI());
                throw new CommonException(Constants.UNAUTHORIZED, "用户已失效！请重新登录！");
        } else {
            // 重新设置redis时间
            redisService.expire(token, 14400);
            User user = JSON.parseObject(userJson, User.class);
            // 用户信息放入本地线程
            UserThreadLocal.setUser(user);
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 当请求完成之后，消除用户信息
        UserThreadLocal.setUser(null);
//        FunctionaryThreadLocal.setFunctionary(null);
    }

}