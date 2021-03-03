package com.rex.diyapp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zhang can
 * @Long: 2019年11月21日
 */
@Data
public class CommonData extends PageListParam implements Serializable {
    private static final long serialVersionUID = -4503837261014805957L;
    /* 组织id */
    private Long organizationId;
    /* 组织名称 */
    private String organizationName;
    /* 库存组织id */
    private Long inventoryOrganizationId;
    /* 库存组织名称 */
    private String inventoryOrganizationName;
    /* 库存组织编码 */
    private String inventoryOrganizationCode;
    /* 仓库id */
    private Long warehouseId;
    /* 仓库编码 */
    private String warehouseCode;
    /* 仓库名称 */
    private String warehouseName;
    /* 客户id */
    private Long customerId;
    /* 客户名称 */
    private String customerName;

    /*客户唯一编号*/
    private String customerEnableCode;
    /* 物料id */
    private Long commodityId;
    /* 物料代码 */
    private String commodityCode;
    /* 物料货号 */
    private String commodityNumber;
    /* 分类一级 */
    private String classifyIdLevel1;
    /* 分类二级 */
    private String classifyIdLevel2;
    /* 物料名称/常用名称 */
    private String commodityName;
    /* 物料品牌 */
    private String brandName;
    /* 物料规格 */
    private String commoditySpec;
    /* 药品剂型 */
    private String commodityType;
    /* 简易征收 */
    private String isSimplelevy;
    /* 注册证名称 */
    private String registerName;
    /* 注册证编码 */
    private String registerNumber;
    /* 储存条件 */
    private String storageCondition;
    /* 冷链标识 */
    private String coldChainMark;
    /* 器械类别 */
    private String deviceClassifyType;
    /* 器械分类 */
    private String deviceClassify;
    /* 质保效期（天） */
    private Integer effectiveDays;
    /* 生产厂家名称 */
    private String manufacturerName;
    /* 生产许可 */
    private String productionLicense;
    /* 专业分组 */
    private String professionalGroup;
    /* 核算人份 */
    private String accountingOne;
    /* 核算毫升 */
    private String accountingMl;
    /* 核算名称 */
    private String accountingName;
    /* 产地属性 */
    private String productionPlace;
    /* 物料备注 */
    private String commodityRemark;
    /* 包装单位id */
    private Long packageUnitId;
    /* 包装单位名称 */
    private String packageUnitName;
    /* 转换系数 */
    private Integer quotiety;
    /* 批号 */
    private String batchNo;
    /* 有效期 */
    private Long effectiveDate;
    /* 生产日期 */
    private Long producedDate;
    /* 灭菌批号 */
    private String sterilizationBatchNo;
    /* 供应商id */
    private Long supplierId;
    /* 供应商编号 */
    private String supplierEnableCode;
    /*供应商编号*/
    private String supplierCode;
    /* 供应商名称 */
    private String supplierName;
    /* 货位id */
    private Long  goodsLocationId;
    /* 货位 */
    private String  goodsLocation;
    /* 逻辑区域Id */
    private Long logicAreaId;
    /* 逻辑区域名称 */
    private String logicAreaName;
    /*逻辑区域编号*/
    private String logicAreaCode;
    /* 库区id */
    private Long warehouseAreaId;
    /* 库区编号 */
    private String warehouseAreaCode;
    /* 库区说明 */
    private String warehouseAreaDesc;
    /* 库别id */
    private Long warehouseCategoryId;
    /* 库别编号 */
    private String warehouseCategoryCode;
    /* 库别名称 */
    private String warehouseCategoryName;
    /* 业主id */
    private Long ownerId;
    /* 业主名称 */
    private String ownerName;
    /* 业主编号 */
    private String ownerCode ;
    /*客户编号*/
    private String customerCode;
    /* 出入库标识 */
    private Long putOutType;
}
