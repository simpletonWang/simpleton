package com.jw.resume.sys.service;

import com.jw.resume.sys.pojo.Skills;

import java.util.List;

public interface SkillsService {
    /**
     * 查询数据库技能
     * @return
     */
    List<Skills> selectSkillsBySql(String userId);

    /**
     * 查询其他技能
     */
    List<Skills>  selectSkills(String userId);
}
