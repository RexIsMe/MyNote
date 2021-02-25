package com.rex.diyapp.enums;
/**
 * 导出订单数据下载状态枚举
 * @Auther: zhang can
 * @Date: 2019年09月29日
 */
public enum ExpProcessEnum {
    LOAD_ING(0, "导出中，请稍等..."),
    LOAD_ERROR(1, "导出失败"),
    LOAD_SUCCESS(2, "导出成功");

    ExpProcessEnum(Integer status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    /** 状态标识 */
    private Integer status;

    /** 状态描述 */
    private String statusDesc;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    /**
     * 根据状态获取描述信息
     *
     * @param status
     * @return
     */
    public static String getDescByStatus(Integer status) {
        String statusDesc = "";
        if(status == null){
            return statusDesc;
        }
        for(ExpProcessEnum entry : ExpProcessEnum.values()) {
            if(entry.getStatus().equals(status)){
                statusDesc = entry.getStatusDesc();
                break;
            }
        }
        return statusDesc;
    }
}