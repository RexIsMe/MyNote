package com.example.demo.module.test.service.impl;

import com.example.demo.module.test.dto.BankDTO;
import com.example.demo.module.test.mapper.BankMapper;
import com.example.demo.module.test.service.BankService;
import com.example.demo.common.BaseServiceImpl;
import com.example.demo.entity.Bank;
import com.example.demo.module.test.param.BankPageParam;
import com.example.demo.utils.PageUtil;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:46
 */
@Service("bankService")
public class BankServiceImpl extends BaseServiceImpl<Bank, BankMapper> implements BankService {

	@Autowired
	private BankService bankService;
	@Resource
	private BankMapper bankMapper;
	
	@Override
	protected BankMapper getMapper() { return this.bankMapper; }

	@Override
//	@Transactional
	public Serializable list(BankPageParam param) {
//		bankMapper.insertOne(param);
//
//		if(param.getId() == 9527){
//			int i = 1/0;
//		}
		return list2(param, null);
//		return PageUtil.list(this.bankMapper.pageList(param), param, page -> page.setTotal(this.bankMapper.pageCount(param), param.getPageNo()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Serializable list2(BankPageParam param, String str) {
		bankMapper.insertOne(param);

		if(param.getId() == 9527){
			int i = 1/0;
		}
		return PageUtil.list(this.bankMapper.pageList(param), param, page -> page.setTotal(this.bankMapper.pageCount(param), param.getPageNo()));
	}


	
}
