package com.goodsoft.hotel.domain.entity.sys;

import java.util.Objects;

/**
 * description:
 * ===>系统打印机信息表实体
 *
 * @author manjusaka Created on 2017-12-09 15:57
 * @version 通过该表实现系统所有打印机的管理，方便客户端调用特定的打印机。
 */
public class Printer implements java.io.Serializable {

    private static final long serialVersionUID = -3161846995482266438L;
    private String id;//数据id
    private String ptName;//打印机名称
    private String ptPort;//打印机端口
    private String ptType;//打印机类型
    private String ptDept;//打印机所属部门

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getPtPort() {
        return ptPort;
    }

    public void setPtPort(String ptPort) {
        this.ptPort = ptPort;
    }

    public String getPtType() {
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getPtDept() {
        return ptDept;
    }

    public void setPtDept(String ptDept) {
        this.ptDept = ptDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Printer)) return false;
        Printer printer = (Printer) o;
        return Objects.equals(id, printer.id) &&
                Objects.equals(ptName, printer.ptName) &&
                Objects.equals(ptPort, printer.ptPort) &&
                Objects.equals(ptType, printer.ptType) &&
                Objects.equals(ptDept, printer.ptDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ptName, ptPort, ptType, ptDept);
    }
}
