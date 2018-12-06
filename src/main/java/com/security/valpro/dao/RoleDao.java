package com.security.valpro.dao;

import com.security.valpro.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleDao extends JpaRepository<SysRole,Integer> {
    SysRole getOne(Integer id);

//    @Query(value = "select * from xxx where if(?1 !='',x1=?1,1=1) and if(?2 !='',x2=?2,1=1)" +
//            "and if(?3 !='',x3=?3,1=1)  ",nativeQuery = true)
//    @Query("select t from Task t where t.taskName = :taskName and t.createTime = :createTime")
//    SysRole findByTaskName(@Param("taskName")String taskName, @Param("createTime") Date createTime);
}
