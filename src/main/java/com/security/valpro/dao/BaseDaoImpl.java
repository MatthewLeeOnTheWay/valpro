package com.security.valpro.dao;

import com.mysql.cj.api.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BaseDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 获取HibernateSession
     */
   /* private Session getHibernateSession() {
        //获取Hibernate中的Session
        Session hibernateSession = entityManager.unwrap(org.hibernate.Session.class);
        return hibernateSession;
    }*/

    //获取Session
    private SqlSession getSession(){
        SqlSession session=entityManager.unwrap(org.apache.ibatis.session.SqlSession.class);
        return session;
    }

    //获取Session,配置文件获取，需要close；
    private SqlSession getSessionUni(){
        SqlSession session=sqlSessionFactory.openSession();
        return session;
    }

    //获取Session方式3，更快
    private SqlSession getSessionTri(){
        SqlSession session=sqlSessionTemplate;
        return session;
    }

}
