package com.goodsoft.hotel.domain.entity.user;

import java.util.Objects;

/**
 * description:
 * ===>工作流人员架构组织实体
 * 用于非工作流环境下获取人员信息
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-03 10:12
 * @version V1.0
 */
public class UserDO implements java.io.Serializable {

    private static final long serialVersionUID = -8244972055210567069L;

    private String id;//用户编号
    private String deptId;//部门编号
    private String userName;//姓名
    private String loginName;//登录名
    private String sex;//姓名
    private String registerTime;//注册时间
    private String deptName;//部门名称
    private String deptLevel;//部门等级
    private String parentId;//父级部门id
    private String createDate;//部门创建时间
    private String deptCode;//部门编号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = "0".equals(sex) ? "男" : "女";
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDO)) return false;
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) &&
                Objects.equals(deptId, userDO.deptId) &&
                Objects.equals(userName, userDO.userName) &&
                Objects.equals(loginName, userDO.loginName) &&
                Objects.equals(sex, userDO.sex) &&
                Objects.equals(registerTime, userDO.registerTime) &&
                Objects.equals(deptName, userDO.deptName) &&
                Objects.equals(deptLevel, userDO.deptLevel) &&
                Objects.equals(parentId, userDO.parentId) &&
                Objects.equals(deptCode, userDO.deptCode) &&
                Objects.equals(createDate, userDO.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deptId, userName, loginName, sex, registerTime, deptCode, deptName, deptLevel, parentId, createDate);
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id='" + id + '\'' +
                ", deptId='" + deptId + '\'' +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", sex='" + sex + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptLevel='" + deptLevel + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", deptCode='" + deptCode + '\'' +
                '}';
    }
}
