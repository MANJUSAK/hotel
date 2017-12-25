package com.goodsoft.hotel.domain.entity.cookbook;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>菜单实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-11 16:43
 */
public class MenuDO implements java.io.Serializable {

    private static final long serialVersionUID = -2579296305533311577L;
    private String id;//编号
    private Integer cbid;//菜单编号
    private String tid;//关联类别表id
    private String stid;//关联小类别表id
    private String fileId = "";//关联文件表fileId
    private String cbName;//菜名
    private String tName;//部门类别（仅用于查询）
    private String stName;//小类（仅用于查询）
    private Double price1;//规格1价格
    private Double price2;//规格2价格
    private Double price3;//规格3价格
    private Double price4;//规格4价格
    private Double price5;//规格5价格
    private Integer num;//库存量
    private String unit;//单位
    private Integer isNo;//可折否（0为true/1为false）
    private String spec1 = "常规";//规格1
    private String spec2 = "中";//规格2
    private String spec3 = "大";//规格3
    private String spec4;//规格4
    private String spec5;//规格5
    private Double costPrice;//成本价格
    private Integer isSub = 0;//是否存在小类（0为true/1为false）
    private String ptPort;//打印机端口号（仅用于查询）
    private String ptDriverName;//打印机端口号（仅用于查询）
    private List<String> picture;//菜品图片文件（用于查询）
    private MultipartFile[] files;//获取上传的菜品图片（用于上传）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public Integer getCbid() {
        return cbid;
    }

    public void setCbid(Integer cbid) {
        this.cbid = cbid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? " " : tid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        if (stid == null || "".equals(stid)) {
            this.isSub = 1;
        }
        this.stid = stid == null ? " " : stid.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName == null ? " " : cbName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? " " : unit.trim();
    }

    public Integer getIsNo() {
        return isNo;
    }

    public void setIsNo(Integer isNo) {
        this.isNo = isNo;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = price1 < 0 ? Math.abs(price1) : price1;
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        this.price2 = price2 < 0 ? Math.abs(price2) : price2;
    }

    public Double getPrice3() {
        return price3;
    }

    public void setPrice3(Double price3) {
        this.price3 = price3 < 0 ? Math.abs(price3) : price3;
    }

    public Double getPrice4() {
        return price4;
    }

    public void setPrice4(Double price4) {
        this.price4 = price4 <= 0 ? 0 : price4;
    }

    public Double getPrice5() {
        return price5;
    }

    public void setPrice5(Double price5) {
        this.price5 = price5 <= 0 ? 0 : price5;
    }

    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1 == null ? " " : spec1.trim();
    }

    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2 == null ? " " : spec2.trim();
    }

    public String getSpec3() {
        return spec3;
    }

    public void setSpec3(String spec3) {
        this.spec3 = spec3 == null ? " " : spec3.trim();
    }

    public String getSpec4() {
        return spec4;
    }

    public void setSpec4(String spec4) {
        this.spec4 = spec4 == null ? " " : spec4.trim();
    }

    public String getSpec5() {
        return spec5;
    }

    public void setSpec5(String spec5) {
        this.spec5 = spec5 == null ? " " : spec5.trim();
    }

    public Integer getIsSub() {
        return isSub;
    }

    public void setIsSub(Integer isSub) {
        this.isSub = isSub;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getPtPort() {
        return ptPort;
    }

    public void setPtPort(String ptPort) {
        this.ptPort = ptPort;
    }

    public String getPtDriverName() {
        return ptDriverName;
    }

    public void setPtDriverName(String ptDriverName) {
        this.ptDriverName = ptDriverName;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuDO)) return false;
        MenuDO menuDO = (MenuDO) o;
        return Objects.equals(id, menuDO.id) &&
                Objects.equals(cbid, menuDO.cbid) &&
                Objects.equals(tid, menuDO.tid) &&
                Objects.equals(stid, menuDO.stid) &&
                Objects.equals(fileId, menuDO.fileId) &&
                Objects.equals(cbName, menuDO.cbName) &&
                Objects.equals(tName, menuDO.tName) &&
                Objects.equals(stName, menuDO.stName) &&
                Objects.equals(price1, menuDO.price1) &&
                Objects.equals(price2, menuDO.price2) &&
                Objects.equals(price3, menuDO.price3) &&
                Objects.equals(price4, menuDO.price4) &&
                Objects.equals(price5, menuDO.price5) &&
                Objects.equals(num, menuDO.num) &&
                Objects.equals(unit, menuDO.unit) &&
                Objects.equals(isNo, menuDO.isNo) &&
                Objects.equals(spec1, menuDO.spec1) &&
                Objects.equals(spec2, menuDO.spec2) &&
                Objects.equals(spec3, menuDO.spec3) &&
                Objects.equals(spec4, menuDO.spec4) &&
                Objects.equals(spec5, menuDO.spec5) &&
                Objects.equals(costPrice, menuDO.costPrice) &&
                Objects.equals(isSub, menuDO.isSub) &&
                Objects.equals(ptPort, menuDO.ptPort) &&
                Objects.equals(ptDriverName, menuDO.ptDriverName) &&
                Objects.equals(picture, menuDO.picture) &&
                Arrays.equals(files, menuDO.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbid, tid, stid, fileId, cbName, tName, stName, price1, price2, price3, price4, price5, num, unit, isNo, spec1, spec2, spec3, spec4, spec5, costPrice, isSub, ptPort, ptDriverName, picture, files);
    }

    @Override
    public String toString() {
        return "MenuDO{" +
                "id='" + id + '\'' +
                ", cbid=" + cbid +
                ", tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                ", fileId='" + fileId + '\'' +
                ", cbName='" + cbName + '\'' +
                ", tName='" + tName + '\'' +
                ", stName='" + stName + '\'' +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", price3=" + price3 +
                ", price4=" + price4 +
                ", price5=" + price5 +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", isNo=" + isNo +
                ", spec1='" + spec1 + '\'' +
                ", spec2='" + spec2 + '\'' +
                ", spec3='" + spec3 + '\'' +
                ", spec4='" + spec4 + '\'' +
                ", spec5='" + spec5 + '\'' +
                ", costPrice=" + costPrice +
                ", isSub=" + isSub +
                ", ptPort='" + ptPort + '\'' +
                ", ptDriverName='" + ptDriverName + '\'' +
                ", picture=" + picture +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
