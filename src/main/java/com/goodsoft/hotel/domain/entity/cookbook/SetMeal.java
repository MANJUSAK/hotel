package com.goodsoft.hotel.domain.entity.cookbook;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>套餐实体
 *
 * @author 严彬荣 Created on 2017-11-13 19:17
 */
public class SetMeal implements java.io.Serializable {

    private static final long serialVersionUID = 3883711168985410607L;
    private String id;//编号
    private String smName;//套餐名
    private int smid;//套餐编号
    private int isdd;//是否可单点（0为true/1为false）
    private int isNo;//是否打折（0为true/1为false）
    private double stPrice;//套餐价格
    private String smUnit;//套餐单位
    private String fileId;//文件编号
    private List<SetMealDetail> mealDetails;//套餐明细
    private List<String> picture;//套餐图片容器
    private MultipartFile[] files;//套餐文件上传


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

    public int getSmid() {
        return smid;
    }

    public void setSmid(int smid) {
        this.smid = smid;
    }

    public int getIsdd() {
        return isdd;
    }

    public void setIsdd(int isdd) {
        this.isdd = isdd;
    }

    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    public double getStPrice() {
        return stPrice;
    }

    public void setStPrice(double stPrice) {
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

    public List<SetMealDetail> getMealDetails() {
        return mealDetails;
    }

    public void setMealDetails(List<SetMealDetail> mealDetails) {
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
        if (!(o instanceof SetMeal)) return false;
        SetMeal meal = (SetMeal) o;
        return Objects.equals(id, meal.id) &&
                Objects.equals(smName, meal.smName) &&
                Objects.equals(fileId, meal.fileId) &&
                Objects.equals(smUnit, meal.smUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smName, smUnit, fileId);
    }
}
