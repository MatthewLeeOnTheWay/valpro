package com.security.valpro.testSservice;

import com.security.valpro.entity.SysRole;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.CustomUserService;
import com.security.valpro.utils.BaseJUnit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class BaseInfoService extends BaseJUnit4Test {
    @Autowired
    private CustomUserService customUserService;


    @Test
    @Transactional
    @Rollback(false)
    public void test(){
        System.out.print("测试工作正在展开");
        SysUser sysUser=new SysUser();
        List<SysRole> sysRoles=new ArrayList<SysRole>();
        sysUser.setPassword("123456");
        sysUser.setRoles(sysRoles);
        sysUser.setUsername("matthew");
    }
}
