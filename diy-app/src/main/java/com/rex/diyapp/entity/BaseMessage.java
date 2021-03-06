package com.rex.diyapp.entity;

import com.rex.diyapp.type.MessageType;

import java.io.Serializable;
import java.util.Map;

/**
 * 请求消息的抽象类
 *
 * @author Wanxiang Liu
 * @version 1.0.0
 */
public abstract class BaseMessage implements Serializable {

    public BaseMessage() {
        init();
    }

    /**
     * 消息类型
     */
    protected MessageType msgtype;

    public MessageType getMsgtype() {
        return msgtype;
    }

    /**
     * 初始化MmessageType方法
     */
    protected abstract void init();

    /**
     * 返回Message对象组装出来的Map对象，供后续JSON序列化
     * @return Map
     */
    public abstract Map toMessageMap();

}
