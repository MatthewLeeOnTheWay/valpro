package com.security.valpro.base;

import com.security.valpro.utils.ContentEvent;
import org.springframework.context.ApplicationListener;

public class UserListener implements ApplicationListener<ContentEvent> {
    @Override
    public void onApplicationEvent(ContentEvent contentEvent) {
        System.out.println("msg:"+contentEvent.getSource());
    }
}
