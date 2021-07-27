package com.example.demo.module.localmybatis.service;

import com.example.demo.module.localmybatis.param.ErpSalePricePageParam;

import java.io.Serializable;

/**
 * @author lizhiqiang
 * @date 2021-07-26 14:46:43
 */
public interface ErpSalePriceService {


	Integer count(ErpSalePricePageParam param);

	Integer countWithIf(ErpSalePricePageParam param);
}
