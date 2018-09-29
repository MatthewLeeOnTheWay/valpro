package com.security.valpro.listener;

import com.security.valpro.service.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CacheListener {
    @Autowired
    private CacheManager cacheManager;

    private Logger logger= Logger.getLogger(CacheListener.class.getName());
    public CacheListener(CacheManager cacheManager){
        this.cacheManager=cacheManager;
    }

    public void startListen(){
        new Thread(){
            public void run(){
                while(true){
                    for(String key:cacheManager.getAllKeys()){
                        if(cacheManager.isTimeOut(key)){
                            cacheManager.clearByKey(key);
                            logger.info(key+"缓存被清除------------------------------------------");
                        }
                    }
                }
            }
        }.start();
    }
}
