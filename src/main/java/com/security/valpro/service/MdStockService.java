package com.security.valpro.service;

import com.security.valpro.ApiTest;
import com.security.valpro.dao.MdStockDao;
import com.security.valpro.entity.MdStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ApiTest.class)
@Service
@Transactional
public class MdStockService implements ApiTest {
    @Autowired
    private MdStockDao stockDao;

    public int deleteById(int stockId){
        return stockDao.deleteMdStockById(stockId);
    }

    public List<MdStock> findAll(){
        return stockDao.findAll();
    }

    @Override
    public String speakHello() {
        return "Hello World!";
    }
}
