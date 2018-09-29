package com.security.valpro.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
//      （4）登录成功后跳转的路径为/httpapi
//      （5）退出后跳转到的url为/
//      （6）认证鉴权信息的Bean，采用我们自定义的从数据库中获取用户信息的LightSwordUserDetailService类。
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/loginSec").setViewName("/loginSec");
    }
}
