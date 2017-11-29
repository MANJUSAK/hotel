<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/20
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>楼面</title>
    <link rel="stylesheet" href="<%=basePath%>/floor/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/floor/css/bootstrap-select.css">
    <script type="text/javascript" src="<%=basePath%>/floor/js/jquery.min.js"></script>
    <%--<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>--%>
    <script src="<%=basePath%>/floor/js/bootstrap-select.js"></script>
    <%--<script type="text/javascript" src="<%=basePath%>/floor/js/jquery-1.4.2.min.js"></script>--%>
    <script type="text/javascript" src="<%=basePath%>/floor/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/floor/js/jquery.datePicker-min.js"></script>
    <link type="text/css" href="<%=basePath%>/floor/css.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>/floor/js/bootstrap.js"></script>


    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            font-family: "微软雅黑";
        }
        html,body{
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        #container{
            width: 100%;
            height: 100%;

        }

        #right{
            width: 20%;
            height: 100%;
            float: left;
            border:0px solid #ccc;
            background-color:#EBFFFF;
            overflow: scroll;
        }
        #right .top{
            width: 100%;
            height: 8%;
            background-color: #02C2A9;
            justify-content: center;
            display: flex;
            align-items: center;
            font-size: 18px;
            color:white;
            margin-top: 2%


        }
        #right .top ul{
            width: 100%;
            height: 100%;
        }
        #right .top ul li{
            width: 50%;
            height: 100%;
            float: left;
            list-style: none;
            text-align: center;
        }
        .topFirst div:nth-child(1){
            width: 100%;
            height: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #5C7289

        }
        .topFirst div:nth-child(2){
            width: 100%;
            height: 50%

        }
        .topFirst div:nth-child(2) input{
            width: 70%;
            background-color: #F0F0F0;
            outline: none;
        }
        .topTwo{
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .topTwo button{
            width: 70%;
            height: 50%;
            background-color:#79A9D9;
            color: #E1E1E1;
            outline: none;
        }
        .top_a{
            width: 100%;
            height:10%;
            clear: both;

        }
        .top_a ul,.top_b ul{
            width: 100%;
            height: 100%;
        }
        .top_a ul li{
            width: 100%;
            height: 10.3%;
            list-style: none;
            padding-left: 5%;
            color: #5C7289
        }

        .top_b{
            width: 100%;
            height:25%;
            clear: both;
            margin-top: -10%
        }
        .top_b ul li{
            width: 100%;
            height: 9%;
            list-style: none;
            padding-left: 5%;
            margin-top: 1.5%;

        }
        .top_b ul li div{
            height: 100%;
            text-align: center;
            float: left;
        }
        .top_b ul li div:nth-child(1){
            width: 30%;
            text-align: left;
            font-size: 14px;
            color:#526981;
        }
        .top_b ul li div:nth-child(2){
            width:  20%;
            text-align: left;


        }
        .top_b ul li div:nth-child(3){
            width:  50%;


        }
        .top_b ul li div:nth-child(3) span{
            width: 65%;
            float: right;
            text-align: right;
            padding-right: 15%;
            color:#5C7289;
        }
        .top_c{
            width: 100%;
            height:15%;
        }
        .top_c ul{
            width: 100%;
            height: 100%
        }
        .top_c ul li{
            width: 100%;
            height: 33.333%;
            list-style: none;
        }
        .top_c ul li div{
            width: 50%;
            height: 100%;
            float: left;
            text-align: left;
            color:#5C7289;
            font-size: 14px;
            position: relative;left: 5%
        }
        .top_c ul li img{
            width: 15%;
            height: 40%
        }
        .top_d{
            width: 100%;
            height: 15%;
        }
        .top_d ul{
            width: 100%;
            height: 100%;

        }
        .top_d ul li{
            width: 100%;
            height: 30%;
            text-align: center;
            list-style: none;
            font-size: 14px
        }
        .top_d ul li div{
            width: 42%;
            height: 100%;
            float: left;
            color: #5C7289
        }
        #left{
            width: 79%;
            height: 100%;
            float: left;

        }
        #left .left_a{
            width: 100%;
            height: 5%;


        }
        #left .left_a ul{
            width: 100%;
            height: 100%;
        }
        #left .left_a ul li{
            float: left;
            height: 100%;
            list-style: none;
        }


        #ull,#ul2{width: 100%;
            height: 100%

        }

        #ull li,#ul2 li{
            height: 100%;
            float: left;

        }
        #ul2 li{
            width: 100%;
        }
        .swiper-container,.swiper-wrapper{
            width: 100%;
            height: 100%;
        }
        .swiper-wrapper .swiper-slide{
            width: 100%;
            float: left;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .left_b{
            width: 100%;
            height: 100%;
            overflow: scroll;
            clear: both;
        }
        .left_b div{
            width: 100%;
            margin-top: 5px


        }
        .left_b div div:nth-child(1){
            width: 8%;
            float: left;
            background-color:#02C2A9;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }
        .left_b div div:nth-child(2){
            width: 92%;
            float: left;
        }
        .left_b div div:nth-child(2) ul{
            width: 100%;
        }
        .left_b div div:nth-child(2) ul li{
            height: 60px;
            width: 8%;
            margin-left: 1%;
            float: left;
            list-style: none;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 2px;
            color: white;
        }

        .floorLi{
            cursor: pointer;
        }

        .lebal{
            margin-left: 10px;
            margin-top: 5px;
        }
        .resInfo{
        text-align: center;
            margin-top: 5px;
        }

    </style>
</head>
<body>
<script type="text/javascript">

    $(document).ready(function(){
        $(".datepicker").datePicker({
            inline:true,
            selectMultiple:false
        });


        $("#datepicker").datePicker({
            clickInput:true
        });
    });

</script>
<div id="container">
    <div id="left">
        <div class="left_b">


            <c:forEach items="${halls}" var="hall">
            <div class="demodiv" style="width: 100%;height: 200px;">
                <div style="width: 10%;height: 100%;margin: 0;float: left">
                    ${hall.hall_name}
                </div>

                <div class="contentdiv" style="float: left;width: 90%;margin:0">
                   <%-- <li><div>空净</div><div style="background-color: #F1F1F1"></div><div><span>2256间</span></div></li>
                    <li><div>维修</div><div style="background-color: #3333CC"></div><div><span>56间</span></div></li>
                    <li><div>预订</div><div style="background-color: #3399FF"></div><div><span>1236间</span></div></li>
                    <li><div>就座</div><div style="background-color: #660099"></div><div><span>226间</span></div></li>
                    <li><div>落单超时</div><div style="background-color: #CCCC00"></div><div><span>26间</span></div></li>
                    <li><div>打单超时未买单</div><div style="background-color: #33FF00"></div><div><span>26间</span></div></li>
                    <li><div>清洁中</div><div style="background-color: #FF6600"></div><div><span>26间</span></div></li>
                    <li><div>正在操作</div><div style="background-color: #FF3333"></div><div><span>26间</span></div></li>--%>

                    <ul class="ul123">
                        <c:if test="${fn:length(hall.hallList)>0}">
                        <c:forEach items="${hall.hallList}" var="halllist">
                        <c:if test="${not empty halllist.table_name}">

                            <c:choose>

                                <%--预订--%>
                                <c:when test="${not empty halllist.customer_name}">
                                    <li  class="floorLi reserveLi"  name="3"  title="预订人:${halllist.customer_name}"
                                         data-container="body" data-trigger="hover" data-toggle="popover" data-placement="top"
                                         data-content="人数:${halllist.people_number} &nbsp;&nbsp;电话:${halllist.contact_number}&nbsp;&nbsp;  用餐时间:${halllist.reserve_start_time}"
                                         style="background-color: #3399FF;">
                                        ${halllist.table_codee}
                                        ${halllist.table_name}<br/>
                                    </li>
                                    <input name="reservId" value="${halllist.reserveId}" type="hidden">
                                    <input value="${halllist.id}" name="tableId" type="hidden">
                                    <input value="${halllist.table_name}" name="tableName" type="hidden">
                                    <input value="${halllist.hall_name}" name="hallName" type="hidden">
                                    <input value="${halllist.minimum_consumption}" name="minimumConsumption" type="hidden"> <%-- 最低消费--%>
                                    <input value="${halllist.service_charge}" name="serviceCharge" type="hidden"> <%-- 服务费率--%>
                                </c:when>

                                <%--空净--%>
                                <c:when test="${halllist.status==1}">
                        <li class="floorLi" name="1"  title="基本信息"
                                    data-container="body" data-trigger="hover" data-toggle="popover" data-placement="top"
                            data-content="服务费:<c:if test="${halllist.service_charge==0}">无</c:if> <c:if test="${halllist.service_charge!=0}">${halllist.service_charge}%</c:if>
                                          &nbsp;&nbsp;最低消费: ${halllist.minimum_consumption}"
                                style="background-color: #b7b7b7;">
                                ${halllist.table_codee}
                                ${halllist.table_name}
                        </li>
                                <input value="${halllist.id}" name="tableId" type="hidden">
                                <input value="${halllist.table_name}" name="tableName" type="hidden">
                                <input value="${halllist.hall_name}" name="hallName" type="hidden">
                                <input value="${halllist.minimum_consumption}" name="minimumConsumption" type="hidden"> <%-- 最低消费--%>
                                <input value="${halllist.service_charge}" name="serviceCharge" type="hidden"> <%-- 服务费率--%>
                                </c:when>

                                <%--维修 --%>
                                <c:when test="${halllist.status==2}">
                                    <li style="background-color: #3333CC;">
                                            ${halllist.table_codee}
                                            ${halllist.table_name}
                                    </li>
                                </c:when>

                                <%--就座--%>
                                <c:when test="${halllist.status==4}">
                                    <li style="background-color: #660099;">
                                            ${halllist.table_codee}
                                            ${halllist.table_name}
                                    </li>
                                </c:when>

                                <%--落单超时--%>
                                <c:when test="${halllist.status==5}">
                                    <li style="background-color: #CCCC00;">
                                            ${halllist.table_codee}
                                            ${halllist.table_name}
                                    </li>
                                </c:when>

                                <%--打单超时未买单--%>
                                <c:when test="${halllist.status==6}">
                                    <li style="background-color: #33FF00;">
                                            ${halllist.table_codee}
                                            ${halllist.table_name}
                                    </li>
                                </c:when>

                            </c:choose>
                        </c:if>
                            <c:if test="${empty halllist.table_name}">
                                <li style="background-color: rgb(226,234,217);">
                                 无
                                </li>
                            </c:if>

                        </c:forEach>
                        </c:if>

                    </ul>

                </div>

            </div>

            </c:forEach>


        </div>
    </div>



    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">开台</h4>
                </div>
                <div id="ktformdiv" style="height: 200px;width: 570px" class="modal-body">
                    <form id="ktform">


                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="kaitaibut" type="button" class="btn btn-primary">开台</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>


    <script>
        $(".demodiv").each(function () {
            $(this).height($(this).children(".contentdiv").height());
        });

        //显示标签
        $(function () {
            $("[data-toggle='popover']").popover();
        });

        //显示开台
        $(".floorLi").on("click",function(){
            //空净开台
            if($(this).attr("name")==1){
                $("#ktformdiv").css("height","200px");
                var tableid= $(this).siblings("input[name='tableId']").val();
                var tableName= $(this).siblings("input[name='tableName']").val();
                var hallName= $(this).siblings("input[name='hallName']").val();
                var minimumConsumption= $(this).siblings("input[name='minimumConsumption']").val();
                var serviceCharge= $(this).siblings("input[name='serviceCharge']").val();
                $("#ktform").html("");
            $("#ktform").append('<span>客人姓名</span><input type="text" name="consumer" value="自来客"/> <span>人数</span><input type="text" name="personNum"/> ' +
                '<input type="hidden" name="aoh" value="'+tableName+'"/>' +
                '<input type="hidden" name="ctType" value="'+hallName+'"/>' +
                '<input type="hidden" name="fwRate" value="'+serviceCharge+'"/>' +
                '<input type="hidden" name="zdConsume" value="'+minimumConsumption+'"/>' +
                '<input type="hidden" name="ctid" value="'+tableid+'"/>'   );
            $("#kaitaibut").html("开台");
            $("#myModal").modal("show");
            }

            //预订开台
            if($(this).attr("name")==3){
            var reserveId=$(this).siblings("input[name='reservId']").val();
                var tableid= $(this).siblings("input[name='tableId']").val();
                var tableName= $(this).siblings("input[name='tableName']").val();
                var hallName= $(this).siblings("input[name='hallName']").val();
                var minimumConsumption= $(this).siblings("input[name='minimumConsumption']").val();
                var serviceCharge= $(this).siblings("input[name='serviceCharge']").val();
                $.ajax({
                    url: "<%=basePath%>/restaurantReservation/selectReserveInfo",
                    type: "get",
                    data: {"reserveId":reserveId},
                    dataType: "json",
                    success: function (data) {
                    var resInfo = data.reserve;
                    if(resInfo.seats_num==null){
                        resInfo.seats_num='';
                    }
                    $("#ktformdiv").css("height","400px");
                        $("#ktform").html("");
                        $("#ktform").append('' +
                        '<span class="lebal">顾客类型&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.customer_type+'" />' +
                         '<span class="lebal">客人姓名&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="consumer" value="'+resInfo.customer_name+'" /><br/>' +
                         '<span class="lebal">人&#12288;&#12288;数&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="personNum" value="'+resInfo.people_number+'" />' +
                         '<span class="lebal">预约时长&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.appointment_length+'" /><br/>' +
                         '<span class="lebal">会员卡号&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="vipNum" value="'+resInfo.member_card+'" />' +
                         '<span class="lebal">公司名称&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.corporate_name+'" /><br/>' +
                         '<span class="lebal">联系电话&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.contact_number+'" />' +
                         '<span class="lebal">合约单位&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="department" value="'+resInfo.contract_unit+'" /><br/>' +
                            '<span class="lebal">席&#12288;&#12288;数&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="placeNum" value="'+resInfo.seats_num+'" />' +
                            '<span class="lebal">营业经理&#12288;</span><input class="resInfo" type="text" readonly="readonly" name="salemanager" value="'+resInfo.sales_manager+'" /><br/>' +
                            '<span class="lebal">备&#12288;&#12288;注&#12288;</span><input style="width:395px" class="resInfo" type="text" readonly="readonly" name="remarks" value="'+resInfo.remarks+'" /><br/>' +
                            '<span class="lebal">入席时间&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.atthe_time+'" />' +
                            '<span class="lebal">结束日期&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.atthe_time+'" /><br/>' +
                            '<span class="lebal">记录操作人</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.record_operator+'" />' +
                            '<span class="lebal">记录时间&#12288;</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.recording_time+'" /><br/>' +
                            '<span class="lebal">最后修改人</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.final_amendment+'" />' +
                            '<span class="lebal">最后修改时间</span><input class="resInfo" type="text" readonly="readonly" value="'+resInfo.last_modified_time+'" />' +
                            '<input type="hidden" name="aoh" value="'+tableName+'"/>' +
                            '<input type="hidden" name="ctType" value="'+hallName+'"/>' +
                            '<input type="hidden" name="fwRate" value="'+serviceCharge+'"/>' +
                            '<input type="hidden" name="zdConsume" value="'+minimumConsumption+'"/>' +
                            '<input type="hidden" name="ctid" value="'+tableid+'"/>')

                        $("#kaitaibut").html("预订开台");
                        $("#myModal").modal("show");
                    }
                });
                }
        });


        //开台提交按钮
        $("#kaitaibut").on("click",function () {
            console.log( $("#ktform").serialize());
        });

    </script>
    <div id="right">
        <div class="top">
            餐厅图
        </div>
        <div class="top_a" style="display: flex;justify-content: center;align-items: center;">
            <input type="text" style="width: 80%;height: 40%;outline: none;border: 1px solid #ccc;padding-left: 5%" placeholder="请输入当前餐厅" /><img style="cursor: pointer" class="searchImg" src="<%=basePath%>/floor/icon/ss.png" style="width: 25px;height: 25px">
        </div>

        <div class="top_a">
            <ul>
                <li>
                    <select style="width: 85%;position: relative;left: -5px;" id="hallList">
                        <option>全部</option>
                    </select>
                </li>

            </ul>
        </div>

        <div style="width: 100%;height: 25%;margin-top: -10%" class="datepicker">

        </div>

        <div class="top_c" style="margin-top: 30%">
            <ul>
                <li><div><img src="<%=basePath%>/floor/icon/zf.png">未买单</div><div><img src="<%=basePath%>/floor/icon/wxf.png">维修</div></li>
                <li><div><img src="<%=basePath%>/floor/icon/dyf.png">清洁中</div><div><img src="<%=basePath%>/floor/icon/lszf.png">正在操作</div></li>
            </ul>
        </div>
        <div class="top_d" style="margin-top: -10%">
            <ul>
                <li><div><input type="checkbox" style="width: 15px;height: 15px" />关联预定</div><div><input type="checkbox" style="width: 15px;height: 15px" />包含假房</div></li>
                <li><div><input type="checkbox" style="width: 15px;height: 15px" />自动刷新</div><div><select><option>1分钟</option><option>2分钟</option><option>5分钟</option><option>10分钟</option><option>1小时</option></select></div></li>
            </ul>
        </div>
        <div class="top_b">
            <ul>
                <li><div>空净</div><div style="background-color: #b7b7b7"></div><div><span>2256间</span></div></li>
                <li><div>维修</div><div style="background-color: #3333CC"></div><div><span>56间</span></div></li>
                <li><div>预订</div><div style="background-color: #3399FF"></div><div><span>1236间</span></div></li>
                <li><div>就座</div><div style="background-color: #660099"></div><div><span>226间</span></div></li>
                <li><div>落单超时</div><div style="background-color: #CCCC00"></div><div><span>26间</span></div></li>
                <li><div>超时未买单</div><div style="background-color: #33FF00"></div><div><span>26间</span></div></li>
                <li><div>清洁中</div><div style="background-color: #FF6600"></div><div><span>26间</span></div></li>
                <li><div>正在操作</div><div style="background-color: #FF3333"></div><div><span>26间</span></div></li>

            </ul>
        </div>
    </div>

</div>
<script type="text/javascript">

    $.ajax({
        url: "<%=basePath%>/restaurantReservation/selectHalls",
        type: "get",
        dataType: "json",
        success: function(data) {
            var halls='';
            for(var i=0;i<data.length;i++){
                var optionhall='';
                <c:if test="${not empty optionHallId}">
                optionhall='${optionHallId}';
                </c:if>
               if(data[i].id==optionhall) {
                   halls += '<option selected="selected" value="' + data[i].id + '">' + data[i].HALL_NAME + '</option>';
               }else{
                   halls += '<option value="' + data[i].id + '">' + data[i].HALL_NAME + '</option>';
               }
            }
            $("#hallList").append(halls);
        }
    });

    //分厅查看事件
    document.getElementById("hallList").onchange=function(){

        if(this.value=="全部"){
            window.location.href="<%=basePath%>/floor";
        }else{
            window.location.href="<%=basePath%>/floor?hallId="+this.value;
        }

    };

//    搜索事件
$(".searchImg").click(function () {
   var v=$(this).siblings("input").val();
   if(v!=null && v!=''){
       window.location.href="<%=basePath%>/floor?hallName="+v;
   }

});


</script>
</body>
</html>