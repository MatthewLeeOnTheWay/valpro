package com.security.valpro.service;

import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    @PersistenceContext
    private EntityManager entityManager;
    public Page<SysUser> findUserCriteria(Integer page, Integer size, final SysUser user){


        Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC,"id");

        Page<SysUser> userPage=userDao.findAll(new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p1=criteriaBuilder.equal(root.get("name").as(String.class),user.getUsername());
                Predicate p2=criteriaBuilder.equal(root.get("id").as(String.class),user.getId());
                criteriaQuery.where(criteriaBuilder.and(p1,p2));
                return criteriaQuery.getRestriction();
            }
        },pageable);
        return userPage;
    }

    public void findTest(){
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        String sql="";
        session.createNativeQuery(sql).setResultSetMapping(sql);
        //返回类型是List<map>
/*		SQLQuery query2 = session.createSQLQuery(sql);
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.println("查询数据返回map"+query2.list());
		//返回数据是list<List<Object>>
		SQLQuery query3 = session.createSQLQuery(sql);
		query2.setResultTransformer(Transformers.TO_LIST);
		System.out.println("查询数据返回map"+query2.list());*/
		//返回类型是可定制化对象
		/*SQLQuery query = session.createSQLQuery(sql);
		Testtrans Testtrans = new Testtrans(Test.class);
		query.setResultTransformer(Testtrans);
		List<Test> list = (List<Test>)query.list();
		System.out.println("查询数据返回对象"+list);*/

		Query query=entityManager.createNativeQuery(sql);
//        List rows=query.getResultList();
//        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        for (Object obj : rows) {
            Map row = (Map) obj;
            System.out.println("id = " + row.get("ID"));
            System.out.println("name = " + row.get("NAME"));
            System.out.println("age = " + row.get("AGE"));
        }
    }

    public int findByMobile(String mobile){
        return userDao.findByMobile(mobile);
    }

    public void saveCommonUser(SysUser user){
        String password=user.getPassword();
        password= new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        user.setRole("ROLE_USER");
        userDao.save(user);
    }

    public SysUser findById(int id){
        return userDao.findById(id);
    }

    public void save(SysUser user){
        userDao.save(user);
    }
}
