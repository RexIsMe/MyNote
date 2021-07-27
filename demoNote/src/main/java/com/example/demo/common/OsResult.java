package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * FE通用返回结果
 *
 * @author yuanchen.zhou
 * @since 2018年05月31日
 */
@Data
public class OsResult<T> implements Serializable {

    private static final long serialVersionUID = 4093344951746076646L;

    /**
     * 返回结果标识(10000:成功 10001:失败)
     */
    private Integer status;

    /**
     * 返回结果msg
     */
    private String msg;

    /**
     * 响应内容
     */
    private T content;

    /**
     * 请求成功的返回结果
     *
     * @param content
     * @param <T>
     * @return
     */
    public static <T> OsResult<T> buildSuccessResult(T content) {
        OsResult<T> result = new OsResult<T>();
        result.setMsg(OsStatusEnum.SUCCESS.getStatusDesc());
        result.setStatus(OsStatusEnum.SUCCESS.getStatus());
        result.setContent(content);
        return result;
    }

    /**
     * 请求失败的返回结果
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> OsResult<T> buildFailResult(String msg) {
        OsResult<T> result = new OsResult<T>();
        result.setMsg(msg);
        result.setStatus(OsStatusEnum.FAIL.getStatus());
        return result;
    }

    /**
     * 请求失败的返回结果
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> OsResult<T> buildFailResult(String msg,Integer code) {
        OsResult<T> result = new OsResult<T>();
        result.setMsg(msg);
        result.setStatus(code);
        return result;
    }

    /**
     * 新增修改成功的返回结果
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> OsResult<T> buildBizSuccessResult(String msg) {
        OsResult<T> result = new OsResult<T>();
        result.setMsg(msg);
        result.setStatus(OsStatusEnum.SUCCESS.getStatus());
        return result;
    }

}
