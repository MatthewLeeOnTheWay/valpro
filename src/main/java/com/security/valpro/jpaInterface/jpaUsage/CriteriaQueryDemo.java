package com.security.valpro.jpaInterface.jpaUsage;

import com.security.valpro.entity.SysRole;
import org.springframework.cglib.core.Predicate;
import org.springframework.util.Assert;

public class CriteriaQueryDemo {
//    CriteriaBuilder buillder=em.getCriteriaBuilder();
//    CriteriaQuery<SysRole> query=builder.createQuery(SysRole.class);
//
//    Root<SysRole> root=query.from(SysRole.class);
//
//    Predicate p1=builder.like(root.<String> get("name"),"%"+sysRole.getName()+"%");
//    Predicate p2=builder.equal(root.<String> get("password"),sysRole.getPassword());
//
//    @Override
//    public List<Employee> findByCompanyName(final String companyName, final String wage) {
//
//        List<Employee> employeeList = employeeRepository.findAll(new Specification<Employee>() {
//            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
////                ListJoin<Employee, Company> companyJoin = root.join(root.getModel().getList("companyList", Company.class), JoinType.LEFT);
//                Join<Employee, Company> companyJoin = root.join("companySet", JoinType.LEFT);
//                Join<Employee, Wage> wageJoin = root.join("wageSet", JoinType.LEFT);
//                Predicate p1 = cb.equal(companyJoin.get("name"), companyName);
//                Predicate p2 = cb.equal(wageJoin.get("name"), wage);
////              return cb.and(p1, p2);根据spring-data-jpa的源码，可以返回一个Predicate，框架内部会自动做query.where(p)的操作，也可以直接在这里处理，然后返回null，///              也就是下面一段源码中的实现
//                query.where(p1, p2);
//                return null;
//            }
//        });
//
//        return employeeList;
//    }

    /**
     * Applies the given {@link Specification} to the given {@link CriteriaQuery}.
     *
     * @param spec can be {@literal null}.
     * @param query must not be {@literal null}.
     * @return
     */
//    private <S> Root<T> applySpecificationToCriteria(Specification<T> spec, CriteriaQuery<S> query) {
//
//        Assert.notNull(query);
//        Root<T> root = query.from(getDomainClass());
//
//        if (spec == null) {
//            return root;
//        }
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        Predicate predicate = spec.toPredicate(root, query, builder);
//　　　　// 这里如果我们重写的toPredicate方法的返回值predicate不为空，那么调用query.where(predicate)
//        if (predicate != null) {
//            query.where(predicate);
//        }
//
//        return root;
//    }
}
