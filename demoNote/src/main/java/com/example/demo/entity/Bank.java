package com.example.demo.entity;

import javax.persistence.Table;
import com.example.demo.common.BaseEntity;
import com.example.demo.annotation.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:44
 * @description 银行信息
 */
@Table(name = "erp_bank")
@Data
@EqualsAndHashCode(callSuper = true)
public class Bank extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("")
	private Long id;
	@Comment("组织ID")
	private Long organizationId;
	@Comment("银行名称")
	private String bankName;
	@Comment("银行行号")
	private String bankCode;
	@Comment("银行类型")
	private String bankType;
	@Comment("删除状态(系统字典值ID)")
	private Integer isDeleted;
	@Comment("有效状态(系统字典值ID)")
	private Integer status;
	

}