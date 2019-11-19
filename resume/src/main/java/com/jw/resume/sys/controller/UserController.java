package com.jw.resume.sys.controller;

import com.jw.resume.sys.pojo.User;
import com.jw.resume.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("selectUser")
    public List<User> selectUser(User user){
        List<User> users = this.userService.selectUser(user);
        return users;
    }
}
