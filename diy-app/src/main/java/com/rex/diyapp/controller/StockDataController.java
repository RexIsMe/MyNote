package com.rex.diyapp.controller;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.UserInfo;
import com.rex.diyapp.service.StockDataService;
import com.rex.diyapp.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/19
 */
@RestController
@RequestMapping("/stockdata")
public class StockDataController {
    @Resource
    private StockDataService stockDataService ;
    @GetMapping("/selectById")
    public ExtendStockData selectById (String id) {
        return stockDataService.selectById(id) ;
    }
    @GetMapping("/selectList")
    public Serializable selectList (ExtendStockData extendStockDataParam) {
        return stockDataService.selectList(extendStockDataParam) ;
    }
}