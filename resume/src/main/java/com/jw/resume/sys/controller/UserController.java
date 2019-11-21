package com.jw.resume.sys.controller;

import com.jw.resume.common.pojo.Result;
import com.jw.resume.sys.pojo.User;
import com.jw.resume.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("selectUser")
    public ResponseEntity<Result> selectUser(String username, String password){
        Result result= this.userService.selectUser(username, password);
        return ResponseEntity.ok(result);
    }
}
