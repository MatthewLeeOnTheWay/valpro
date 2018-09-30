package com.security.valpro.listener;

import com.security.valpro.utils.ContentEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

public class UserSmartListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType== ContentEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType==String.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("[UserInfoContent]msg:"+applicationEvent.getSource());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
