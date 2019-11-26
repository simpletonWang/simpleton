package com.jw.resume.sys.dao;

import com.jw.resume.sys.pojo.UserInfoVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {

    /**
     * 查询用户信息
     */
    UserInfoVO selectUserInfo(String username);
}
