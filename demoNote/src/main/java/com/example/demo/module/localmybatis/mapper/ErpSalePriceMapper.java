package com.example.demo.module.localmybatis.mapper;

import com.example.demo.module.localmybatis.param.ErpSalePricePageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhiqiang
 * @date 2021-07-26 14:46:42
 */
@Mapper
public interface ErpSalePriceMapper  {

	Integer count(@Param("param") ErpSalePricePageParam param);

	Integer countWithIf(@Param("param") ErpSalePricePageParam param);

}