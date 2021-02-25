package com.rex.diyapp.service;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.vo.ExpResultCommonVO;
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

    /**
     * 根据 ID 查询StockData记录
     * @param id
     * @return
     */
    ExtendStockData selectById (String id) ;

    /**
     * 查询符合条件的StockData记录
     * @param extendStockDataParam
     * @return
     */
    Serializable selectList (ExtendStockData extendStockDataParam) ;

    /**
     * 获取批号货位库存表
     * @param extendStockDataParam
     * @return
     */
    Serializable getBatchNo (ExtendStockData extendStockDataParam) ;

    /**
     * 获取批号货位库存表的excel文件
     * @param expResultCommonVO
     * @param extendStockDataParam
     * @return
     */
    ExpResultCommonVO getBatchNoCsv (ExpResultCommonVO expResultCommonVO, ExtendStockData extendStockDataParam) ;

}
