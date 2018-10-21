package com.security.valpro.controller;

import com.security.valpro.entity.Msg;
import org.python.util.PythonInterpreter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JJ
 * */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        Msg msg=new Msg("测试标题","测试内容","测试信息");
        model.addAttribute("msg",msg);
        return "login";
    }

    @RequestMapping("/calculate")
    @PreAuthorize(value="hasAnyRole('admin','user')")
    public int calCount(){
        PythonInterpreter interpreter=new PythonInterpreter();
        return 1;
    }

    @RequestMapping("/home")
    public String userIndex(){
        return "home";
    }

    @RequestMapping("/fail")
    public String fail(){
        return "home";
    }
}
