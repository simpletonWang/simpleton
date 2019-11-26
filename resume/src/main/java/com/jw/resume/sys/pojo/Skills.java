package com.jw.resume.sys.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Table(name = "t_skills")
public class Skills {
    /**
     * 技能
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "sk_id")
    @Size(message = "技能主键过长！", max = 10)
    private String skId;

    /**
     * 技能名称
     */
    @Column(name = "sk_name")
    @Size(message = "技能名称过长！", max = 20)
    private String skName;

    /**
     * 熟练度
     */
    @Column(name = "sk_proficiency")
    @Size(message = "熟练度过长！", max = 20)
    private String skProficiency;

    /**
     * 类型
     */
    @Column(name = "sk_type")
    @Size(message = "技能类型过长！", max = 20)
    private String skType;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @Size(message = "用户id过长！", max = 10)
    private String userId;
}
