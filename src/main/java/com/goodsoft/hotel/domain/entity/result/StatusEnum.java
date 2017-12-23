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
 * Created by manjusaka[manjusakachn@gmail.com] on 2017/7/24.
 * version v1.0
 */
public enum StatusEnum {
    SUCCESS(0, "成功"),
    SERVER_ERROR(100500, "应用服务器发生异常"),
    DATABASE_ERROR(200500, "数据库服务器发生异常"),
    DEFEAT(200500, "失败"),
    UNKONW_ERROR(100501, "未知错误"),
    ERROR(100502, "错误操作"),
    NO_DATA(200404, "很抱歉，未找到该记录数据！"),
    NO_PARAM_DATA(400404, "未获取到所需数据"),
    NO_GOODS(200404, "订单无效"),
    ORDER_TIME_OUT(100503, "由于该订单已超过反结账允许的最大时间，故不允许反结操作！"),
    NO_ORDER(200404, "生成订单失败，无法开台"),
    NO_USER(200404, "用户名与密码不匹配或已被管理员注销禁用"),
    ERROR_ORDER(200500, "生成订单失败，无法开台"),
    DEL_ORDER(200404, "订单取消失败！没有该条订单数据信息"),
    PAYZ_THE_BILL(200404, "订单结算失败！没有该订单数据信息"),
    DELETE_DEFEAT(200404, "删除失败！未获取到该条数据信息"),
    UPDATE_DEFEAT(200404, "更新失败！更新过程中未获取到需要更新的数据"),
    INSERT_DEFEAT(200404, "添加失败！保存数据无效"),
    NO_PARAM(400400, "传入参数错误或缺少参数！"),
    NO_FILE(100404, "文件不能为空"),
    FILE_FORMAT(100603, "文件格式不正确，图片格式为jpg、png、jpeg、gif、bmp，文档格式为pdf、doc、docx，表格格式为xlsx、xls"),
    FILE_SIZE(100601, "文件大小不符合要求，图片大小最大为1.5M，文档大小最大为30M,表格大小最大为10M"),
    FILE_UPLOAD(100600, "文件上传失败"),
    QT_FIND_ERROR(101100, "获取失败"),
    QT_ADD_ERROR(101101, "添加失败"),
    QT_MODIFY_ERROR(101102, "更新失败"),
    QT_REMOVE_ERROR(101103, "删除失败");


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
