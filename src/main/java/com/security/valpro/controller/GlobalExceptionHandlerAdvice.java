package com.security.valpro.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)
    ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("/error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        modelAndView.addObject("stackTrace",exception.getStackTrace());
        return modelAndView;
    }
}
