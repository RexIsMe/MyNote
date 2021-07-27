package com.example.demo.common;

/**
 * OS API返回结果状态枚举
 *
 * @author yuanchen.zhou
 * @since 2018/9/17
 */
public enum OsStatusEnum {

    SUCCESS(10000, "成功"),
    FAIL(10001, "失败"),
    UNLOGIN(10003, "请登录"),
    SYSTEM_ERROR(10002, "系统异常"),
    NOT_ALLOW(10010,"权限不足");

    OsStatusEnum(Integer status, String statusDesc) {
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
        if (status == null) {
            return statusDesc;
        }
        for (OsStatusEnum entry : OsStatusEnum.values()) {
            if (entry.getStatus().equals(status)) {
                statusDesc = entry.getStatusDesc();
                break;
            }
        }
        return statusDesc;
    }
}