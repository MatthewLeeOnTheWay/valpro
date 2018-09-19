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
    @PreAuthorize(value = "hasRole('admin')")
    public String index(Model model){
        Msg msg=new Msg("测试标题","测试内容");
        model.addAttribute("msg",msg);
        return "home";
    }

    @RequestMapping("/calculate")
    @PreAuthorize(value="hasAnyRole('admin','user')")
    public int calCount(){
        PythonInterpreter interpreter=new PythonInterpreter();
        return 1;
    }
}
