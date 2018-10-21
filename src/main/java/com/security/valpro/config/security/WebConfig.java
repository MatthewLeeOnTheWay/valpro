package com.security.valpro.config.security;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by luoyiliang on 2017/7/13.
 */
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.example.login.securitylogin.web.*"})
// spring mvc的Bean上下文环境
public class WebConfig implements WebMvcConfigurer
{
//	@Bean
	public InternalResourceViewResolver viewResolver()
		{
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("jsp/");
			viewResolver.setSuffix(".jsp");
			viewResolver.setViewClass(JstlView.class);
			return viewResolver;
		}

	/**
	 * 配置静态资源的处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
		{
			configurer.enable();
		}

}
