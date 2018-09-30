package com.security.valpro.service;

import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
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
}
