package com.security.valpro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('USER')")
@Controller
public class CoXhController {

    @RequestMapping("/queryStock")
    public String queryStock(){
        return "/query_stock";
    }
}
