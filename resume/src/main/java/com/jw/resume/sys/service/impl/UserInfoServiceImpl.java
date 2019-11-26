package com.jw.resume.sys.service.impl;

import com.jw.resume.common.pojo.Result;
import com.jw.resume.common.service.RedisService;
import com.jw.resume.sys.dao.UserInfoDao;
import com.jw.resume.sys.pojo.UserInfoVO;
import com.jw.resume.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private RedisService redisService;
    @Override
    public Result selectUserInfo(String username) {
        String name = redisService.get("username");
        UserInfoVO userInfoVO = this.userInfoDao.selectUserInfo(name);
        return Result.data(userInfoVO);
    }
}
