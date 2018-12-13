package com.security.valpro.dao;

import com.security.valpro.entity.MdStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MdStockDao extends JpaRepository<MdStock,Integer> {

    @Modifying
    @Query(value = "delete from md_stock where id=:stockId",nativeQuery = true)
    int deleteMdStockById(@Param("stockId") int id);

    @Query(value = "select * from md_stock",nativeQuery = true)
    public List<MdStock> findAll();
}
