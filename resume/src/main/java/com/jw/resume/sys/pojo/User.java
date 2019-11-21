package com.jw.resume.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
@Data
public class User {

    /**
     * 用户
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    @Size(message = "用户主键过长！", max = 20)
    private Long userId;


    @Column(name = "name")
    @Size(message = "用户主键过长！", max = 255)
    private String name;


    @Column(name = "password")
    @Size(message = "用户主键过长！", max = 255)
    private String password;

    @Transient
    private String token;
}
