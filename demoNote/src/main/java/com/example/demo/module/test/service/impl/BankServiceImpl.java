package com.example.demo.module.test.service.impl;

import com.example.demo.module.test.mapper.BankMapper;
import com.example.demo.module.test.service.BankService;
import com.example.demo.common.BaseServiceImpl;
import com.example.demo.entity.Bank;
import com.example.demo.module.test.param.BankPageParam;
import com.example.demo.utils.PageUtil;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:46
 */
@Service("bankService")
public class BankServiceImpl extends BaseServiceImpl<Bank, BankMapper> implements BankService {

	@Resource
	private BankMapper bankMapper;
	
	@Override
	protected BankMapper getMapper() { return this.bankMapper; }

	@Override
	public Serializable list(BankPageParam param) {
		return PageUtil.list(this.bankMapper.pageList(param), param, page -> page.setTotal(this.bankMapper.pageCount(param), param.getPageNo()));
	}
	
}
