package com.goodsoft.hotel.domain.entity;



/**
 * Created by Administrator on 2017/11/9/009.
 */

public class Building {

    private  String id;
    private String buildingCode;
    private String buildingName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;

        if (id != null ? !id.equals(building.id) : building.id != null) return false;
        if (buildingCode != null ? !buildingCode.equals(building.buildingCode) : building.buildingCode != null)
            return false;
        return buildingName != null ? buildingName.equals(building.buildingName) : building.buildingName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        result = 31 * result + (buildingName != null ? buildingName.hashCode() : 0);
        return result;
    }
}
