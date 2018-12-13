package com.security.valpro.controller;

import com.security.valpro.dao.MdStockDao;
import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.MdStock;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.MdStockService;
import com.security.valpro.service.UserService;
import com.security.valpro.utils.UpdateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('USER')")
@Controller
@RequestMapping("/user")
public class CoXhController {
    @Autowired
    private UserService userService;
    @Autowired
    private MdStockService stockService;

    @RequestMapping("/queryStock")
    public String queryStock(){
        return "/query_stock";
    }

    @RequestMapping("/delete/{stockId}")
    public String deleteStock(@PathVariable int stockId, Model model){
        int i=stockService.deleteById(stockId);
        if(i==1){
            model.addAttribute("result","成功删除id为"+stockId+"的该项信息");
        }else {
            model.addAttribute("error","未能成功删除该信息!");
        }
        return "redirect:/user";
    }

    //修改时错误更新字段的解决方法
    @PostMapping(value = "/save")
    public String save(@RequestBody SysUser u) {
        if(u.getId() != 0){
            SysUser user= userService.findById(u.getId());
            UpdateTool.copyNullProperties(user, u);
        }
        userService.save(u);
        return "更新成功";
    }

    @ResponseBody
    @RequestMapping("/getStockList")
    public List<MdStock> getStocksList(){
        List<MdStock> mdStocks=stockService.findAll();
        return mdStocks;
    }
}
