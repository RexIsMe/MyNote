package com.rex.diyapp.mapper;

import com.rex.diyapp.entity.ExtendStockData;
import com.rex.diyapp.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author li zhiqang
 * @create 2021/2/19
 */
@Mapper
public interface StockDataMapper {
    // ID 查询
    ExtendStockData selectById(@Param("id") String id) ;

    /**
     * 根据条件查询结果列表
     * @param extendStockDataParam
     * @return
     */
    List<ExtendStockData> selectList(ExtendStockData extendStockDataParam) ;

    /**
     * 根据条件查询符合条件个数
     * @param extendStockDataParam
     * @return
     */
    Integer selectCount(ExtendStockData extendStockDataParam) ;
}
