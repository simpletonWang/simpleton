package com.jw.resume.sys.controller;

import com.jw.resume.sys.pojo.Skills;
import com.jw.resume.sys.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("skills")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @GetMapping("selectSkillsSql")
    public String selectSkillsSql(String userId, Model model){
        List<Skills> skills = this.skillsService.selectSkillsBySql(userId);
        model.addAttribute("skills",skills);
        return "/personal/index.html";
    }
}

