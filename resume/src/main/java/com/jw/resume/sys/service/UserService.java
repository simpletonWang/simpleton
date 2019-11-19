package com.jw.resume.sys.service;

import com.jw.resume.sys.pojo.User;

import java.util.List;

public interface UserService {

    List<User> selectUser(User user);
}
