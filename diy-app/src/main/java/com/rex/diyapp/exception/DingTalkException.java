package com.rex.diyapp.exception;

/**
 * 自定义报错
 *
 * @author Wanxiang Liu
 * @version 1.0.0
 */
public class DingTalkException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer errcode;

    public DingTalkException() {
        super();
    }

    public DingTalkException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return this.getMessage();
    }

}
