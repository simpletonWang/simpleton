package com.jw.resume.sys.controller;

import com.jw.resume.common.pojo.Result;
import com.jw.resume.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
@Api(description = "用户控制器")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("selectUser")
    public ResponseEntity<Result> selectUser(String username, String password){
        Result result= this.userService.selectUser(username, password);
        return ResponseEntity.ok(result);
    }

    /**
     * 注册
     */
    @PostMapping("saveUser")
    @ApiOperation(value = "注册", notes = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码"),
    })
    public ResponseEntity<Result> saveUser(String username,String password){
        Result result = this.userService.saveUser(username, password);
        return ResponseEntity.ok(result);
    }
}
