package com.rex.diyapp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 待处理库存数据
 */
@Data
public class WaitStock implements Serializable {

    private static final long serialVersionUID = 1L;

    private StockData stockData;

    private String unitCode;

}
