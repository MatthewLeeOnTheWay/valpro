package com.security.valpro.jpaInterface.jpaUsage;

import com.security.valpro.jpaInterface.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserQueryDemo {
//    @Autowired
//    private SysRoleRepository sysRoleRepository;

//    @Override
//    public Page<Student> search(final Student student, PageInfo page) {
//        return studentRepository.findAll(new Specification<Student>() {
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//                Predicate stuNameLike = null;
//                if(null != student && !StringUtils.isEmpty(student.getName())) {
//　　　　　　　　　　　// 这里也可以root.get("name").as(String.class)这种方式来强转泛型类型
//                    stuNameLike = cb.like(root.<String> get("name"), "%" + student.getName() + "%");
//                }
//
//                Predicate clazzNameLike = null;
//                if(null != student && null != student.getClazz() && !StringUtils.isEmpty(student.getClazz().getName())) {
//                    clazzNameLike = cb.like(root.<String> get("clazz").<String> get("name"), "%" + student.getClazz().getName() + "%");
//                }
//
//                if(null != stuNameLike) query.where(stuNameLike);
//                if(null != clazzNameLike) query.where(clazzNameLike);
//                return null;
//            }
//        }, new PageRequest(page.getPage() - 1, page.getLimit(), new Sort(Direction.DESC, page.getSortName())));
//    }
}
