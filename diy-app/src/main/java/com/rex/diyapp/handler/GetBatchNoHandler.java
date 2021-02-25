package com.rex.diyapp.handler;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.vo.excel.ExpBatchNoVO;
import com.rex.diyapp.mapper.StockDataMapper;
import com.rex.diyapp.util.SpringContextUtils;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * 批号货位库存列表分页查询Callable实现类
 *
 * @author lizhiqiang
 * @since 2020/7/6
 */
public class GetBatchNoHandler implements Callable<List<?>[]> {

    private ExtendStockData extendStockData;
    private int pageNo;  // 当前页码
    private int pageSize;  // 每页条数
    protected volatile List<?>[] list;

    public GetBatchNoHandler(ExtendStockData extendStockData, int pageNo, int pageSize, List<?>[] list) {
        this.extendStockData = extendStockData;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
    }

    @Override
    public List<?>[] call() throws Exception {
        try{
            extendStockData.setPageNo(pageNo + 1);
            extendStockData.setPageSize(pageSize);
            StockDataMapper stockDataMapper = (StockDataMapper) SpringContextUtils.getBean("stockDataMapper");
            List<ExpBatchNoVO> batchNo = stockDataMapper.getBatchNo(extendStockData);
            addList(batchNo, pageNo);
            return this.list;
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    private void addList(List<?> result, int pageNo) {
        System.out.println("进来。。。");
        this.list[pageNo] = result;
        System.out.println(list);
    }

}
