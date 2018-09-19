package com.security.valpro.dao;

import com.security.valpro.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole,Integer>{
    List<UserRole> listByUserId(Integer id);
}
