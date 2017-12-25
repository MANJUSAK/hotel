package com.goodsoft.hotel.domain.entity.dto;

import java.util.Objects;

/**
 * description:
 * ===>系统参数辅助类
 * 用于前台条件查询时参入后台参数的定义
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-11 17:07
 */
public class HotelDTO implements java.io.Serializable {

    private static final long serialVersionUID = -6999200450727024154L;
    private int page;//页码
    private int total = 20;//每页显示记录数
    private int status;//状态参数
    private int setFindFile = 1;//是否查找图片（默认不查找）
    private String id;//数据编号
    private String stid;//小类编号
    private String tid;//部门类别
    private String cbid;//菜品编号
    private String mid;//做法编号
    private String keyWord;//关键字
    private String keyWord_1;//关键字1
    private String date;//当天时间
    private String startDate;//开始时间
    private String endDate;//结算时间
    private int isSub;//数据是否存在分类（0为true/1为false）


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

    public int getSetFindFile() {
        return setFindFile;
    }

    public void setSetFindFile(int setFindFile) {
        this.setFindFile = setFindFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid == null ? null : cbid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public int getIsSub() {
        return isSub;
    }

    public void setIsSub(int isSub) {
        this.isSub = isSub;
    }

    public String getKeyWord_1() {
        return keyWord_1;
    }

    public void setKeyWord_1(String keyWord_1) {
        this.keyWord_1 = keyWord_1 == null ? null : keyWord_1.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelDTO)) return false;
        HotelDTO hotelDTO = (HotelDTO) o;
        return Objects.equals(id, hotelDTO.id) &&
                Objects.equals(stid, hotelDTO.stid) &&
                Objects.equals(tid, hotelDTO.tid) &&
                Objects.equals(cbid, hotelDTO.cbid) &&
                Objects.equals(mid, hotelDTO.mid) &&
                Objects.equals(keyWord, hotelDTO.keyWord) &&
                Objects.equals(keyWord_1, hotelDTO.keyWord_1) &&
                Objects.equals(date, hotelDTO.date) &&
                Objects.equals(startDate, hotelDTO.startDate) &&
                Objects.equals(endDate, hotelDTO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stid, tid, cbid, mid, keyWord, keyWord_1, date, startDate, endDate);
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "page=" + page +
                ", total=" + total +
                ", status=" + status +
                ", setFindFile=" + setFindFile +
                ", id='" + id + '\'' +
                ", stid='" + stid + '\'' +
                ", tid='" + tid + '\'' +
                ", cbid='" + cbid + '\'' +
                ", mid='" + mid + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", keyWord_1='" + keyWord_1 + '\'' +
                ", date='" + date + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", isSub=" + isSub +
                '}';
    }
}
