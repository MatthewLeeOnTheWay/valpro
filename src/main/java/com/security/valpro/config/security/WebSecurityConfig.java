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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
// 这个注解，可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解。
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static Logger logger= LoggerFactory.getLogger(WebSecurityConfig.class);
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    @Bean
    public UserDetailsService customUserService(){
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
        web.ignoring().antMatchers("/", "/static/**","/register","/registration","/login_error","/about","/error");
    }

    protected void configure(HttpSecurity http)throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/user").hasAnyRole("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/admin").hasAnyRole("ROLE_ADMIN")
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
