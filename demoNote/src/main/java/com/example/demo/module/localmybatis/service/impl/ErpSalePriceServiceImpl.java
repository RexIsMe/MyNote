package com.example.demo.module.localmybatis.service.impl;

import com.example.demo.module.localmybatis.mapper.ErpSalePriceMapper;
import com.example.demo.module.localmybatis.param.ErpSalePricePageParam;
import com.example.demo.module.localmybatis.service.ErpSalePriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author lizhiqiang
 * @date 2021-07-26 14:46:43
 */
@Service("ErpSalePriceService")
public class ErpSalePriceServiceImpl implements ErpSalePriceService {
	@Resource
	private ErpSalePriceMapper erpSalePriceMapper;


	@Override
	public Integer count(ErpSalePricePageParam param) {
		return erpSalePriceMapper.count(param);
	}

	@Override
	public Integer countWithIf(ErpSalePricePageParam param) {
		return erpSalePriceMapper.countWithIf(param);
	}

}
