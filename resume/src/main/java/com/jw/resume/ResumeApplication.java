package com.jw.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.jw.resume.*.dao"})
@ComponentScan(basePackages = {"com.jw"})
@EnableSwagger2
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }

}
