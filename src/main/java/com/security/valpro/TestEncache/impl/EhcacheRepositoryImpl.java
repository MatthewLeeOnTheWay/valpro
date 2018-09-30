package com.security.valpro.TestEncache.impl;

import com.security.valpro.TestEncache.EhcacheRepository;
import com.security.valpro.entity.SysRole;
import com.security.valpro.dao.SysRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames={"lemonCache"})
@Repository
public class EhcacheRepositoryImpl implements EhcacheRepository{
    private static final Logger logger= LoggerFactory.getLogger(EhcacheRepository.class);

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @CachePut(key="#p0")
    @Override
    public SysRole save(SysRole role) {
        SysRole savedRole=sysRoleRepository.save(role);
        logger.info("新增功能，同步缓存，直接写入数据库，ID为："+savedRole.getId());
        return savedRole;
    }

    @Cacheable(key="#p0")
    @Override
    public SysRole selectById(Integer id) {
//        logger.info("查询功能，缓存未找到，直接查询数据库"+id);
//        return sysRoleRepository.findOne(id);
        return null;
    }
    @CachePut(key="#p0")
    @Override
    public SysRole updateById(SysRole role) {
        logger.info("更新功能，更新缓存，直接更新，ID为："+role.getId());
        return sysRoleRepository.save(role);
    }

    @CacheEvict(key="#p0")
    @Override
    public String deleteById(Integer id) {
        logger.info("删除功能，删除缓存，直接删除数据库，ID为："+id);
        sysRoleRepository.deleteById(id);
        return null;
    }
}
