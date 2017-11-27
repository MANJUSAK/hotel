package com.goodsoft.hotel.domain.entity.restaurantReservation;


/**
 * Created by duyuxiang on 2017/11/12.
 * 餐饮散客预订单
 */

public class FitReservation {


    private String id;
    private String customer_type; //顾客类型 .
    private String entry_date;      //入单时间.
    private String customer_name; //顾客姓名.
    private Integer people_number; //人数.
    private String appointment_length; //预约时长.
    private String member_card;    //会员卡号.
    private String contract_unit;  //合约单位.
    private String standard_meal;  //餐标.
    private String corporate_name; //公司名称.
    private Integer seats_num;      //席数.
    private String contacts;      //联系人.
    private String contact_number; //联系电话.
    private String sales_manager;  //营业经理.
    private String remarks;        //备注.
    private String atthe_time;        //入席时间.
    private String end_date;          //结束日期.
    private String record_operator; //记录操作人.
    private String recording_time;    //记录时间.
    private String final_amendment; //最后修改人.
    private String last_modified_time; //最后修改时间.
    private String cancellation_reason; //取消原因
    private String state;               //状态
    private Integer reserveType;   //预订类型

    public Integer getReserveType() {
        return reserveType;
    }

    public void setReserveType(Integer reserveType) {
        this.reserveType = reserveType;
    }

    public String getCancellation_reason() {
        return cancellation_reason;
    }

    public void setCancellation_reason(String cancellation_reason) {
        this.cancellation_reason = cancellation_reason;
    }

    public FitReservation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getPeople_number() {
        return people_number;
    }

    public void setPeople_number(Integer people_number) {
        this.people_number = people_number;
    }

    public String getAppointment_length() {
        return appointment_length;
    }

    public void setAppointment_length(String appointment_length) {
        this.appointment_length = appointment_length;
    }

    public String getMember_card() {
        return member_card;
    }

    public void setMember_card(String member_card) {
        this.member_card = member_card;
    }

    public String getContract_unit() {
        return contract_unit;
    }

    public void setContract_unit(String contract_unit) {
        this.contract_unit = contract_unit;
    }

    public String getStandard_meal() {
        return standard_meal;
    }

    public void setStandard_meal(String standard_meal) {
        this.standard_meal = standard_meal;
    }

    public String getCorporate_name() {
        return corporate_name;
    }

    public void setCorporate_name(String corporate_name) {
        this.corporate_name = corporate_name;
    }

    public Integer getSeats_num() {
        return seats_num;
    }

    public void setSeats_num(Integer seats_num) {
        this.seats_num = seats_num;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getSales_manager() {
        return sales_manager;
    }

    public void setSales_manager(String sales_manager) {
        this.sales_manager = sales_manager;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAtthe_time() {
        return atthe_time;
    }

    public void setAtthe_time(String atthe_time) {
        this.atthe_time = atthe_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRecord_operator() {
        return record_operator;
    }

    public void setRecord_operator(String record_operator) {
        this.record_operator = record_operator;
    }

    public String getRecording_time() {
        return recording_time;
    }

    public void setRecording_time(String recording_time) {
        this.recording_time = recording_time;
    }

    public String getFinal_amendment() {
        return final_amendment;
    }

    public void setFinal_amendment(String final_amendment) {
        this.final_amendment = final_amendment;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FitReservation{" +
                "id='" + id + '\'' +
                ", customer_type='" + customer_type + '\'' +
                ", entry_date='" + entry_date + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", people_number=" + people_number +
                ", appointment_length='" + appointment_length + '\'' +
                ", member_card='" + member_card + '\'' +
                ", contract_unit='" + contract_unit + '\'' +
                ", standard_meal='" + standard_meal + '\'' +
                ", corporate_name='" + corporate_name + '\'' +
                ", seats_num=" + seats_num +
                ", contacts='" + contacts + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", sales_manager='" + sales_manager + '\'' +
                ", remarks='" + remarks + '\'' +
                ", atthe_time='" + atthe_time + '\'' +
                ", end_date='" + end_date + '\'' +
                ", record_operator='" + record_operator + '\'' +
                ", recording_time='" + recording_time + '\'' +
                ", final_amendment='" + final_amendment + '\'' +
                ", last_modified_time='" + last_modified_time + '\'' +
                ", cancellation_reason='" + cancellation_reason + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
