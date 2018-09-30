package com.security.valpro.utils;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryMethod {
    public String name() default "fieldName";
    public  String setFuncName() default "setField";
    public String getFuncName() default "getFuncName";
    public  boolean defaultDBValue() default false;
    public enum FontColor{RED,BLACK,YELLOW};
}
