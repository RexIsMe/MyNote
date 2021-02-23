package com.rex.diyapp.entity;

import lombok.Data;

/**
 * StockData实体类
 *
 * clickhouse建表语句
 * create table stock_data( id String, ip String, time_stamp String, business_name String, company_name String, batch_no String, inventory_number String, warehouse_name String, warehouse_id String, warehouse_code String, warehouse_category_name String, warehouse_category_id String, warehouse_category_code String, warehouse_area_id String, warehouse_area_desc String, warehouse_area_code String, supplier_name String, supplier_id String, supplier_enable_code String, supplier_code String, storage_condition String, sterilization_batch_no String, register_number String, register_name String, quotiety String, quantity String, professional_group String, production_place String, production_license String, produced_date String, package_unit_name String, accounting_ml String, accounting_name String, accounting_one String, allocated_quantity String, brand_name String, classify_id_level1 String, classify_id_level2 String, cold_chain_mark String, commodity_code String, commodity_id String, commodity_name String, commodity_number String, commodity_remark String, commodity_spec String, commodity_type String, customer_code String, customer_enable_code String, customer_id String, customer_name String, device_classify String, device_classify_type String, effective_date String, effective_days String, goods_location String, goods_location_id String, inventory_organization_code String, inventory_organization_id String, inventory_organization_name String, is_simplelevy String, logic_area_code String, logic_area_id String, logic_area_name String, manufacturer_name String, organization_id String, organization_name String, owner_code String, owner_id String, owner_name String, package_unitId String )engine=MergeTree() order by (id) settings index_granularity=8192;
 *
 * @Author li zhiqang
 * @create 2021/2/23
 */
@Data
public class StockData extends PageListParam {

    private String id;
    private String accountingMl;
    private String manufacturerName;
    private String customerEnableCode;
    private Integer ownerId;
    private String warehouseCategoryCode;
    private Long organizationId;
    private Integer inventoryNumber;
    private String sterilizationBatchNo;
    private Integer effectiveDays;
    private String packageUnitName;
    private String warehouseAreaDesc;
    private String commodityCode;
    private String registerNumber;
    private Integer warehouseCategoryId;
    private String batchNo;
    private String brandName;
    private String commoditySpec;
    private String commodityNumber;
    private String organizationName;
    private String supplierEnableCode;
    private Integer logicAreaId;
    private String commodityType;
    private String productionPlace;
    private String professionalGroup;
    private String customerName;
    private Integer quotiety;
    private Integer warehouseId;
    private Integer goodsLocationId;
    private String storageCondition;
    private String inventoryOrganizationCode;
    private String productionLicense;
    private Long producedDate;
    private Integer supplierId;
    private String warehouseAreaCode;
    private String accountingName;
    private String ownerCode;
    private Integer allocatedQuantity;
    private Integer packageUnitId;
    private String customerCode;
    private Integer customerId;
    private String supplierCode;
    private String warehouseName;
    private String warehouseCode;
    private String inventoryOrganizationName;
    private String goodsLocation;
    private String ownerName;
    private String isSimplelevy;
    private String logicAreaName;
    private String supplierName;
    private Integer quantity;
    private String inventoryOrganizationId;
    private String deviceClassifyType;
    private String warehouseCategoryName;
    private Integer commodityId;
    private String commodityRemark;
    private String deviceClassify;
    private Integer warehouseAreaId;
    private String logicAreaCode;
    private String coldChainMark;
    private String accountingOne;
    private String classifyIdLevel1;
    private String classifyIdLevel2;
    private String registerName;
    private Long effectiveDate;
    private String commodityName;

}
