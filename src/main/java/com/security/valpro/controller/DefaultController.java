package com.security.valpro.controller;

import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
    private UserDao userRepository;
    private PasswordEncoder passwordEncoder;
    
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

    @ResponseBody
    @PostMapping("/registry")
    public void registry(SysUser user) {
        System.out.println("注册成功");
        userRepository.save(new SysUser(user.getUsername(), passwordEncoder.encode(user.getPassword())));
    }
}
