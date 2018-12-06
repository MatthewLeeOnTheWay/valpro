package com.security.valpro.dao;

import com.security.valpro.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

}
