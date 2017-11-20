package com.goodsoft.hotel.domain.entity.result;

import java.util.Objects;

/**
 * function 返回结果集实体
 * <p>
 * date 2017.06.19
 * author 严彬荣
 * version v1.0
 */
public class Result implements java.io.Serializable {

    private static final long serialVersionUID = -2828998968005589782L;
    // 状态码
    private int errorCode;
    // 返回数据
    private Object data;

    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Result(int errorCode, Object data) {
        super();
        this.errorCode = errorCode;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return errorCode == result.errorCode &&
                Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, data);
    }
}
