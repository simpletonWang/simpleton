package com.jw.resume.sys.service;

import com.jw.resume.common.pojo.Result;


public interface UserService {

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    Result selectUser(String username, String password);

    /**
     * 注册
     */
    Result saveUser(String username,String password);
}
