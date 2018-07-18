package com.yilin.app.common;

import java.io.Serializable;
import java.util.List;



public class Page implements Serializable {

    private static final long serialVersionUID = -1517114146113942561L;

    /** 每页记录数 */
    private int pageSize;
    /** 页号 */
    private int pageIndex;
    /** 总页数 */
    private int pageCount;
    /** 记录数 */
    private int recordCount;
    /** 数据对象 */
    @SuppressWarnings("rawtypes")
    private List item;

    /**
     * 无参数构造器
     */
    public Page() {

    }

    /**
     * 构造器
     *
     * @param pageSize
     *            每页记录数
     * @param pageIndex
     *            页号
     * @param item
     *            数据对象
     */
    public Page(int pageSize, int pageIndex, int recordCount, @SuppressWarnings("rawtypes") List item) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.recordCount = recordCount;
        this.item = item;
        if (recordCount > 0) {
            this.pageCount = recordCount/pageSize;
            if (recordCount%pageSize != 0) {
                this.pageCount++;
            }
        } else {
            this.pageCount = 0;
        }
    }

    /**
     * 获取每页记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取页号
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置页号
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 获取总页数
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * 设置总页数
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取数据对象
     */
    @SuppressWarnings("rawtypes")
    public List getItem() {
        return item;
    }

    /**
     * 设置数据对象
     */
    public void setItem(@SuppressWarnings("rawtypes") List item) {
        this.item = item;
    }

    /**
     * 设置记录数
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * 设置记录数
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

}