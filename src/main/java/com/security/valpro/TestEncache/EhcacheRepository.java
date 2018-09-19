package com.security.valpro.TestEncache;

import com.security.valpro.entity.SysRole;

/**
 * @author Lee
 * */
public interface EhcacheRepository {

    /**
     * @author Lee
     */
    SysRole save(SysRole role) ;

    SysRole selectById(Integer id);

    SysRole updateById(SysRole role);
    /**
     * 删除用户
     * @param id 主键
     * @return 删除状态
     * */
    String deleteById(Integer id);
}
