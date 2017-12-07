package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by duyuxiang on 2017/12/7.
 * 客房消费项目
 */
public class KfconsumerProjects {

    private String  id;
    private String  code;        //编号
    private String  projectname; //项目名
    private String  money;       //金额
    private String  description; //描述
    private String  department;  //所属部门


    public KfconsumerProjects() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "KfconsumerProjects{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", projectname='" + projectname + '\'' +
                ", money='" + money + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
