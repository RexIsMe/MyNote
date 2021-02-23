package com.rex.diyapp.util;

import com.rex.diyapp.common.Page;
import com.rex.diyapp.entity.PageListParam;

import java.io.Serializable;
import java.util.List;

/**
 * 分页相关工具类
 *
 * @Author li zhiqang
 * @create 2021/2/23
 */
public class PageUtils {
    private PageUtils() {
    }

    /**
     * 获取分页或集合
     *
     * @param list
     * @param param
     * @return
     */
    public static Serializable list(List list, PageListParam param, PageCountCalc pageCountCalc) {
        if (param != null && param.getPageNo() != null) {
            Page<?> page = new Page<>();
            if(param.getPageSize() != null){
                page.setPageSize(param.getPageSize());
            }
            page.setList(list);
            pageCountCalc.calc(page);
            return page;
        }
        return list.toArray();
    }

}
