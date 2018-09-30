package com.security.valpro.listener;

import com.security.valpro.utils.ContentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

public class UserListener implements ApplicationListener<ContentEvent> {
    @Override
    public void onApplicationEvent(ContentEvent contentEvent) {
        System.out.println("msg:"+contentEvent.getSource());
    }
}
