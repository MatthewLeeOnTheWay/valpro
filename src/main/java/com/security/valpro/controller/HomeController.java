package com.security.valpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JJ
 * */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @RequestMapping("/user")
    public String userIndex(){
        return "user/home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/access-denied";
    }
}
