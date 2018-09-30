package com.security.valpro.utils;

public class Person {
/*
* 处理方法中使用
* @Pointcut("@annotation(com.wawscm.shangde.annotation.QueryMethod)")
* */
    @Sex(gender = Sex.GenderType.Male)
    public String sex;

}
