package com.goodsoft.hotel.domain.entity.restaurantReservation;

/**
 * Created by Administrator on 2017/11/15.
 * 预订餐台
 */
public class ReservationHalls {

    private String id;
    private String reserve_hall;    //分厅
    private String reserve_table;   //餐台
    private String reserve_start_time; //入席时间
    private String  reserve_end_time;   //结束时间
    private String  shibie ;            //市别
    private String reserve_hall_status;  //状态
    private String reserve_id;           //预订单id
    private String table_id;             //餐台id

    public String getTable_id() {
        return table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public ReservationHalls() {
    }

    @Override
    public String toString() {
        return "ReservationHalls{" +
                "id='" + id + '\'' +
                ", reserve_hall='" + reserve_hall + '\'' +
                ", reserve_table='" + reserve_table + '\'' +
                ", reserve_start_time='" + reserve_start_time + '\'' +
                ", reserve_end_time='" + reserve_end_time + '\'' +
                ", shibie='" + shibie + '\'' +
                ", reserve_hall_status='" + reserve_hall_status + '\'' +
                ", reserve_id='" + reserve_id + '\'' +
                ", table_id='" + table_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReserve_hall() {
        return reserve_hall;
    }

    public void setReserve_hall(String reserve_hall) {
        this.reserve_hall = reserve_hall;
    }

    public String getReserve_table() {
        return reserve_table;
    }

    public void setReserve_table(String reserve_table) {
        this.reserve_table = reserve_table;
    }

    public String getReserve_start_time() {
        return reserve_start_time;
    }

    public void setReserve_start_time(String reserve_start_time) {
        this.reserve_start_time = reserve_start_time;
    }

    public String getReserve_end_time() {
        return reserve_end_time;
    }

    public void setReserve_end_time(String reserve_end_time) {
        this.reserve_end_time = reserve_end_time;
    }

    public String getShibie() {
        return shibie;
    }

    public void setShibie(String shibie) {
        this.shibie = shibie;
    }

    public String getReserve_hall_status() {
        return reserve_hall_status;
    }

    public void setReserve_hall_status(String reserve_hall_status) {
        this.reserve_hall_status = reserve_hall_status;
    }

    public String getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(String reserve_id) {
        this.reserve_id = reserve_id;
    }
}
