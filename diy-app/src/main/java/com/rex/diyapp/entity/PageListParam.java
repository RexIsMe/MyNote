package com.rex.diyapp.entity;

import com.rex.diyapp.annotation.Comment;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * 分页查询请求参数
 **/
@Data
public class PageListParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Comment("当前页")
    @Range(min = 1,message = "pageNo必须大于0")
    protected Integer pageNo = 1;
    @Comment("页大小")
    @Range(min = 1,message = "pageSize必须大于0小于100")
    protected Integer pageSize = 10;

}
