package com.security.valpro.service;

import com.security.valpro.dao.RoleDao;
import com.security.valpro.dao.UserDao;
import com.security.valpro.dao.UserRoleDao;
import com.security.valpro.entity.SysRole;
import com.security.valpro.entity.SysUser;
import com.security.valpro.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service//初始化数据,项目启动时执行
public class DataInit {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleDao userRoleDao;

    @PostConstruct
    void dataUnit(){
        String uuid= UUID.randomUUID().toString();
        SysUser admin=new SysUser();
        SysUser jack=new SysUser();

        admin.setUsername("admin_"+uuid);
        admin.setPassword("admin");

        jack.setUsername("jack_"+uuid);
        jack.setPassword("123456");

        userDao.save(admin);
        userDao.save(jack);

        SysRole adminRole=new SysRole();
        SysRole jackRole=new SysRole();

        adminRole.setRoleName("ROLE_ADMIN");
        jackRole.setRoleName("ROLE_USER");

        roleDao.save(adminRole);
        roleDao.save(jackRole);

        UserRole userRoleAdminRecord1=new UserRole();
        userRoleAdminRecord1.setUserId(admin.getId());
        userRoleAdminRecord1.setRoleId(adminRole.getId());
        userRoleDao.save(userRoleAdminRecord1);

        UserRole userRoleJackRecord2=new UserRole();
        userRoleJackRecord2.setUserId(jack.getId());
        userRoleJackRecord2.setRoleId(jackRole.getId());
        userRoleDao.save(userRoleJackRecord2);
    }
}
