package com.goodsoft.hotel.domain.entity.floor;

/**
 * Created by duyxuiang on 2017/11/17.
 * 餐台
 */
public class Diningtable {

    private String id;
    private String hallId;  //所属分厅
    private String tableName; //餐台名
    private String tableCodee; //餐台编号
    private Integer ststus ;    //餐台状态
    private String serviceCharge;            //服务费
    private String minimumConsumption ;      //最低消费

    public Diningtable() {
    }

    @Override
    public String toString() {
        return "Diningtable{" +
                "id='" + id + '\'' +
                ", hallId='" + hallId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableCodee='" + tableCodee + '\'' +
                ", ststus=" + ststus +
                ", serviceCharge='" + serviceCharge + '\'' +
                ", minimumConsumption='" + minimumConsumption + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCodee() {
        return tableCodee;
    }

    public void setTableCodee(String tableCodee) {
        this.tableCodee = tableCodee;
    }

    public Integer getStstus() {
        return ststus;
    }

    public void setStstus(Integer ststus) {
        this.ststus = ststus;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getMinimumConsumption() {
        return minimumConsumption;
    }

    public void setMinimumConsumption(String minimumConsumption) {
        this.minimumConsumption = minimumConsumption;
    }
}
