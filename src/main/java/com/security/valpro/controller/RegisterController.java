package com.security.valpro.controller;

import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/check/checkName",method = RequestMethod.POST)
    public boolean checkName(String username){
        return userDao.findUsernameExist(username)>0?true:false;
    }

    @ResponseBody
    @RequestMapping(value = "/check/checkMobile",method = RequestMethod.POST)
    public boolean checkMobile(String mobile){
        return userDao.findByMobile(mobile)>0?true:false;
    }

    @GetMapping("/register")
    public String regist(){
        return "register";
    }

    @RequestMapping("/error_test")
    public String errorHandler(){
        return "/error/error";
    }

    @PostMapping("/glee/registration")
    @Transactional
    public String registration(SysUser user, RedirectAttributes redirectAttributes){
        userService.saveCommonUser(user);
        redirectAttributes.addFlashAttribute("registerInfo","您已经成功注册，请输入密码重新登陆");
        return "redirect:/login";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test/test";
    }
}
