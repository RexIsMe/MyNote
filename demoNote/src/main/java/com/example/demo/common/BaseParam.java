package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseParam implements Serializable {

    private static final long serialVersionUID = 8995085711205450025L;

    /** 创建人id */
    private Long createUser;

    /** 创建人姓名 */
    private String createUserName;

    /** 创建时间 */
    private Date createTime;

    /** 创建时间显示 */
    private String createTimeShow;

    /** 修改人id */
    private Long updateUser;

    /** 修改人姓名 */
    private String updateUserName;

    /** 修改时间 */
    private Date updateTime;

    /** 修改时间显示 */
    private String updateTimeShow;
}