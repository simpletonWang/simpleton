package com.jw.resume.config.mvc;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;


/**
 * 文件上传配置
 */
@SpringBootConfiguration
public class FileUploadConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,
        factory.setMaxFileSize(DataSize.parse("30MB")); // KB,MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("30MB"));
        return factory.createMultipartConfig();
    }
}
