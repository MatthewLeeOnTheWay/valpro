package com.security.valpro.config.security;

import com.security.valpro.service.CustomUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

//.antMatchers("/admin/**").hasRole("ROLE_ADMIN")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static Logger logger= LoggerFactory.getLogger(WebSecurityConfig.class);
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        /**
         * 内存用户名密码认证
         *
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("root")
                .roles("USER");*/
        auth.userDetailsService(customUserService());
    }

    protected void configure(HttpSecurity http)throws Exception{


        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/amchart/**",
                        "/bootstrap/**",
                        "/build/**",
                        "/css/**",
                        "/dist/**",
                        "/documentation/**",
                        "/fonts/**",
                        "/js/**",
                        "/pages/**",
                        "/plugins/**").permitAll()//默认不拦截静态资源的url pattern
        .anyRequest().authenticated().and()
        .formLogin().loginPage("/loginSec")
        .defaultSuccessUrl("/httpapi").permitAll().and()
        .logout().permitAll();//退出默认的跳转页面

        http.logout().logoutSuccessUrl("/");
    }

}
