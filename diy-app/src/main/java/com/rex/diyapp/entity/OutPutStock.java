package com.rex.diyapp.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 出入库流水
 *
 * clickhouse建表语句
 * create table output_stock_data( id String, ip String, time_stamp String, business_name String, company_name String, batch_no String, inventory_number String, warehouse_name String, warehouse_id String, warehouse_code String, warehouse_category_name String, warehouse_category_id String, warehouse_category_code String, warehouse_area_id String, warehouse_area_desc String, warehouse_area_code String, supplier_name String, supplier_id String, supplier_enable_code String, supplier_code String, storage_condition String, sterilization_batch_no String, register_number String, register_name String, quotiety String, quantity String, professional_group String, production_place String, production_license String, produced_date String, package_unit_name String, accounting_ml String, accounting_name String, accounting_one String, allocated_quantity String, brand_name String, classify_id_level1 String, classify_id_level2 String, cold_chain_mark String, commodity_code String, commodity_id String, commodity_name String, commodity_number String, commodity_remark String, commodity_spec String, commodity_type String, customer_code String, customer_enable_code String, customer_id String, customer_name String, device_classify String, device_classify_type String, effective_date String, effective_days String, goods_location String, goods_location_id String, inventory_organization_code String, inventory_organization_id String, inventory_organization_name String, is_simplelevy String, logic_area_code String, logic_area_id String, logic_area_name String, manufacturer_name String, organization_id String, organization_name String, owner_code String, owner_id String, owner_name String, package_unitId String, order_item_no String, win_bid_code String, invoice_unit_name String, invoice_name String, customer_commodity_remark String, sale_price String, currency String, tax String, taxed_price Float64, create_user String, create_time Int64, update_user String, update_time Int64, receiving_user_id Int64, receiving_user String, receiving_date Int64, acceptance_user_id Int64, acceptance_user String, acceptance_date Int64, recheck_user_id Int64, recheck_user String, recheck_date Int64, put_away_id Int64, put_away_user String, put_away_date Int64, order_type_id Int64, order_type_name String, receive_number Float64, purchase_number Float64, commodity_date Int64, purchase_order_item_no String, purchase_people String, order_no String, recheck_quantity Float64 )engine=MergeTree() order by (id) settings index_granularity=8192;
 *
 * Created by dingfeng on 2019/11/19.
 */
@Data
public class OutPutStock extends StockData {
    private static final long serialVersionUID = -5475555790852363517L;
    /* 出入库明细号 */
    private String orderItemNo;
    /* 中标编码 */
    private String winBidCode;
    /* 开票单位 */
    private String invoiceUnitName;
    /* 开票名称 */
    private String invoiceName;
    /* 客户物料备注 */
    private String customerCommodityRemark;
    /* 单价 */
    private BigDecimal salePrice;
    /* 币种 */
    private String currency;
    /* 税率 */
    private String tax;
    /* 数量 */
    private String quantity;
    /* 价税合计 */
    private BigDecimal taxedPrice;
    /* 创建人 */
    private String createUser;
    /* 创建时间 */
    private Long createTime;
    /* 更新人 */
    private String updateUser;
    /* 更新时间 */
    private Long updateTime;
    /* 收货员id */
    private Long receivingUserId;
    /* 收货员名称 */
    private String receivingUser;
    /* 收货时间 */
    private Long receivingDate;
    /* 验收员id */
    private Long acceptanceUserId;
    /* 验收员名称 */
    private String acceptanceUser;
    /* 验收时间 */
    private Long acceptanceDate;
    /* 复检员id */
    private Long recheckUserId;
    /* 复检员名称 */
    private String recheckUser;
    /* 复检时间 */
    private Long recheckDate;
    /* 上架员id */
    private Long putawayId;
    /* 上架员名称 */
    private String putawayUser;
    /* 上架时间 */
    private Long putawayDate;
    /* 出入库类型id */
    private Long orderTypeId;
    /* 出入类型名称 */
    private String orderTypeName;
    /* 收货数量 */
    private BigDecimal receiveNumber;
    /* 验收数量 */
    private BigDecimal purchaseNumber;
    /* 物料效期 */
    private Long commodityDate;
    /* 采购订单号 */
    private String purchaseOrderItemNo;
    /* 采购人员 */
    private String purchasePeople;
    /* 出库单号 */
    private String orderNo;
    /* 复核数量 */
    private BigDecimal recheckQuantity;

}
