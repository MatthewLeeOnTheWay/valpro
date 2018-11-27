package com.security.valpro.controller;

import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/register")
    public String regist(){
	 return "register";
    }

    @RequestMapping("/error_test")
    public String errorHandler(){
        return "/error/error";
    }

    @PostMapping("/registration")
    public String registration(SysUser user){
	    String mobile=user.getMobile();
	    int i=userService.findByMobile(mobile);
	    if(i>0){
	        return "redirect:/login_error";
        }else{
            userService.saveCommonUser(user);
            return "/user";
        }
    }

    @RequestMapping(value = "/login_error")
    @ResponseBody
    public String rsError(){
	    return "注册失败，当前手机号码已经被注册过！";
    }
}
