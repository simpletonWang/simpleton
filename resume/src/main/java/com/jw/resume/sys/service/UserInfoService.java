package com.jw.resume.sys.service;

import com.jw.resume.common.pojo.Result;

public interface UserInfoService {

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    Result selectUserInfo(String username);
}
