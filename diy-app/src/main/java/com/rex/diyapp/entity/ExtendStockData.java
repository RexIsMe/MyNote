package com.rex.diyapp.entity;

import lombok.Data;

/**
 * @Author li zhiqang
 * @create 2021/2/23
 */
@Data
public class ExtendStockData extends StockData {

    private String ip;
    private String timeStamp;
    private String companyName;
    private String businessName;

}
