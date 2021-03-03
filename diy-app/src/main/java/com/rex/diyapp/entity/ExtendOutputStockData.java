package com.rex.diyapp.entity;

import com.rex.diyapp.annotation.Comment;
import lombok.Data;

/**
 * @Author li zhiqang
 * @create 2021/2/25
 */
@Data
public class ExtendOutputStockData extends OutPutStock {

    @Comment("数据发送服务器ip")
    private String ip;
    @Comment("数据发送时间戳")
    private String timeStamp;
    @Comment("公司名")
    private String companyName;
    @Comment("业务名")
    private String businessName;

}
