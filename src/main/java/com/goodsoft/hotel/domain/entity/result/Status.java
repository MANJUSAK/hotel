package com.goodsoft.hotel.domain.entity.result;

import java.util.Objects;

/**
 * function 状态信息提示返回结果集实体
 * <p>
 * date 2017.06.19
 * author 严彬荣
 * version v1.0
 */
public class Status implements java.io.Serializable {
    private static final long serialVersionUID = 8179717412450576971L;
    //状态码
    private int errorCode;
    //描述
    private String msg;

    public Status(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status = (Status) o;
        return errorCode == status.errorCode &&
                Objects.equals(msg, status.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, msg);
    }
}
