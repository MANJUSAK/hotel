package com.goodsoft.hotel.domain.entity.result;

import java.util.Objects;

/**
 * function 返回结果集实体
 * <p>
 * date 2017.06.19
 * author 严彬荣
 * version v1.0
 */
public class Result implements java.io.Serializable {

    private static final long serialVersionUID = -2828998968005589782L;
    // 状态码
    private int errorCode;
    private long tatol;//总条数
    private int page;//总页数
    private int pageSize;//每页记录数
    private boolean isFirstPage;//是否为第一页
    private boolean isLastPage;//是否为最后一页
    // 返回数据
    private Object data;

    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Result(int errorCode, Object data) {
        super();
        this.errorCode = errorCode;
        this.data = data;
    }

    public Result(int errorCode, int tatol, int page, int pageSize, boolean isFirstPage, boolean isLastPage, Object data) {
        this.errorCode = errorCode;
        this.tatol = tatol;
        this.page = page;
        this.pageSize = pageSize;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public long getTatol() {
        return tatol;
    }

    public void setTatol(long tatol) {
        this.tatol = tatol;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize(int pageSize) {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return errorCode == result.errorCode &&
                tatol == result.tatol &&
                page == result.page &&
                pageSize == result.pageSize &&
                isFirstPage == result.isFirstPage &&
                isLastPage == result.isLastPage &&
                Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, tatol, page, pageSize, isFirstPage, isLastPage, data);
    }
}
