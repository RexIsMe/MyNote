package com.example.demo.module.test.param;

import com.example.demo.common.PageListParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.demo.annotation.Comment;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:46
 * @description 银行信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BankPageParam extends PageListParam {

    private static final long serialVersionUID = 1L;

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
