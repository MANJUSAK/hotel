package com.goodsoft.hotel.domain.entity.result;

/**
 * function 系统响应状态提示枚举类
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 * version v1.0
 */
public enum StatusEnum {
    SUCCESS(0, "成功"),
    SERVER_ERROR(500, "发生不可预知的错误"),
    DEFEAT(500, "失败"),
    UNKONW_ERROR(501, "未知错误"),
    ERROR(502, "错误操作"),
    NO_DATA(404, "无数据"),
    NO_GOODS(404, "订单无效"),
    NO_ORDER(404, "生成订单失败，无法开台"),
    ERROR_ORDER(500, "生成订单失败，无法开台"),
    DEL_ORDER(404, "订单取消失败，没有该条订单数据信息"),
    PAYZ_THE_BILL(0, "订单结算失败,没有该订单数据信息"),
    DELETE_DEFEAT(404, "删除失败！未获取到该条数据信息"),
    NO_PRAM(400, "参数错误");


    private final int CODE;
    private final String EXPLAIN;

    StatusEnum(int CODE, String EXPLAIN) {
        this.CODE = CODE;
        this.EXPLAIN = EXPLAIN;
    }

    public int getCODE() {
        return CODE;
    }

    public String getEXPLAIN() {
        return EXPLAIN;
    }

}
