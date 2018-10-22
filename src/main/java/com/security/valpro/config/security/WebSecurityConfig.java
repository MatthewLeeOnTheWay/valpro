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
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


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
         */
        /*auth.inMemoryAuthentication()
                .withUser("root")
                .password("root")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin123")
                .roles("admin");*/
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/css/**","/images/**","/js/**","/static/**");
    }
    protected void configure(HttpSecurity http)throws Exception{


        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/about","/registry","/sign_up").permitAll() //允许访问这三个路由
                .antMatchers("/user").hasAnyRole("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/sign_in").loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home",true)
                    .failureUrl("/sign_in?error").permitAll()
                .and().sessionManagement().invalidSessionUrl("/sign_in")
                .and().rememberMe().tokenValiditySeconds(1209600)
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and().csrf().disable();
    }
}
