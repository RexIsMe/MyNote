package com.rex.diyapp.entity.vo;

import com.rex.diyapp.enums.ExpProcessEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询导出结果集
 *
 * @Auther: lizhiqiang
 * @Date: 2020年07月02日
 */
@Data
public class ExpResultCommonVO implements Serializable {
    private static final long serialVersionUID = -5741026L;
    /** 系统生成的redis Key */
    private String expRedisKey;
    /** 导出状态 ${@link ExpProcessEnum}*/
    private Integer expStatus;
    /** 导出提示语*/
    private String expMsg;
    /** 导出文件路径*/
    private String filePath;

    public ExpResultCommonVO(){}

    public ExpResultCommonVO(String expRedisKey, String expMsg){
        this.expRedisKey = expRedisKey;
        this.expMsg = expMsg;
    }
}
