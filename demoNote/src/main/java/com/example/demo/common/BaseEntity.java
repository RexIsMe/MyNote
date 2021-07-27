package com.example.demo.common;

import com.example.demo.annotation.Comment;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Comment("创建时间")
    private Date createTime;
    @Comment("创建人")
    private Long createUser;
    @Comment("更新时间")
    private Date updateTime;
    @Comment("更新人")
    private Long updateUser;

}
