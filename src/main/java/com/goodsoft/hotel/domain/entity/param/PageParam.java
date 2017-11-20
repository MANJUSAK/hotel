package com.goodsoft.hotel.domain.entity.param;

/**
 * description:
 * ===>分页辅助类
 *
 * @author 严彬荣 Created on 2017-11-11 17:07
 */
public class PageParam implements java.io.Serializable {

    private static final long serialVersionUID = -6999200450727024154L;
    private int page;//页码
    private int total;//每页显示记录数
    private int status;//状态参数

    public PageParam() {
        this.total = 20;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
