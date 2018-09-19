package com.security.valpro.dao;

import com.security.valpro.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<SysUser,Integer>{
    SysUser findByUsername(String name);
}
