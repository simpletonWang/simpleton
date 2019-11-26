package com.jw.resume.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Table(name = "t_user")
public class User {

    /**
     * 用户
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    @Size(message = "用户主键过长！", max = 20)
    private Long userId;


    @Column(name = "full_name")
    @Size(message = "用户主键过长！", max = 20)
    private String fullName;


    @Column(name = "password")
    @Size(message = "用户主键过长！", max = 20)
    private String password;

    @Column(name = "alias")
    @Size(message = "用户主键过长！", max = 20)
    private String alias;

    @Column(name = "date_of_birth")
    @Size(message = "用户主键过长！", max = 20)
    private String dateOfBirth;

    @Column(name = "address")
    @Size(message = "用户主键过长！", max = 20)
    private String address;

    @Column(name = "email")
    @Size(message = "用户主键过长！", max = 50)
    private String email;

    @Column(name = "phone")
    @Size(message = "用户主键过长！", max = 50)
    private String phone;

    @Column(name = "state")
    @Size(message = "用户主键过长！", max = 20)
    private String state;

    @Transient
    private String token;
}
