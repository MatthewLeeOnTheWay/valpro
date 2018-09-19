package com.security.valpro.jpaInterface;

import com.security.valpro.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {
    //    define query statement can be transfer
    Optional<SysRole> findById(Integer id);

    SysRole findByNameAndid(String name, Integer id);
//  can be directly use
    @Query("select p from SysRole p where p.name=:name and p.id=:id")
    SysRole withNameAndIdQuery(@Param("name") String name, @Param("id") Integer id);

    SysRole withNameAndidNamedQuery(String name, Integer id);

    void deleteById(Integer id);


    /**
     * //查询id值最大的那个person
     //使用@Query注解可以自定义JPQL语句，语句可以实现更灵活的查询
     @Query("SELECT p FROM Person p WHERE p.id=(SELECT max(p2.id) FROM Person p2)")
     Person getMaxIdPerson();

     @Modifying
     @Query("update Person p set p.email=:email where id=:id")
     void updatePersonEmail(@Param("id")Integer id,@Param("email")String email);
     * */

    //nativeQuery=true can use sql query

    //可以通过自定义的JPQL 完成update和delete操作，注意：JPQL不支持Insert操作
    //在@Query注解中编写JPQL语句，但必须使用@Modify进行修饰，以通知SpringData，这是一个Update或者Delete
    //Update或者delete操作，需要使用事务，此时需要定义Service层，在service层的方法上添加事务操作
    //默认情况下，SpringData的每个方法上有事务，但都是一个只读事务，他们不能完成修改操作
}
