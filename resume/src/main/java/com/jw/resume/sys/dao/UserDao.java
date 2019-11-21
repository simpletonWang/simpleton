package com.jw.resume.sys.dao;

import com.jw.resume.sys.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> selectUserByname(String username,String password);
}
