package com.security.valpro.service;

import com.security.valpro.Interface.ICacheManager;
import com.security.valpro.entity.EntityCache;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheManager implements ICacheManager {
    private static Map<String,EntityCache> caches=new ConcurrentHashMap<String,EntityCache>();
    @Override
    public void putCache(String key, EntityCache cache) {
        caches.put(key,cache);
    }

    @Override
    public void putCache(String key, Object datas, long timeout) {
        timeout=timeout>0?timeout:0L;
        putCache(key,new EntityCache(datas,timeout,System.currentTimeMillis()));
    }

    @Override
    public EntityCache getCacheByKey(String key) {
        if(this.isContains(key)){
            return caches.get(key);
        }
        return null;
    }

    @Override
    public Object getCacheDataByKey(String key) {
        if(this.isContains(key)){
            return caches.get(key).getDatas();
        }
        return null;
    }

    @Override
    public Map<String, EntityCache> getCacheAll() {
        return caches;
    }

    @Override
    public boolean isContains(String key) {
        return caches.containsKey(key);
    }

    @Override
    public void clearAll() {
        caches.clear();
    }

    @Override
    public void clearByKey(String key) {
        if(this.isContains(key)){
            caches.remove(key);
        }
    }

    @Override
    public boolean isTimeOut(String key) {
        if(!caches.containsKey(key)){
            return true;
        }
        EntityCache cache=caches.get(key);
        long timeout=cache.getTimeout();
        long lastRefreshTime=cache.getLastRefreshTime();
        if(timeout==0||System.currentTimeMillis()-lastRefreshTime>=timeout){
            return true;
        }
        return false;
    }

    @Override
    public Set<String> getAllKeys() {
        return caches.keySet();
    }
}
