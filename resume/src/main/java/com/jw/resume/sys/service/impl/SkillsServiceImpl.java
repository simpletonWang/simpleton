package com.jw.resume.sys.service.impl;

import com.jw.resume.common.service.RedisService;
import com.jw.resume.sys.dao.SkillsDao;
import com.jw.resume.sys.pojo.Skills;
import com.jw.resume.sys.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {
    @Autowired
    private SkillsDao skillsDao;

    @Autowired
    private RedisService redisService;

    @Override
    public List<Skills>  selectSkillsBySql(String userId) {
        userId = redisService.get("userId");
        List<Skills> skills = this.skillsDao.selectSkillsBySql(userId);
        return skills;
    }

    @Override
    public List<Skills>  selectSkills(String userId) {
        userId = redisService.get("userId");
        List<Skills> skills = this.skillsDao.selectSkills(userId);
        return skills;
    }
}
