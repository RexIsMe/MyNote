package com.example.demo.module.localmybatis.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lizhiqiang
 * @date 2021-07-26 14:46:41
 * @description 销售价格表
 */
@Table(name = "erp_sale_price")
@Data
public class ErpSalePrice {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//"行政组织id")
	private Long organizationId;
	//"销售组织id")
	private Long saleOrganizationId;
	//"客户物料id")
	private Long customerCommodityId;
	//"包装单位编号")
	private String unitCode;
	//"价格")
	private BigDecimal price;
	//"币种系统字典id")
	private Long currencyId;
	//"有效状态（系统字典值id）")
	private Integer status;
	//"")
	private Date approveTime;
	//"")
	private Long approveUser;
	//"")
	private Integer isDeleted;
	//"首营处理单ID")
	private Long initCommodityHandleId;
	//"税率")
	private Long taxRate;
	//"N5_客户ID")
	private Long n5CustomerId;
	//"N5_物料ID")
	private Long n5CommodityId;
	//"N5_币种名称")
	private String n5CurrencyName;
	//"N5_单位名称")
	private String n5UnitCodeName;
	//"停用时间")
	private Date stopTime;
	//"停用人")
	private Long stopUser;
	//"停用原因")
	private String stopRemark;
	//"有限开始日期")
	private Date enableStartTime;
	//"有限结束日期")
	private Date enableEndTime;
	//"调整人")
	private Long enableUser;
	//"调整原因")
	private String enableRemark;
	//"订单类型-字典值")
	private Long orderType;
	//"医院id")
	private Long hospitalId;
	//"调价前价格id")
	private Long sourcePriceId;
	//"是否自动刷新 1是 0否")
	private Integer autoRefresh;
	//"1：已审，0：未审")
	private Integer n5AuditStatus;
	//"销售价格编码，编码规则:CCSP+公司编码+唯一编码")
	private String salePriceCode;
	

}