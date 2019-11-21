package com.jw.resume.sys.service;

import com.jw.resume.common.pojo.Result;


public interface UserService {

    Result selectUser(String username, String password);
}
