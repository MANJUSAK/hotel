package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 建筑信息表
 * Created by 王智 on 2017/11/12/012.
 */
public class Building {
    private String id;                  //ID
    private int buildId;                    //建筑ID
    private String buildingCode;                    //建筑编号
    private String buildingName;                              //建筑名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id='" + id + '\'' +
                ", buildId=" + buildId +
                ", buildingCode='" + buildingCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }
}
