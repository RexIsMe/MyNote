package com.example.demo.module.test.mapper;

import com.example.demo.module.test.dto.BankDTO;
import com.example.demo.common.BaseMapper;
import com.example.demo.entity.Bank;
import com.example.demo.module.test.param.BankPageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:45
 */
@Mapper
public interface BankMapper extends BaseMapper<Bank> {

	List<BankDTO> pageList(@Param("param") BankPageParam param);

	Integer pageCount(@Param("param") BankPageParam param);

	Integer insertOne(@Param("param") BankPageParam param);

}