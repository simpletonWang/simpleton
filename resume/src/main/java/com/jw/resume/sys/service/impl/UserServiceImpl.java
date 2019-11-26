package com.jw.resume.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.jw.resume.common.constants.Constants;
import com.jw.resume.common.pojo.Result;
import com.jw.resume.common.service.RedisService;
import com.jw.resume.common.util.UUIDGenerator;
import com.jw.resume.sys.dao.UserDao;
import com.jw.resume.sys.pojo.User;
import com.jw.resume.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;
    /**
     * 查询用户
     * @return
     */
    @Override
    public Result selectUser(String username, String password) {
        User loginUser = this.userDao.selectUserByname(username,DigestUtils.md5Hex(password));
        if (loginUser != null) {
            String token = UUIDGenerator.generatorUUID();
            this.redisService.set(Constants.USER + token, JSON.toJSONString(loginUser), 14400);
            this.redisService.set("username",loginUser.getFullName());
            this.redisService.set("userId",loginUser.getUserId().toString());
            log.info("web用户登录：{}", Constants.USER + token);
            loginUser.setToken(Constants.USER + token);
            log.info("token：{}", loginUser);
            return Result.data(loginUser);
        }
//        throw new CommonException(Constants.UNAUTHORIZED, "用户名密码不正确");
        return Result.failMsg();
    }

    @Override
    public Result saveUser(String username, String password) {
        User user = this.userDao.selectUserNameIfThere(username);
        if (user == null){
            this.userDao.saveUser(username, DigestUtils.md5Hex(password));
        }else {
            return Result.failMsg();
        }
        return Result.successMsg();
    }
}
