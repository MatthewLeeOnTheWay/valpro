package com.security.valpro.dao;

import com.security.valpro.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole,Integer>{
    @Query(value = "select ur.* from user_role ur where ur.id =:id",nativeQuery = true)
    List<UserRole> listByUserId(@Param("id") Integer id);
}
