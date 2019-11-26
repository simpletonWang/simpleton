package com.jw.resume.sys.controller;

import com.jw.resume.common.pojo.Result;
import com.jw.resume.sys.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
@Api(description = "用户信息控制器")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    @GetMapping("selectUserInfo")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名")
    public ResponseEntity<Result> selectUserInfo(String username){
        Result result = this.userInfoService.selectUserInfo(username);
        return ResponseEntity.ok(result);
    }
}
