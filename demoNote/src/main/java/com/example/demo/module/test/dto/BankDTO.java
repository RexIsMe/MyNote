package com.example.demo.module.test.dto;

import com.example.demo.entity.Bank;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:45
 * @description 银行信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BankDTO extends Bank {

	private static final long serialVersionUID = 1L;

}