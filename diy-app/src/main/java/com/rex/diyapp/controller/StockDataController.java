package com.rex.diyapp.controller;

import com.rex.diyapp.constants.ExportConstants;
import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.UserInfo;
import com.rex.diyapp.entity.vo.ExpResultCommonVO;
import com.rex.diyapp.service.StockDataService;
import com.rex.diyapp.service.UserInfoService;
import com.rex.diyapp.util.ExpUtils;
import com.tyche.framework.common.OsResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author li zhiqang
 * @create 2021/2/19
 */
@Slf4j
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
    @GetMapping("/getBatchNo")
    public Serializable getBatchNo(ExtendStockData extendStockDataParam) {
        return stockDataService.getBatchNo(extendStockDataParam) ;
    }
    @GetMapping("/getBatchNoCsv")
    public Serializable getBatchNoCsv(ExtendStockData extendStockDataParam) {
        try {
//            //清除分页参数
//            extendStockDataParam.setPageNo(null);
//            extendStockDataParam.setPageSize(null);
            ExpResultCommonVO expResultCommonVO = ExpUtils.initExpResult(ExportConstants.REDIS_KEY_PREFIX_OF_BATCH_NO_LIST);
            CompletableFuture.supplyAsync(() -> extendStockDataParam).thenAccept(s -> stockDataService.getBatchNoCsv(expResultCommonVO, extendStockDataParam));
            return OsResult.buildSuccessResult(expResultCommonVO);
        } catch (Exception e) {
            log.error("导出批号货位库存表失败", e);
            return OsResult.buildFailResult("导出批号货位库存表失败");
        }
    }

}