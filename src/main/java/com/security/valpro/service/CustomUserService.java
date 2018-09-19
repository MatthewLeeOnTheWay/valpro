package com.security.valpro.service;

import com.security.valpro.dao.RoleDao;
import com.security.valpro.dao.UserDao;
import com.security.valpro.dao.UserRoleDao;
import com.security.valpro.entity.SysRole;
import com.security.valpro.entity.SysUser;
import com.security.valpro.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomUserService deliver justice to SimpleGrantedAuthority
 * then god damn ok!
 * */
@Service
public class CustomUserService implements UserDetailsService{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    RoleDao roleDao;


    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        SysUser user=userDao.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(username+"NOT FOUND");
        }

        List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
        List<UserRole> userRoles=userRoleDao.listByUserId(user.getId());

        for (UserRole userRole:userRoles){
            Integer roleId=userRole.getRoleId();
            String roleName=roleDao.getOne(roleId).getRoleName();

            if(!StringUtils.isEmpty(roleName)){
                authorities.add(new SimpleGrantedAuthority(roleName));
            }

            System.err.println("username is"+username+","+roleName);
        }
        return new User(username,user.getPassword(),authorities);

//        SysUser user = userDao.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//            System.out.println(role.getRoleName());
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(), authorities);
    }
}
