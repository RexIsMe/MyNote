package com.example.demo.framework;

import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页参数
 * Created by zhugc on 2018/9/25-13:40.
 */
@ToString
public class Page<E> implements Serializable{

    private static final long serialVersionUID = 1L;

    public Page(){}

    public Page(int pageNo,int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 第几页
     */
    @Range(min = 1,message = "pageNo必须大于0")
    private int pageNo = 1;

    /**
     * 每页的条数
     */
    @Range(min = 1,message = "pageSize必须大于0小于100")
    private int pageSize = 10;

    /**
     * 总条数
     */
    private int total;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 是否是最后一页
     */
    private boolean isLastPage;

    private List<E> list = Collections.emptyList();

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total,int pageNo) {
        this.total = total;
        if(this.pageSize == 0){
            this.totalPages = 0 ;
        }
        this.totalPages = this.total / this.pageSize ;
        if(this.total % this.pageSize != 0){
            this.totalPages += 1 ;
        }
        if(totalPages > 0){
            this.setLastPage(pageNo == totalPages);
        }else{
            this.setLastPage(true);
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getList() {
        return this.list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isLastPage() {
        return this.isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}
