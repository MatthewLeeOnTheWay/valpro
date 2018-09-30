package com.security.valpro.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Aspect
public class DataResourceAuthorityInterceptor {
//    @Autowired
//    private UserAuthorityHelper userAuthorityHelper;
//
//    @Autowired
//    private SystemSettings systemSettings;
//
//    /**
//     * 切入点设置，拦截所有具有{@link com.wawscm.shangde.annotation.QueryMethod}注解的方法
//     */
//    @Pointcut("@annotation(com.wawscm.shangde.annotation.QueryMethod)")
//    public void queryMethodPointcut() {
//    }
//
//    /**
//     * 环绕通知
//     * @param joinPoint ProceedingJoinPoint
//     * @return 方法返回的对象
//     * @throws Throwable 方法执行时抛出的异常，此处不做任何处理，直接抛出
//     */
//    @Around(value = "queryMethodPointcut()")
//    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object object = joinPoint.proceed();
//        String methodName = this.getMethodName(joinPoint);
//        if (object != null) {
//            if (object instanceof Filterable) {
//                this.doFilter((Filterable) object, methodName);
//            }
//
//            if (object instanceof MetaSetter) {
//                this.metaHandler((MetaSetter)object, methodName);
//            }
//        }
//        return object;
//    }
}

