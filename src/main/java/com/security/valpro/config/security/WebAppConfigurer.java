package com.security.valpro.config.security;


import com.security.valpro.filterInteceptor.UriInteceptor;
import groovy.util.logging.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@Slf4j
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/sign_in").setViewName("login");
        registry.addViewController("/sign_up").setViewName("about");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UriInteceptor()).addPathPatterns("/**");
    }
}
