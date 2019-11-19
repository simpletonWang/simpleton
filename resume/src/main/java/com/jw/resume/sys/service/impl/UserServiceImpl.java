package com.jw.resume.sys.service.impl;

import com.jw.resume.sys.dao.UserDao;
import com.jw.resume.sys.pojo.User;
import com.jw.resume.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询用户
     * @return
     */
    @Override
    public List<User> selectUser(User user) {
        return this.userDao.selectUserByname(user);
    }
}
