package com.security.valpro.service;

import com.security.valpro.dao.MdStockDao;
import com.security.valpro.entity.MdStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MdStockService {
    @Autowired
    private MdStockDao stockDao;

    public  void deleteById(int stockId){
        stockDao.deleteMdStockById(stockId);
    }

    public List<MdStock> findAll(){
        return stockDao.findAll();
    }
}
