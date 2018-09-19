package com.security.valpro.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author JJ
 * 注册访问 /login 转向 login.html 页面
 * */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    public void addViewController(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }

}
