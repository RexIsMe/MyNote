package com.example.demo.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    protected OsResult success() {
        return OsResult.buildSuccessResult(null);
    }

    protected OsResult success(Object content) {
        if (content instanceof List)
            return OsResult.buildSuccessResult(((List<?>) content).toArray());
        return OsResult.buildSuccessResult((Serializable) content);
    }

    protected OsResult msg(String msg) {
        return OsResult.buildBizSuccessResult(msg);
    }

}