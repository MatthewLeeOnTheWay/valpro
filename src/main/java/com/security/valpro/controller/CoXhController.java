package com.security.valpro.controller;

import com.security.valpro.dao.MdStockDao;
import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.MdStock;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.UserService;
import com.security.valpro.utils.UpdateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@PreAuthorize("hasRole('USER')")
@Controller
@RequestMapping("/user")
public class CoXhController {
    @Autowired
    private MdStockDao stockDao;
    @Autowired
    private UserService userService;

    @RequestMapping("/queryStock")
    public String queryStock(){
        return "/query_stock";
    }

    @RequestMapping("/delete/{stockId}")
    public List<MdStock> getStock(@PathVariable int stockId){
        stockDao.deleteMdStockById(stockId);
        return null;
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
}
