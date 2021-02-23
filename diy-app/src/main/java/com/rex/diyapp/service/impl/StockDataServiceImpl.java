package com.rex.diyapp.service.impl;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.mapper.StockDataMapper;
import com.rex.diyapp.service.StockDataService;
import com.rex.diyapp.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/23
 */
@Service
public class StockDataServiceImpl implements StockDataService {

    @Autowired
    private StockDataMapper stockDataMapper;

    @Override
    public ExtendStockData selectById(String id) {
        return stockDataMapper.selectById(id);
    }

    @Override
    public Serializable selectList(ExtendStockData extendStockDataParam) {
        return PageUtils.list(stockDataMapper.selectList(extendStockDataParam), extendStockDataParam, page -> page.setTotal(stockDataMapper.selectCount(extendStockDataParam), extendStockDataParam.getPageNo()));
    }

}
