package com.example.demo.module.test.service;

import com.example.demo.common.BaseService;
import com.example.demo.entity.Bank;
import com.example.demo.module.test.param.BankPageParam;

import java.io.Serializable;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:46
 */
public interface BankService extends BaseService<Bank> {

	Serializable list(BankPageParam param);

}
