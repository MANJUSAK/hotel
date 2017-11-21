<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/15
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path=request.getContextPath();
String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>


<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>预订</title>

    <link rel="stylesheet" href="<%=basePath%>/views/bootstrap-3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/views/bootstrap-3.1.1/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="<%=basePath%>/views/jquery-1.9.0.js"></script>
    <script src="<%=basePath%>/views/bootstrap-3.1.1/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/views/bootstrap-3.1.1/js/bootstrap-datetimepicker.min.js"></script>
    <script src="<%=basePath%>/views/bootstrap-3.1.1/js/language/bootstrap-datetimepicker.zh-CN.js"></script>

    <style>
        ul,
        li {
            list-style: none;
        }

        .clearfloat:after {
            display: block;
            clear: both;
            content: "";
            visibility: hidden;
            height: 0;
        }
        th {
            text-align: center;
            color: #929292;
        }

        td {
            color: #929292;
            text-align: center;
        }

        .trber:hover {
            background: #edddf9;
        }
        .trber{
            cursor: pointer;
        }

        tr {
            border-bottom: solid #d4d2d1 1px;
            border-top: solid #d4d2d1 1px;
            height: 40px;
        }

        .lead {
            width: 15px;
            height: 15px;
        }

        .leadsuns {
            width: 15px;
            height: 15px;
        }

        .butt {
            padding-top: 45px;
            padding-right: 20px;
        }

        .butt button {
            float: right;
            margin-right: 12px;
        }

        .mak span {
            font-size: 15px;
            margin-left: 10px;
            margin-right: 2px;
            display: inline-block;
            width: 100px;
            word-wrap:break-word;
        }
        .mak input {
            width: 172px;
        }
        .mak .input {
            width: 460px;
        }
        .mak select {
            width: 172px;
            padding-left: 30px;
            text-align: center;
        }
        .mak .linediv {
            height: 10px;
        }

        .sixpx {
            width: 70px;
        }
        .navul{
            margin-bottom: 0px;
            padding: 0px;
        }
        .navul li{
            float: left;
            padding: 5px 30px;
            border-right: 1px solid #CCCCCC;
        }
        .navul .selectydType{
            float: left;
            color: #FFFFFF;
            background: #1BD7BF;
        }
        .fentingtable td select{
            padding-left: 15px;
            width: 100px;
            height: 28px;
        }
        .fentingtable td input{
            width: 190px;
            height: 28px;
        }
    </style>
</head>

<body>

<div style="width: 100%;height: 800px;min-width: 600px;">

    <div class="butt" style="width: 100%;height: 100px;">
        <div style="float:left;margin-left: 50px;"> <input class="selectRadio" style="float: left" name="dateRadio" <c:if test="${empty staetTime}">checked="checked"</c:if>  type="radio" value="1" /> <span>当天</span></div>
        <div style="float:left;">  <input class="selectRadio" style="float: left" name="dateRadio" <c:if test="${not empty staetTime}">checked="checked"</c:if> type="radio" value="0" /><span>全部</span></div>
        <div class="input-group"style="width: 400px;float: right;">
            <input type="text" class="form-control">
            <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
        </div>
        <button name="update" type="button" class="jnog btn btn-info">修改</button>
        <button name="delete" type="button" class="jnog btn btn-info">取消</button>
        <button name="add" type="button" class="jnog btn btn-info">新增</button>

    </div>

    <div>
        <table width="95%" cellpadding="2" cellspacing="1" align="center">
            <tr>
                <th><input type="checkbox" class="lead"></th>
                <th>类型</th>
                <th>客人姓名</th>
                <th>人数</th>
                <th>营业经理</th>
                <th>入席时间</th>
                <th>状态</th>
            </tr>

            <c:forEach items="${pageBean.content}" var="list">
            <tr class="trber" >
                <td><input type="checkbox"  class="leadsuns"></td>
                <input class="reserveId" type="hidden" value="${list.id}"/>
                <td>${list.customer_type}</td>
                <td>${list.customer_name}</td>
                <td>${list.sales_manager}</td>
                <td>${list.people_number}</td>
                <td>${list.atthe_time}</td>
                <td><c:choose><c:when test="${list.state==1}">未到</c:when><c:when test="${list.state==2}">取消</c:when>
                    <c:when test="${list.state==3}">已到</c:when><c:when test="${list.state==4}">过时未到</c:when>
                </c:choose></td>
            </tr>
        </c:forEach>

        </table>



        <%--每页显示条数--%>
        <div style="float: left;margin-left: 40px;margin-top: 42px;font-size: 17px">
            每页显示:<select class="pageSizeOption">
            <option <c:if test="${pageBean.pageSize==5}">selected="selected"</c:if> value="5">5</option>
            <option <c:if test="${pageBean.pageSize==10}">selected="selected"</c:if> value="10">10</option>
            <option <c:if test="${pageBean.pageSize==15}">selected="selected"</c:if> value="15">15</option>
            <option <c:if test="${pageBean.pageSize==20}">selected="selected"</c:if> value="20">20</option>
        </select>
            <script>
                $(".pageSizeOption").on("change",function () {
                   window.location.href="<%=basePath%>/reserve?currentPage=1&pageSize="+$(this).val()+"<c:if test="${not empty staetTime}">&staetTime=1</c:if>";
                });
            </script>
        </div>

        <!--分页-->
        <div style="float: right;margin-right: 25px;margin-top: 15px">
            <ul class="pagination">

                <script>
                    $(".pagination").append('<li> <a href="<%=basePath%>/reserve?currentPage=${pageBean.previousPage}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if>">上一页</a> </li>');
                    for(var i=1;i<=${pageBean.pageTotal};i++){
                        if(i==${pageBean.currentPage}){
                            $(".pagination").append('<li class="active"><a href="<%=basePath%>/reserve?currentPage='+i+'&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if>">'+i+'</a> </li>');
                        }else {
                            $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage=' + i + '&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if>">' + i + '</a> </li>');
                        }
                    }
                    $(".pagination").append('<li> <a href="<%=basePath%>/reserve?currentPage=${pageBean.nextPage}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if>">下一页</a> </li>');
                </script>


            </ul>
        </div>
    </div>

    <!--弹出框-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width: 900px; ">
            <div class="modal-content" style="overflow: hidden;">
                <div class="modal-header"style="padding: 0px;border-bottom: 2px solid #1BD7BF;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="margin-right: 20px;padding-top: 10px;outline:none;">&times;</button>
                    <ul class="navul clearfloat">
                        <li class="selectydType"><h4>散客</h4></li>
                        <li><h4>酒席</h4></li>
                        <li><h4>宴会</h4></li>
                    </ul>
                </div>
                <div style="width: 900px ;height: 600px; overflow-y: scroll;padding: 20px 4px;" class="scrollse modal-body mak">

                    <!--散客预订-->
                    <div id="reverceDeacity" style="width: 100%;height: 100%;" class="ydType">
                        <form id="skform" action="addreserve" method="post">
                            <span>类　　型：</span><select name="customer_type" style="height: 25px ">
                            <option>散客</option>
                            <option>会议酒席</option>
                            <option>VIP</option>
                            <option>团体</option>
                            <option>公司接待</option>
                            <option>单位接待</option>
                            <option>会议</option>
                        </select>
                            <span>客人姓名：</span><input class="notnull sknotnull" name="customer_name" type="text" />
                            <span>人　　数：</span><input name="people_number" type="text" />
                            <div class="linediv"></div>
                            <span>联　系人：</span><input name="contacts" type="text" />
                            <span>联系电话：</span><input name="contact_number" type="text" />
                            <span>预约时长(分钟)</span><input name="appointment_length" type="text" />
                            <div class="linediv"></div>
                            <span>会员卡号：</span><input name="member_card" type="text" />
                            <span>席　　数：</span><input name="seats_num" type="text" />
                            <span>餐　　标：</span><input name="standard_meal" type="text" />
                            <div class="linediv"></div>
                            <span>公司名称：</span><input class="input" name="corporate_name" type="text" />
                            <span>营业经理：</span><input name="sales_manager" type="text" />
                            <div class="linediv"></div>
                            <span>合约单位：</span><input class="input" name="contract_unit" type="text" />
                            <div class="linediv"></div>
                            <span style="position: relative;top: -45px;">备　　注：</span><textarea style="width: 748px;height: 100px;resize: none;" name="remarks"></textarea>
                            <div class="linediv"></div>
                            <span>入单时间：</span>
                            <div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="entry_date">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <div class="linediv"></div>
                            <span>入席时间：</span>
                            <div id="ruxishijian" class=" input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input class="notnull sknotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="atthe_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input class="date ruxitime notnull sknotnull" name="atthe_time" type="datetime-local" />--%>
                            <span>结束日期：</span>
                            <div id="jieshushijian" class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input class="notnull sknotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="end_date">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input class="date jieshutime" name="end_date" type="datetime-local" />--%>
                            <div class="linediv"></div>


                            <%--<input name="entry_date" type="datetime-local" />--%>

                            <span>记录操作人：</span><input name="record_operator" type="text"  style="margin-right: 86px"/>
                            <span>记录时间：</span>
                            <div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="recording_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input name="recording_time" type="datetime-local" />--%>
                            <div class="linediv"></div>
                            <span>最后修改人：</span><input name="final_amendment" type="text" style="margin-right: 86px"/>
                            <span>最后修改时间</span>
                            <div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="last_modified_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input name="last_modified_time" type="datetime-local" />--%>
                            <div class="linediv"></div>
                            <div id="fentings" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>

                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束日期</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>
                        </form>
                    </div>

                    <!--酒席-->
                    <div id="jiuxi" class="ydType" style="display: none;width: 100%;height: 100%;">
                        <form id="jiuxiform">
                            <span>类　　型：</span><select name="customer_type" style="height: 25px ">
                            <option>会议酒席</option>
                            <option>V　I　P</option>
                            <option>散　　客</option>
                            <option>团　　体</option>
                            <option>公司接待</option>
                            <option>单位接待</option>
                            <option>会　　议</option>
                        </select>
                            <span>入单时间：</span><input name="entry_data" type="datetime-local" />
                            <span>客人姓名：</span><input name="customer_name" type="text" />
                            <div class="linediv"></div>
                            <span>营业经理：</span><input name="sales_manager" type="text" />
                            <span>联　系人：</span><input name="contacts" type="text" />
                            <span>联系电话：</span><input name="contact_number" type="text" />
                            <div class="linediv"></div>
                            <span>预约时长(分钟)</span><input name="appointment_length" type="text" />
                            <span>摆酒位置：</span><input name="WINE_POSITION" type="text" />
                            <span>开　　票：</span><input style="width: 18px;height: 18px;position: relative ;top: 5px;" name="ISBILLING" type="checkbox" />
                            <div class="linediv"></div>
                            <span>入席时间：</span><input name="atthe_time" type="datetime-local" />
                            <span>结束日期：</span><input name="end_date" type="datetime-local" />
                            <span>席　　数：</span><input name="seats_num" type="text" />
                            <div class="linediv"></div>
                            <span>付款方式：</span><select name="PAYMENT_METHOD" style="height: 25px ">
                            <option>现　金</option>
                            <option>挂　账</option>
                            <option>签　单</option>
                            <option>银　联</option>
                            <option>支付宝</option>
                            <option>微　信</option>
                        </select>
                            <span>取消原因：</span><input class="input" name="CANCELLATION_REASONS" type="text" />
                            <div class="linediv"></div>
                            <span>人　　数：</span><input name="people_number" type="text" />
                            <span>花车数量：</span><input name="FLOAT_NUM" type="text" />
                            <span>请柬数量：</span><input name="INVITATION_NUM" type="text" />
                            <div class="linediv"></div>
                            <span>司仪收费：</span><input name="CEREMONIES_CHARGE" type="text" />
                            <span>花车收费：</span><input name="FLOAT_CHARGE" type="text" />
                            <span>请柬收费：</span><input name="INVITATION_CHARGE" type="text" />
                            <div class="linediv"></div>
                            <span>襟花收费：</span><input name="CORSAGES_CHARGE" type="text" />
                            <span>美工布置收费</span><input name="ARTLAYOUT_CHARGE" type="text" />
                            <span>蛋糕布置收费</span><input name="CAKE_CHARGE" type="text" />
                            <div class="linediv"></div>
                            <span>瓜子糖果收费</span><input name="MELONCANDY_CHARGE" type="text" />
                            <span>酒水折扣：</span><input name="DRINKS_DISCOUNT" type="text" />
                            <span>签到薄收费：</span><input name="ATTENDANCEBOOK_CHARGE" type="text" />
                            <div class="linediv"></div>
                            <span>临时工收费：</span><input name="TEMPORARYWORKER_CHARGE" type="text" />
                            <span>灯光收费：</span><input name="LIGHTING_CHARGE" type="text" />
                            <span>装车收费：</span><input name="LOADING_CHARGE" type="text" />
                            <div class="linediv"></div>
                            <span>授　权人：</span><input name="AUTHORIZED_PERSON" type="text" />
                            <span>菜　　肴：</span><input name="DISH" type="text" />
                            <span>饮　　料：</span><input name="DRINKS" type="text" />
                            <div class="linediv"></div>
                            <span>鲜　　花：</span><input name="FLOWER" type="text" />
                            <span>香　　烟：</span><input name="CIGARETTE" type="text" />
                            <span>礼　　品：</span><input name="GIFT" type="text" />
                            <div class="linediv"></div>
                            <span>印　菜单：</span><input name="PRINT_MENU" type="text" />
                            <span>房间节目：</span><input name="ROOM_PROGRAM" type="text" />
                            <span>厅堂节目：</span><input name="AUDITORIUM_PROGRAM" type="text" />
                            <div class="linediv"></div>
                            <span>场地布置：</span><input name="SITE_LAYOUT" type="text" />
                            <span>冻　毛巾：</span><input name="FROZEN_TOWEL" type="text" />
                            <span>桌　　牌：</span><input name="MONOGRAM" type="text" />
                            <div class="linediv"></div>
                            <span>指　示牌：</span><input name="INDICATOR" type="text" />
                            <span>投　影仪：</span><input name="PROJECTOR" type="text" />
                            <span>纸　　笔：</span><input name="PAPERANDPEN" type="text" />
                            <div class="linediv"></div>
                            <span>车　　位：</span><input name="PARKING_LOT" type="text" />
                            <span>背　景架：</span><input name="BACKGROUND_FRAME" type="text" />
                            <span>花_植物背景：</span><input name="FLORAL_PLANT_BACK" type="text" />
                            <div class="linediv"></div>
                            <span>花　　歇：</span><input name="TEA_BREAK" type="text" />
                            <span>礼仪服务：</span><input name="ETIQUETTE_SERVICE" type="text" />
                            <span>喷绘安装：</span><input name="LNKJET_INSTALLATION" type="text" />
                            <div class="linediv"></div>
                            <span>L E D 屏：</span><input name="LED_SCREEN" type="text" />
                            <span>欢　迎匾：</span><input name="WELCOME_PLAQUE" type="text" />
                            <span>活动舞台：</span><input name="REVOLVING_STAGE" type="text" />
                            <div class="linediv"></div>
                            <span>桌　　签：</span><input name="TABLE_SIGN" type="text" />
                            <span>笠　　牌：</span><input name="LI_CARD" type="text" />
                            <span>表　　演：</span><input name="PERFORM" type="text" />
                            <div class="linediv"></div>
                            <span>布　　场：</span><input name="CLOTH_FIELD" type="text" />
                            <span>租　场费：</span><input name="RENTAL_FEE" type="text" />
                            <span>大门广告：</span><input name="GATE_ADVERTISEMENT" type="text" />
                            <div class="linediv"></div>
                            <span>彩虹拱门：</span><input name="RAINBOW_ARCHED_ENTRANCE" type="text" />
                            <span>腾空气球：</span><input name="FLYING_BALLOON" type="text" />
                            <span>罗　马旗：</span><input name="ROME_FLAG" type="text" />
                            <div class="linediv"></div>
                            <span>场租已含：</span><input name="RENT_INCLUDED" type="text" />
                            <span>影视音像：</span><input name="VIDEO_AND_AUDIO" type="text" />
                            <div class="linediv"></div>
                            <span style="position: relative;top: -45px;">其他要求：</span><textarea style="width: 748px;height: 100px;resize: none;" name="OTHER_REQUIREMENTS"></textarea>
                            <div class="linediv"></div>
                            <div id="fentings3" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>

                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth3">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束日期</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>

                        </form>
                    </div>

                    <!--宴会-->
                    <div id="yanhui" class="ydType" style="display: none;width: 100%;height: 100%;">
                        <form id="yanhuiform">
                            <span>类　　型：</span><select name="customer_type" style="height: 25px ">
                            <option>会议酒席</option>
                            <option>V　I　P</option>
                            <option>散　　客</option>
                            <option>团　　体</option>
                            <option>公司接待</option>
                            <option>单位接待</option>
                            <option>会　　议</option>
                        </select>
                            <span>入单时间：</span><input name="entry_data" type="datetime-local" />
                            <span>客人姓名：</span><input name="customer_name" type="text" />
                            <div class="linediv"></div>
                            <span>营业经理：</span><input name="sales_manager" type="text" />
                            <span>联　系人：</span><input name="contacts" type="text" />
                            <span>联系电话：</span><input name="contact_number" type="text" />
                            <div class="linediv"></div>
                            <span>预约时长(分钟)</span><input name="appointment_length" type="text" />
                            <span>摆酒位置：</span><input name="WINE_POSITION" type="text" />
                            <span>车　　位：</span><input name="PARKING_LOT" type="text" />
                            <div class="linediv"></div>
                            <span>入席时间：</span><input name="atthe_time" type="datetime-local" />
                            <span>结束日期：</span><input name="end_date" type="datetime-local" />
                            <span>开　　票：</span><input style="width: 18px;height: 18px;position: relative ;top: 5px;" name="ISBILLING" type="checkbox" />
                            <div class="linediv"></div>
                            <span>付款方式：</span><select name="PAYMENT_METHOD" style="height: 25px ">
                            <option>现　金</option>
                            <option>挂　账</option>
                            <option>签　单</option>
                            <option>银　联</option>
                            <option>支付宝</option>
                            <option>微　信</option>
                        </select>
                            <span>取消原因：</span><input class="input" name="CANCELLATION_REASONS" type="text" />
                            <div class="linediv"></div>
                            <span>会员卡号：</span><input name="MEMBER_CARD" type="text" />
                            <span>授　权人：</span><input name="AUTHORIZED_PERSON" type="text" />
                            <span>席　　数：</span><input name="seats_num" type="text" />
                            <div class="linediv"></div>
                            <span>人　　数：</span><input name="people_number" type="text" />
                            <span>花车数量：</span><input name="FLOAT_NUM" type="text" />
                            <span>请柬数量：</span><input name="INVITATION_NUM" type="text" />
                            <div class="linediv"></div>
                            <span>活　　动：</span><input name="ACTIVITY" type="text" />
                            <span>有效签单人：</span><input name="VALID_SIGNATURE" type="text" />
                            <span>地　　点：</span><input name="PLACE" type="text" />
                            <div class="linediv"></div>
                            <span>保证人数：</span><input name="GUARANTEE_NUMBER" type="text" />
                            <span>台　　型：</span><input name="TABLE_TYPE" type="text" />
                            <span>电子屏内容：</span><input name="ELECTRONIC_SCREEN_CONTENT" type="text" />
                            <div class="linediv"></div>
                            <span>会场布置1：</span><input name="VENUE_LAYOUT_1" type="text" />
                            <span>会场布置2：</span><input name="VENUE_LAYOUT_2" type="text" />
                            <span>付款说明1：</span><input name="PAYMENT_INSTRUCTIONS_1" type="text" />
                            <div class="linediv"></div>
                            <span>付款说明2：</span><input name="PAYMENT_INSTRUCTIONS_2" type="text" />
                            <span>付款说明3：</span><input name="PAYMENT_INSTRUCTIONS_3" type="text" />
                            <span>其他要求：</span><input name="OTHER_EQUIREMENTS" type="text" />
                            <div class="linediv"></div>
                            <span>工程部1：</span><input name="ENGINEERING_DPARTMENT_1" type="text" />
                            <span>工程部2：</span><input name="ENGINEERING_DPARTMENT_2" type="text" />
                            <span>安保部1：</span><input name="SECURITY_EPARTMENT_1" type="text" />
                            <div class="linediv"></div>
                            <span>安保部2：</span><input name="SECURITY_EPARTMENT_2" type="text" />
                            <span>财务部1：</span><input name="FINANCE_EPARTMENT_1" type="text" />
                            <span>财务部2：</span><input name="FINANCE_EPARTMENT_2" type="text" />
                            <div class="linediv"></div>
                            <span>前　台1：</span><input name="RECEPTION_1" type="text" />
                            <span>前　台2：</span><input name="RECEPTION_2" type="text" />
                            <span>客房部1：</span><input name="KEEPING_DPARTMENT_1" type="text" />
                            <div class="linediv"></div>
                            <span>客房部2：</span><input name="KEEPING_DPARTMENT_2" type="text" />
                            <div class="linediv"></div>
                            <span style="position: relative;top: -45px;">备　　注：</span><textarea style="width: 748px;height: 100px;resize: none;" name="REMARKS"></textarea>
                            <div class="linediv"></div>
                            <div id="fentings2" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>

                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth2">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束日期</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>

                        </form>
                    </div>

                </div>
                <div class="modal-footer" style="border-top:2px solid #1BD7BF;margin-top: 0;">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="formsubmit" type="button" class="btn btn-primary"style="background: #1BD7BF;">提交</button>
                </div>
            </div>
        </div>
    </div>

</div>
<div id="jinggao" class="alert alert-warning" style="display: none;text-align: center;width: 50%;position: fixed;top:0px;right: 25%">

    <strong><span id="jinggaotext"></span></strong>
</div>

</body>

<script>
        <c:if test="${addResult!=null}">
        alert("${addResult}");
        </c:if>

    var halls = ''; //分厅
    var hallTables = ''; //餐台

    //    //时间控件
        $('.form_datetime').datetimepicker({
            format:'yyyy-mm-dd hh:ii:00',
            autoclose : true,
            language : 'zh-CN',
            pickerPosition : 'bottom-left',
            todayBtn : false,
            viewSelect : 'hour'
        });

   //查看当天或全部
    $(".selectRadio").on("click",function () {
    if($(this).val()=='1'){ //查看当天
    window.location.href="<%=basePath%>/reserve";
    }else if($(this).val()=='0'){ //查看全部
        window.location.href="<%=basePath%>/reserve?staetTime=1";
    }
    });




    $(".lead").click(function() {
        if($(this).is(":checked")) {
            $(".leadsuns").prop("checked", "checked");
        } else {
            $(".leadsuns").prop("checked", "");
        }
    });

    $(".jnog").click(function() {
        if($(this).attr("name") == "update") {
            if($(".leadsuns:checked").length != 1) {
                $("#jinggaotext").text("请选择一条记录");
                $("#jinggao").show();
                setTimeout(jinggaosh, 2000);
            } else {
                $('#myModal').modal('show');
            }
        } else if($(this).attr("name") == "delete") {
            if($(".leadsuns:checked").length == 0) {
                $("#jinggaotext").text("请至少选择一条记录");
                $("#jinggao").show();
                setTimeout(jinggaosh, 2000);
            } else {
                var ids='';
                $(".leadsuns:checked").each(function () {
                    ids+="reserveIds="+$(this).parent().siblings(".reserveId").val()+"&";
                });

                $.ajax({
                    url: "<%=basePath%>/updateReserveState",
                    type: "post",
                    dataType: "json",
                    data: "state=2&"+ids,
                    success: function(data) {
                        alert(data.result);
                        window.location.href="<%=basePath%>/reserve?currentPage=${pageBean.currentPage}&pageSize=${pageBean.pageSize}";
                    }
                });

                <%--window.location.href="<%=basePath%>/updateReserveState?state=2&"+ids;--%>
            }
        } else if($(this).attr("name") == "add") {
            $.ajax({
                url: "<%=basePath%>/restaurantReservation/selectHalls",
                type: "get",
                dataType: "json",
                success: function(data) {
                    halls = data;
                    if(data.length != 0) {
                        $.ajax({
                            url: "<%=basePath%>/restaurantReservation/selectTablesByHall",
                            type: "get",
                            dataType: "json",
                            data: {"hallId": data[0].id},
                            success: function(data1) {
                                console.log(data1);
                                hallTables = data1;
                            }
                        });
                    }
                }
            });

            $("#skform").find("input").val("");
            console.log( $("#skform").find(".fentingtable"));
            $("#skform").find(".fentingtable").html('<tr id="fentingth">'+
                '<th>分厅</th>'+
                '<th>餐台</th>'+
                '<th>入席时间</th>'+
                '<th>结束日期</th>'+
                '<th>市别</th>'+
                '<th>状态</th>'+
                '</tr>');
            $("#skform").attr("action","<%=basePath%>/addreserve");
            $('#myModal').modal('show');
        }
    });

    function jinggaosh() {
        $("#jinggao").hide();
    }

    //添加分厅
    $(".addfenting").click(function() {

        var hallstring = '';
        var hallsTabletring = '';
        if(halls.length == 0) {
            hallstring = '<option>无</option>'
        } else {
            for(var i = 0; i < halls.length; i++) {
                hallstring += '<option class="halloptions" value="' + halls[i].id + '">' + halls[i].HALL_NAME + '</option>'
            }
            if(hallTables.length != 0) {
                for(var i = 0; i < hallTables.length; i++) {
                    hallsTabletring += '<option value="'+ hallTables[i].id+'">' + hallTables[i].table_codee + hallTables[i].table_name + '</option>';
                }
            } else {
                hallsTabletring = '<option>无</option>';
            }
        }

//        atthe_time end_date
        //fentings
        var ss=$(this).siblings(".fentingtable").parent("#fentings");
        var st=ss.siblings("#ruxishijian").find("input[name='atthe_time']").val();
        var et=ss.siblings("#jieshushijian").find("input[name='end_date']").val();
        st=st==''?'0':st; et=et==''?'0':et;


        $(this).siblings(".fentingtable").append('<tr class="trbnr" onclick="trbnronclick(this)">' +
            '<td><select name="reserve_hall" onchange="fentingchange(this)" class="optionHall">' + hallstring + '</select></td>' +
            '<td><select name="reserve_table" class="optionTable">' + hallsTabletring + '</select></td>' +
            '<td><input class="notnull sknotnull" type="text" name="reserve_start_time" value="'+st+'"/></td>'+
            '<td><input class="notnull sknotnull" type="text" name="reserve_end_time"  value="'+et+'"/></td>'+
            '<td><select name="shibie"><option>早市</option> <option>晚市</option></select></td>' +
            '<td><input name="reserve_hall_status" type="hidden" value="未到"/>未到</td></tr>');

        $(".scrollse").scrollTop($(".scrollse")[0].scrollHeight);
    });

    //删除分厅
    $(".removefenting").on("click", function() {
        if($(".thisoption").length == 0) {
            if($(".fentingtable .trbnr").length != 0) {
                //console.log($(this).siblings(".fentingtable").children(".trbnr"));
                //$(this).siblings(".fentingtable").children(".trbnr:last").remove();
                var x = $(this).siblings(".fentingtable");
            }
        } else {
            $(".thisoption").remove();
        }
    });

    //分厅选择事件
    function trbnronclick(abc) {
        $(".trbnr").css("background", "white");
        $(".trbnr").removeClass("thisoption");
        abc.style.background = "#b2ffa6";
        abc.setAttribute("class", "trbnr thisoption");
    }

    //餐台选择事件
    function fentingchange(s) {
        var options = '';
        console.log(s.value);
        $.ajax({
            url: "<%=basePath%>/restaurantReservation/selectTablesByHall",
            type: "get",
            dataType: "json",
            data: {
                "hallId": s.value
            },
            success: function(data) {
                if(data.length == 0) {
                    options = '<option>无</option>';
                } else {
                    for(var i = 0; i < data.length; i++) {
                        options += '<option value="'+data[i].id+'">' + data[i].table_codee + ' ' + data[i].table_name + '</option>';
                    }
                }
                var se = s.parentNode.nextSibling.firstChild;
                se.innerHTML = options;
            }
        });
    }

    //新增提交
    $("#formsubmit").on("click", function() {

        if($('.selectydType')[0].textContent == '散客') {
            var flag = true;
            $(".sknotnull").each(function() {

                if($(this).length == 0 || $(this).val() == "") {
                    $(this).css("border", "solid 1px red");
                    flag = false;
                }
            });

            if(flag) {
                $(".halloptions").removeAttr("value");

                $("#skform").submit();
            }
        }
    });

    //非空判断
    $(".notnull").on("change", function() {

        if($(this).length == 0 || $(this).val() == "") {
            $(this).css("border", "solid 1px red");
        } else {
            $(this).css("border", "solid 1px #d4d2d1");
        }
    });

    //预订类型事件
    $(".navul li").on("click", function() {

        $(".ydType").hide();
        $(".navul li").removeClass('selectydType');
        $(this).addClass('selectydType');
        console.info($('.selectydType'));
        if($('.selectydType')[0].textContent == '散客') {
            $("#reverceDeacity").show();
        } else if($('.selectydType')[0].textContent == '酒席') {
            $("#jiuxi").show();
        } else if($('.selectydType')[0].textContent == '宴会') {
            $("#yanhui").show();
        }

    });

    //获取所有分厅
    function geiHalls() {
        $.ajax({
            url: "<%=basePath%>/restaurantReservation/selectHalls",
            type: "get",
            dataType: "json",
            success: function(data) {
                halls = data;
            }
        });
    }

    //获取分厅所有餐台
    function hallTabless(id) {
        $.ajax({
            url: "<%=basePath%>/restaurantReservation/selectTablesByHall",
            type: "get",
            dataType: "json",
            data: {
                "hallId": id
            },
            success: function(data) {
                hallTables = data;
            }
        });
    }



    //双击查看详情
    $(".trber").on("dblclick",function () {
        var reserveId=$(this).children(".reserveId").val();

        //更新厅堂信息
        $.ajax({
            url: "<%=basePath%>/restaurantReservation/selectHalls",
            type: "get",
            dataType: "json",
            success: function(data) {
                halls = data;

            }
        });



        //散客类型
        $.ajax({
            url:"<%=basePath%>/restaurantReservation/selectReserveInfo",
            type:"get",
            dataType:"json",
            data:{"reserveId":reserveId},
            success:function (data) {
                console.log(data);
                var form2= $("#reverceDeacity").children("#skform");
                form2.append('<input name="id" type="hidden" value='+reserveId+'>');
                form2.attr("action","<%=basePath%>/updateReserve");
                //赋值基本信息
                $.each(data.reserve,function (k,v) {
                    form2.find("input[name='"+k+"']").val(v);
                    $('#myModal').modal('show');
                });
                form2.children("select").children("option").each(function () {
                    var s=$.trim($(this).html());
                    s=s.replace(" ","");
                    if(s==data.reserve.customer_type){
                      $(this).attr("selected","selected");
                    }
                });

                //添加分厅信息
                $("#reverceDeacity").children("#skform").children("#fentings").children(".fentingtable").html("");
               for(var i=0;i<data.halls.length;i++) {

                   var hallstring = '';
                   var hallsTabletring = '';
                   var shibies = '';
                   if (halls.length == 0) {
                       hallstring = '<option>无</option>'
                   } else {
                       for (var j = 0; j < halls.length; j++) {

                           if (halls[j].HALL_NAME == data.halls[i].reserve_hall) {
                               hallstring += '<option selected="selected" class="halloptions" value="' + halls[j].id + '">' + halls[j].HALL_NAME + '</option>'
                               $.ajax({
                                   url: "<%=basePath%>/restaurantReservation/selectTablesByHall",
                                   type: "get",
                                   dataType: "json",
                                   data: {"hallId": halls[j].id},
                                   async:false,
                                   success: function(data1) {
                                       hallTables = data1;
                                   }
                               });
                           } else {
                               hallstring += '<option  class="halloptions" value="' + halls[j].id + '">' + halls[j].HALL_NAME + '</option>'
                           }
                       }

                       if (hallTables.length != 0) {
                           for (var j = 0; j < hallTables.length; j++) {
                               if (hallTables[j].id == data.halls[i].table_id) {
                                   hallsTabletring += '<option selected="selected" value="'+hallTables[j].id+'">' + hallTables[j].table_codee + hallTables[j].table_name + '</option>';
                               } else {
                                   hallsTabletring += '<option value="'+hallTables[j].id+'">' + hallTables[j].table_codee + hallTables[j].table_name + '</option>';
                               }
                           }
                       } else {
                           hallsTabletring = '<option>无</option>';
                       }
                   }



                   if (data.halls[i].shibie == "早市") {
                       shibies = '<td><select name="shibie"><option selected="selected">早市</option> <option>晚市</option></select></td>'
                   } else if (data.halls[i].shibie == "晚市") {
                       shibies = '<td><select name="shibie"><option >早市</option> <option selected="selected">晚市</option></select></td>'
                   }

                       $("#reverceDeacity").children("#skform").children("#fentings").children(".fentingtable").append(
                           '<tr class="trbnr" onclick="trbnronclick(this)">' +
                           '<td><select name="reserve_hall" onchange="fentingchange(this)" class="optionHall">' + hallstring + '</select></td>' +
                           '<td><select name="reserve_table" class="optionTable">' + hallsTabletring + '</select></td>' +
                           '<td><input class="notnull sknotnull" name="reserve_start_time" type="text" value="' + data.halls[i].reserve_start_time + '"/></td>' +
                           '<td><input class="notnull sknotnull" name="reserve_end_time" type="text" value="' + data.halls[i].reserve_end_time + '"/></td>' +
                           shibies +
                           '<td><input name="reserve_hall_status" type="hidden" value="' + data.halls[i].reserve_hall_status + '"/></td></tr>'
                       );
               }
            }
        });
    });


</script>


</html>



