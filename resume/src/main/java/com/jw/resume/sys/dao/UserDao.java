package com.jw.resume.sys.dao;

import com.jw.resume.sys.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    User selectUserByname(String username,String password);

    /**
     * 根据用户名查询是否存在
     */
    User selectUserNameIfThere(String username);

    /**
     * 注册
     */
    int saveUser(String username,String password);
}
