package com.security.valpro.config.security;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)
    ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("/error/error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        modelAndView.addObject("stackTrace",exception.getStackTrace());
        return modelAndView;
    }
}
