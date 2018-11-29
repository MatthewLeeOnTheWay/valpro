package com.security.valpro.controller;

import com.security.valpro.dao.UserDao;
import com.security.valpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
//    private PasswordEncoder passwordEncoder;
	@GetMapping("/")
    public String index() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof AnonymousAuthenticationToken){
            return "login";
        }else{
            //获取请求过来的验证对象，名字以及角色正确才能访问到相应权限的页面
            String path0=request.getServletPath();
            return "user";
        }*/
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}
