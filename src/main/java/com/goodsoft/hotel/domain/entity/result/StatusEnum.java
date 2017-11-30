package com.goodsoft.hotel.domain.entity.result;

/**
 * function 系统响应状态提示枚举类
 * description:
 * 1.0代表程序运行正常
 * 2.100xx代表应用服务器提示状态码。
 * 3.200xx代表数据库服务器提示状态码
 * 4.xx500代表程序异常
 * 5.xx404代表无数据异常
 * 6.xx400代表参数异常
 * 7.xx502代表客户端操作异常
 * 8.400xx代表前台异常
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 * version v1.0
 */
public enum StatusEnum {
    SUCCESS(0, "成功"),
    SERVER_ERROR(100500, "发生不可预知的错误"),
    DATABASE_ERROR(200500, "数据库服务器出现异常"),
    DEFEAT(200500, "失败"),
    UNKONW_ERROR(100501, "未知错误"),
    ERROR(100502, "错误操作"),
    NO_DATA(200404, "无数据"),
    NO_PARAM(400404, "未获取到数据"),
    NO_GOODS(200404, "订单无效"),
    NO_ORDER(200404, "生成订单失败，无法开台"),
    ERROR_ORDER(200500, "生成订单失败，无法开台"),
    DEL_ORDER(200404, "订单取消失败！没有该条订单数据信息"),
    PAYZ_THE_BILL(200404, "订单结算失败！没有该订单数据信息"),
    DELETE_DEFEAT(200404, "删除失败！未获取到该条数据信息"),
    UPDATE_DEFEAT(200404, "更新失败！更新过程中未获取到需要更新的数据"),
    NO_PRAM(400400, "参数错误"),
    NO_FILE(100404, "文件不能为空"),
    FILE_FORMAT(100603, "文件格式不正确"),
    FILE_SIZE(100601, "文件大小不符合要求"),
    FILE_UPLOAD(100600, "文件上传失败");


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
