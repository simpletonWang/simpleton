package com.jw.resume.sys.dao;

import com.jw.resume.sys.pojo.Skills;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsDao {

    /**
     * 查询数据库技能
     * @return
     */
    List<Skills> selectSkillsBySql(String userId);

    /**
     * 查询其他技能
     */
    List<Skills> selectSkills(String userId);
}
