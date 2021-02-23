package com.rex.diyapp.service;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.mapper.StockDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/23
 */
public interface StockDataService {

    // ID 查询
    ExtendStockData selectById (String id) ;
    // 查询全部
    Serializable selectList (ExtendStockData extendStockDataParam) ;

}
