package com.example.demo.module.localmybatis.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiqiang
 * @date 2021-07-26 14:46:43
 * @description 销售价格表
 */
@Data
@EqualsAndHashCode()
public class ErpSalePricePageParam {

    private static final long serialVersionUID = 1L;



	private String commodityName;
	private String commodityNumber;
	private String commodityCode;
	private String fieldValue;
	private String customerEnableCode;
	private String registerNumber;
	private String commoditySpec;
	private Integer status;

}
