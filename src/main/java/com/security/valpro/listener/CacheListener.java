package com.security.valpro.listener;

import com.security.valpro.service.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

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

                    }
                }
            }
        }.start();
    }
}
