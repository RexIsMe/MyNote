package com.rex.diyapp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存数据
 * Created by dingfeng on 2019/11/17.
 */
@Data
public class StockData extends CommonData{
    private static final long serialVersionUID = -5203567695628283595L;
    /**
     * 主键ID
     */
    private String id;
    /* 库存数量 */
    private BigDecimal inventoryNumber;
    /* 占用数量 */
    private BigDecimal allocatedQuantity;

    private String quantity;
}
