package com.rex.diyapp.service.impl;

import com.rex.diyapp.constants.ExportConstants;
import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.vo.ExpResultCommonVO;
import com.rex.diyapp.entity.vo.excel.ExpBatchNoParam;
import com.rex.diyapp.entity.vo.excel.ExpBatchNoVO;
import com.rex.diyapp.enums.ExpProcessEnum;
import com.rex.diyapp.handler.GetBatchNoHandler;
import com.rex.diyapp.mapper.StockDataMapper;
import com.rex.diyapp.service.StockDataService;
import com.rex.diyapp.util.ExcelUtils;
import com.rex.diyapp.util.ExpUtils;
import com.rex.diyapp.util.PageUtils;
import com.tyche.framework.utils.OSSUtils;
import com.tyche.framework.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Author li zhiqang
 * @create 2021/2/23
 */
@Slf4j
@Service
public class StockDataServiceImpl implements StockDataService {

    @Autowired
    private StockDataMapper stockDataMapper;
    @Autowired
    RedisUtil redisUtil;
    protected volatile List<?>[] lists;

    @Override
    public ExtendStockData selectById(String id) {
        return stockDataMapper.selectById(id);
    }

    @Override
    public Serializable selectList(ExtendStockData extendStockDataParam) {
        return PageUtils.list(stockDataMapper.selectList(extendStockDataParam), extendStockDataParam, page -> page.setTotal(stockDataMapper.selectCount(extendStockDataParam), extendStockDataParam.getPageNo()));
    }

    @Override
    public Serializable getBatchNo(ExtendStockData extendStockDataParam) {
        return PageUtils.list(stockDataMapper.getBatchNo(extendStockDataParam), extendStockDataParam, page -> page.setTotal(stockDataMapper.getBatchNoCount(extendStockDataParam), extendStockDataParam.getPageNo()));
    }

    @Override
    public ExpResultCommonVO getBatchNoCsv(ExpResultCommonVO expResultCommonVO, ExtendStockData extendStockDataParam) {
        String expRedisKey = expResultCommonVO.getExpRedisKey();
        log.info("批号货位库存列表导出 expRedisKey {}", expRedisKey);
        ExpUtils.redisValOfExpProcess(expResultCommonVO, ExpProcessEnum.LOAD_ERROR, null);
        try {
            //查询记录总条数
            Integer totalNum = stockDataMapper.getBatchNoCount(extendStockDataParam);
            //获取所有记录
            List<Callable<List<?>[]>> tasks = getTasks(extendStockDataParam, totalNum, ExportConstants.EXP_PAGE_SIZE);
            List<ExpBatchNoVO> allOrder = ExpUtils.getAllOrder(new ArrayList<ExpBatchNoVO>(), tasks, lists);

            //获取文件路径
            String filePath = ExpUtils.getFilePathOri(ExportConstants.OSS_BATCH_NO_PATH, ExportConstants.BATCH_NO_LIST_SHEET_NAME);
            if (ExcelUtils.expExcelOri(ExpBatchNoVO.class, allOrder, ExpBatchNoParam.initColumnWidth(), ExportConstants.OSS_BATCH_NO_PATH, ExportConstants.BATCH_NO_LIST_SHEET_NAME)) {
                log.info("批号货位库存列表导出 CSV 文件路径 ::: {} ", OSSUtils.getAbsolutePath(filePath));
                ExpUtils.redisValOfExpProcess(expResultCommonVO, ExpProcessEnum.LOAD_SUCCESS, filePath);
            }
        } catch (Exception e) {
            log.error("批号货位库存列表导出 csv 失败", e);
        }
        redisUtil.hset(expRedisKey, ExportConstants.EXP_STRING_DATA, expResultCommonVO);
        return expResultCommonVO;
    }

    /**
     * 生成查询“支付列表”的任务记录集合
     *
     * @param extendStockData 查询条件对象
     * @param totalNum      总记录数
     * @param expPageSize   导出记录的查询页间距
     * @return
     */
    private List<Callable<List<?>[]>> getTasks(ExtendStockData extendStockData, Integer totalNum, Integer expPageSize) {
        List tasks = new ArrayList<Callable<List<?>[]>>();
        int pollSize = PageUtils.getTotalPageNo(totalNum, expPageSize);
        this.lists = new List[pollSize];
        // pollSize 总页数  num 当前页码
        for (int num = 0; num < pollSize; num++) {
            int pageSize = (num == pollSize - 1) ? totalNum % expPageSize : expPageSize;
            tasks.add(new GetBatchNoHandler(extendStockData, num, pageSize, lists));
        }
        return tasks;
    }
}
