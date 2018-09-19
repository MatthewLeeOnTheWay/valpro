package com.security.valpro.config.db;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class MyBatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sessionFactoryBean(ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //sessionFactory.setPlugins(new Interceptor[]{new PageInteceptor()});
        // sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:com.security.valpro/*.xml"));
        return sessionFactory;
    }

//    @Bean(name="sqlSessionTemplate")
//    public SqlSession sqlSessionTemplate(){
//        sqlSessionTemplate()
//    }
}
