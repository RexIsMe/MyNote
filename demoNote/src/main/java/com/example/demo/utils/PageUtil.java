package com.example.demo.utils;

import com.example.demo.common.PageListParam;
import com.example.demo.framework.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author liaoyifan
 */
public class PageUtil {

    private PageUtil() {

    }

    /**
     * 获取分页或集合
     *
     * @param list
     * @param param
     * @return
     */
    public static Serializable list(List list, PageListParam param, PageCountCallBack callBack) {
        if (param != null && param.getPageNo() != null) {
            Page<?> page = new Page<>();
            if(param.getPageSize() != null){
                page.setPageSize(param.getPageSize());
            }
            page.setList(list);
            callBack.run(page);
            return page;
        }
        return list.toArray();
    }

}
