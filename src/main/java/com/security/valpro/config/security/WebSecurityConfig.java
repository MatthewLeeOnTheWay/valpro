package com.security.valpro.config.security;

import com.security.valpro.service.CustomUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;


//.antMatchers("/admin/**").hasRole("ROLE_ADMIN")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static Logger logger= LoggerFactory.getLogger(WebSecurityConfig.class);
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Autowired
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


        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/amchart/**",
                        "/bootstrap/**",
                        "/build/**",
                        "/css/**",
                        "/dist/**",
                        "/documentation/**",
                        "/fonts/**",
                        "/js/**",
                        "/pages/**",
                        "/plugins/**").permitAll()  // 允许访问资源
                .antMatchers("/", "/home", "/about").permitAll() //允许访问这三个路由
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .failureForwardUrl("/fail")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);           //自定义异常处理
    }





}
