package com.goodsoft.hotel.domain.entity.sys;

import java.util.Date;
import java.util.Objects;

/**
 * description:
 * ===>流水号信息表实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-09 15:57
 * @version V1.0
 */
public class SerialNum implements java.io.Serializable {
    private static final long serialVersionUID = -547001544307004750L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.id
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private String id;//流水号id

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.module_name
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private String moduleName;//流水号模板名称

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.module_code
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private String moduleCode;//流水号模板编码

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.config_templet
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private String configTemplet;//使用流水号模板

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.max_serial
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private int maxSerial;//存放当前序列号值


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.pre_max_num
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private String preMaxNum;//预生成序列号存放到缓存的个数

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.is_auto_increment
     *
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    private int isAutoIncrement;//是否自增(0为true/1为false)
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gs_sys_serial_num.sys_date
     *
     * @mbggenerated Tue Dec 05 11:43:47 CST 2017
     */
    private Date sysDate;//当天流水号生成时间
    private int serlType;//流水号类型标识（1为前台/2为餐饮/3为温泉）

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.id
     *
     * @return the value of gs_sys_serial_num.id
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.id
     *
     * @param id the value for gs_sys_serial_num.id
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.module_name
     *
     * @return the value of gs_sys_serial_num.module_name
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.module_name
     *
     * @param moduleName the value for gs_sys_serial_num.module_name
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.module_code
     *
     * @return the value of gs_sys_serial_num.module_code
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.module_code
     *
     * @param moduleCode the value for gs_sys_serial_num.module_code
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.config_templet
     *
     * @return the value of gs_sys_serial_num.config_templet
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public String getConfigTemplet() {
        return configTemplet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.config_templet
     *
     * @param configTemplet the value for gs_sys_serial_num.config_templet
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setConfigTemplet(String configTemplet) {
        this.configTemplet = configTemplet == null ? null : configTemplet.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.max_serial
     *
     * @return the value of gs_sys_serial_num.max_serial
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public int getMaxSerial() {
        return maxSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.max_serial
     *
     * @param maxSerial the value for gs_sys_serial_num.max_serial
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setMaxSerial(int maxSerial) {
        this.maxSerial = maxSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.pre_max_num
     *
     * @return the value of gs_sys_serial_num.pre_max_num
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public String getPreMaxNum() {
        return preMaxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.pre_max_num
     *
     * @param preMaxNum the value for gs_sys_serial_num.pre_max_num
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setPreMaxNum(String preMaxNum) {
        this.preMaxNum = preMaxNum == null ? null : preMaxNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.is_auto_increment
     *
     * @return the value of gs_sys_serial_num.is_auto_increment
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public int getIsAutoIncrement() {
        return isAutoIncrement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.is_auto_increment
     *
     * @param isAutoIncrement the value for gs_sys_serial_num.is_auto_increment
     * @mbggenerated Tue Dec 05 11:36:19 CST 2017
     */
    public void setIsAutoIncrement(int isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_sys_serial_num.sys_date
     *
     * @return the value of gs_sys_serial_num.sys_date
     * @mbggenerated Tue Dec 05 11:43:47 CST 2017
     */
    public Date getSysDate() {
        return sysDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_sys_serial_num.sys_date
     *
     * @param sysDate the value for gs_sys_serial_num.sys_date
     * @mbggenerated Tue Dec 05 11:43:47 CST 2017
     */
    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public int getSerlType() {
        return serlType;
    }

    public void setSerlType(int serlType) {
        this.serlType = serlType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerialNum)) return false;
        SerialNum serialNum = (SerialNum) o;
        return Objects.equals(id, serialNum.id) &&
                Objects.equals(moduleName, serialNum.moduleName) &&
                Objects.equals(moduleCode, serialNum.moduleCode) &&
                Objects.equals(configTemplet, serialNum.configTemplet) &&
                Objects.equals(preMaxNum, serialNum.preMaxNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleName, moduleCode, configTemplet, preMaxNum);
    }
}