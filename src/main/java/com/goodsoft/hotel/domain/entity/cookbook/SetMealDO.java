package com.goodsoft.hotel.domain.entity.cookbook;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>套餐实体
 *
 * @author 严彬荣 Created on 2017-11-13 19:17
 */
public class SetMealDO implements java.io.Serializable {

    private static final long serialVersionUID = 3883711168985410607L;
    private String id;//编号
    private String smName;//套餐名
    private Integer smid;//套餐编号
    private Double tcDiscount;//明细菜品价格总计套餐折扣席数比
    private Integer isdd;//是否可单点（0为true/1为false）
    private Integer isNo;//是否打折（0为true/1为false）
    private Double stPrice;//套餐价格
    private String smUnit;//套餐单位
    private String fileId;//文件编号
    private List<SetMealDetailDO> mealDetails;//套餐明细
    private List<String> picture;//套餐图片容器
    private MultipartFile[] files;//套餐文件上传

    public SetMealDO() {
        this.fileId = " ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName == null ? " " : smName.trim();
    }

    public Integer getSmid() {
        return smid;
    }

    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    public Double getTcDiscount() {
        return tcDiscount;
    }

    public void setTcDiscount(Double tcDiscount) {
        this.tcDiscount = tcDiscount;
    }

    public Integer getIsdd() {
        return isdd;
    }

    public void setIsdd(Integer isdd) {
        this.isdd = isdd;
    }

    public Integer getIsNo() {
        return isNo;
    }

    public void setIsNo(Integer isNo) {
        this.isNo = isNo;
    }

    public Double getStPrice() {
        return stPrice;
    }

    public void setStPrice(Double stPrice) {
        this.stPrice = stPrice < 0 ? Math.abs(stPrice) : stPrice;
    }

    public String getSmUnit() {
        return smUnit;
    }

    public void setSmUnit(String smUnit) {
        this.smUnit = smUnit == null ? " " : smUnit.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<SetMealDetailDO> getMealDetails() {
        return mealDetails;
    }

    public void setMealDetails(List<SetMealDetailDO> mealDetails) {
        this.mealDetails = mealDetails;
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
        if (!(o instanceof SetMealDO)) return false;
        SetMealDO setMealDO = (SetMealDO) o;
        return Objects.equals(id, setMealDO.id) &&
                Objects.equals(smName, setMealDO.smName) &&
                Objects.equals(smid, setMealDO.smid) &&
                Objects.equals(tcDiscount, setMealDO.tcDiscount) &&
                Objects.equals(isdd, setMealDO.isdd) &&
                Objects.equals(isNo, setMealDO.isNo) &&
                Objects.equals(stPrice, setMealDO.stPrice) &&
                Objects.equals(smUnit, setMealDO.smUnit) &&
                Objects.equals(fileId, setMealDO.fileId) &&
                Objects.equals(mealDetails, setMealDO.mealDetails) &&
                Objects.equals(picture, setMealDO.picture) &&
                Arrays.equals(files, setMealDO.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smName, smid, tcDiscount, isdd, isNo, stPrice, smUnit, fileId, mealDetails, picture, files);
    }

    @Override
    public String toString() {
        return "SetMealDO{" +
                "id='" + id + '\'' +
                ", smName='" + smName + '\'' +
                ", smid=" + smid +
                ", tcDiscount=" + tcDiscount +
                ", isdd=" + isdd +
                ", isNo=" + isNo +
                ", stPrice=" + stPrice +
                ", smUnit='" + smUnit + '\'' +
                ", fileId='" + fileId + '\'' +
                ", mealDetails=" + mealDetails +
                ", picture=" + picture +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
