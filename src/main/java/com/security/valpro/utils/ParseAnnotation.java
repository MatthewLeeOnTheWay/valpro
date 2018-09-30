package com.security.valpro.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ParseAnnotation {
    public void parseMethod(final Class<?> clazz) throws Exception {
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        final Method[] methods = clazz.getDeclaredMethods();
        
        for (final Method method : methods) {
            final QueryMethod q = method.getAnnotation(QueryMethod.class);
            if (null != q) {
                method.invoke(obj, q.name());
            }
        }
        String result="";
        Field[] declaredFieldss = clazz.getDeclaredFields();
        for (Field field : declaredFieldss) {
            if (field.isAnnotationPresent(QueryMethod.class)) {
                if (field.isAnnotationPresent(QueryMethod.class)) {
                    QueryMethod annotation = field.getAnnotation(QueryMethod.class);
                    String value = annotation.name();
                    result += (field.getName() + ":" + value + "\n");
                }
            }
        }
//      return result;
    }
}
