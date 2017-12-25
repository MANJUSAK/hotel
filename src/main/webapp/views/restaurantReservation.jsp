<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/15
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.goodsoft.hotel.service.lmpl.UserServicelmpl" %>
<%
String path=request.getContextPath();
String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
UserServicelmpl userService=new UserServicelmpl();
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

        .notnullBorder{
            border:solid red 1px;
        }
    </style>
</head>

<body>

<div style="width: 100%;height: 800px;min-width: 600px;">

    <div class="butt" style="width: 100%;height: 100px;">
        <div style="float:left;margin-left:40px;"><select style="width:100px;height:34px;border-radius:4px;padding-left: 10px;background: #F9B550;outline: none;border:0px;color:white" id="reserveTypeOption" name="sign">
            <option <c:if test="${sign==1}">selected="selected"</c:if> value="1">散客</option>
            <option <c:if test="${sign==2}">selected="selected"</c:if> value="2">酒席</option>
            <option <c:if test="${sign==3}">selected="selected"</c:if> value="3">宴会</option></select> </div>

        <div style="float:left;margin-left: 50px;">
            <select class="selectRadio" style="border-radius: 4px;width: 80px; height: 34px;background: #08DDD1; border: solid 0px;color: white;padding-left: 10px;outline: none">
                <option value="1" <c:if test="${empty staetTime}">selected="selected"</c:if>>当天</option>
                <option value="0" <c:if test="${not empty staetTime}">selected="selected"</c:if>>全部</option>
            </select>
            <%--<input class="selectRadio" style="float: left" name="dateRadio" <c:if test="${empty staetTime}">checked="checked"</c:if>  type="radio" value="1" /> <span>当天</span>--%>
        </div>
        <%--<div style="float:left;margin-left: 5px;">  <input class="selectRadio" style="float: left" name="dateRadio" <c:if test="${not empty staetTime}">checked="checked"</c:if> type="radio" value="0" /><span>全部</span></div>--%>

        <div style="float:left;  height: 34px;width: 280px;border-radius: 4px;border-bottom: 2px solid #08DDD1; border-right: 2px solid #08DDD1;border-top: 2px solid #08DDD1;">
        <div style="float:left;margin-left: 20px;margin-top: 5px;">  <input class="selectStateRadio" style="float: left" name="stateRadio" <c:if test="${state==1}">checked="checked"</c:if> type="radio" value="1" /><span>未到</span></div>
        <div style="float:left;margin-left: 13px;margin-top: 5px;">  <input class="selectStateRadio" style="float: left" name="stateRadio" <c:if test="${state==3}">checked="checked"</c:if> type="radio" value="3" /><span>已到</span></div>
        <div style="float:left;margin-left: 13px;margin-top: 5px;">  <input class="selectStateRadio" style="float: left" name="stateRadio" <c:if test="${state==2}">checked="checked"</c:if> type="radio" value="2" /><span>取消</span></div>
        <div style="float:left;margin-left: 13px;margin-top: 5px;">  <input class="selectStateRadio" style="float: left" name="stateRadio" <c:if test="${state==4}">checked="checked"</c:if> type="radio" value="4" /><span>到期未到</span></div>
        </div>

        <script>
            $("#reserveTypeOption").on("change",function (){
             window.location.href="<%=basePath%>/reserve?sign="+$(this).val()+"&loginUser=${loginUser}";
            });

            $(".selectStateRadio").on("click",function(){
              window.location.href="<%=basePath%>/reserve?state="+$(this).val()+"&loginUser=${loginUser}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>";
            });
        </script>

        <div class="input-group"style="width: 299px;float: left;margin-left:252px">
            <input id="searchInput" type="text" class="form-control" <c:if test="${not empty customerName}">value="${customerName}"</c:if>>
            <span class="input-group-btn">
                        <button id="search" class="btn btn-default" type="button">搜索</button>
                    </span>
        </div>
        <script>
            //搜索
            $("#search").on("click",function(){
                var sear=$("#searchInput").val();
                if(sear!=null && sear!=''){
                    window.location.href="<%=basePath%>/reserve?sign=${sign}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${state!=null}">&state=${state}</c:if>&customerName="+sear;
                }
            });
        </script>

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

            <c:if test="${sign==null||sign==1}">
            <c:forEach items="${pageBean.content}" var="list">
            <tr class="trber">
                <td><input type="checkbox"  class="leadsuns"></td>
                <input class="reserveId" type="hidden" value="${list.id}"/>
                <td>${list.customer_type}</td>
                <td>${list.customer_name}</td>
                <td>${list.people_number}</td>
                <td>${list.sales_manager}</td>
                <td>${list.atthe_time}</td>
                <td><c:choose><c:when test="${list.state==1}">未到</c:when><c:when test="${list.state==2}">取消</c:when>
                    <c:when test="${list.state==3}">已到</c:when><c:when test="${list.state==4}">过时未到</c:when>
                </c:choose></td>
            </tr>
        </c:forEach>
        </c:if>

        <c:if test="${sign!=null && sign!=1}">
            <c:forEach items="${pageBean.content}" var="list">
                <tr class="trber">
                    <td><input type="checkbox"  class="leadsuns"></td>
                    <input class="reserveId" type="hidden" value="${list.id}"/>
                    <td>${list.customerType}</td>
                    <td>${list.customerName}</td>
                    <td>${list.peopleNumber}</td>
                    <td>${list.salesManager}</td>
                    <td>${list.attheTime}</td>
                    <td><c:choose><c:when test="${list.state==1}">未到</c:when><c:when test="${list.state==2}">取消</c:when>
                        <c:when test="${list.state==3}">已到</c:when><c:when test="${list.state==4}">过时未到</c:when>
                    </c:choose></td>
                </tr>
            </c:forEach>
        </c:if>
        </table>

        <script>
            //tr单击事件
            $(".trber").on("click",function(){

                var check=$(this).find(".leadsuns");
                //console.log(check.is(":checked"));
                if(!check.is(":checked")){
                check .prop("checked", "checked");
                }else{
                    check .prop("checked", "");
                }
            });
        </script>


        <%--底部分页固定div--%>
        <div style="height: 100px;width: 100%;position: fixed;left: 0px;bottom: 0px; ">

        <%--每页显示条数--%>
        <div style="float: left;margin-left: 40px;margin-top: 42px;font-size: 17px">
            每页显示:<select class="pageSizeOption">
            <option <c:if test="${pageBean.pageSize==5}">selected="selected"</c:if> value="5">5</option>
            <option <c:if test="${pageBean.pageSize==10}">selected="selected"</c:if> value="10">10</option>
            <option <c:if test="${pageBean.pageSize==15}">selected="selected"</c:if> value="15">15</option>
            <option <c:if test="${pageBean.pageSize==20}">selected="selected"</c:if> value="20">20</option>
        </select>
            <script>
                $(".pageSizeOption").on("change",function (){
                   window.location.href="<%=basePath%>/reserve?currentPage=1&loginUser=${loginUser}&pageSize="+$(this).val()+"<c:if test="${not empty staetTime}">&staetTime=1</c:if>"+"<c:if test="${sign!=null}">&sign=${sign}</c:if>";
                });
            </script>
        </div>

        <!--分页-->
        <div style="float: right;margin-right: 25px;margin-top: 15px">
            <ul class="pagination">
                <script>
                    $(".pagination").append('<li> <a href="<%=basePath%>/reserve?currentPage=${pageBean.previousPage}&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">上一页</a> </li>');

                    <c:if test="${pageBean.pageTotal<7}">
                    for(var i=1;i<=${pageBean.pageTotal};i++){

                        if(i==${pageBean.currentPage}){
                            $(".pagination").append('<li class="active"><a href="<%=basePath%>/reserve?currentPage='+i+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+i+'</a> </li>');
                        }else{
                            $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage=' + i + '&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">' + i + '</a> </li>');
                        }
                    }
                    </c:if>


                    <c:if test="${pageBean.pageTotal>6}">

                    <c:if test="${pageBean.currentPage<5}">
                    for(var i=1;i<=5;i++){
                        var active='pointtln';
                        if(i==${pageBean.currentPage}){active='active';}
                        $(".pagination").append('<li class="'+active+'"><a href="<%=basePath%>/reserve?currentPage='+i+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+i+'</a> </li>');
                    }
                    $(".pagination").append('<li><a>......</a> </li>');
                    $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage='+'${pageBean.pageTotal}'+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+'${pageBean.pageTotal}'+'</a> </li>');
                    </c:if>

                    <c:if test="${pageBean.currentPage>=5 && pageBean.currentPage<=pageBean.pageTotal-5}">
                    $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage=1&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+'1'+'</a> </li>');
                    $(".pagination").append('<li><a>......</a> </li>');

                    for(var i=${pageBean.currentPage-1};i<=${pageBean.currentPage+1};i++){
                        var active='pointtln';
                        if(i==${pageBean.currentPage}){active='active';}
                        $(".pagination").append('<li class="'+active+'"><a href="<%=basePath%>/reserve?currentPage='+i+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+i+'</a> </li>');
                    }

                    $(".pagination").append('<li><a>......</a> </li>');
                    $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage='+'${pageBean.pageTotal}'+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+'${pageBean.pageTotal}'+'</a> </li>');

                    </c:if>


                    <c:if test="${ pageBean.currentPage>pageBean.pageTotal-5 && pageBean.currentPage>=5}">
                    $(".pagination").append('<li><a href="<%=basePath%>/reserve?currentPage=1&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+'1'+'</a> </li>');
                    $(".pagination").append('<li><a>......</a> </li>');

                    for(var i=${pageBean.pageTotal-5};i<=${pageBean.pageTotal};i++){
                        var active='pointtln';
                        if(i==${pageBean.currentPage}){active='active';}
                        $(".pagination").append('<li class="'+active+'"><a href="<%=basePath%>/reserve?currentPage='+i+'&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">'+i+'</a> </li>');
                    }
                    </c:if>


                    </c:if>


                    $(".pagination").append('<li> <a href="<%=basePath%>/reserve?currentPage=${pageBean.nextPage}&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${not empty staetTime}">&staetTime=1</c:if><c:if test="${sign!=null}">&sign=${sign}</c:if>">下一页</a> </li>');
                </script>

            </ul>
        </div>
        </div>

    </div>

    <!--弹出框-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width: 900px; ">
            <div class="modal-content" style="overflow: hidden;">
                <div class="modal-header"style="padding: 0px;border-bottom: 2px solid #1BD7BF;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="margin-right: 20px;padding-top: 10px;outline:none;">&times;</button>
                    <ul class="navul clearfloat">
                        <li name="1" class="selectydType"><h4>散客</h4></li>
                        <li name="2"><h4>酒席</h4></li>
                        <li name="3"><h4>宴会</h4></li>
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
                            <span>营业经理：</span>
                            <select name="sales_manager" style="width: 172px;text-align: center; height: 25px; position: relative; left: -4px;" >
                                <option></option>
                                <c:forEach items="${salesman.data}" var="item">
                                    <option>${item.userName}</option>
                                </c:forEach>
                            </select>

                            <div class="linediv"></div>
                            <span>合约单位：</span><input class="input" name="contract_unit" type="text" />
                            <div class="linediv"></div>
                            <span style="position: relative;top: -45px;">备　　注：</span><textarea style="width: 748px;height: 100px;resize: none;" name="remarks"></textarea>
                            <div class="linediv"></div>
                            <span>入单时间：</span>
                            <input class="customDate"  readonly = "readonly" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="entry_date">

                        <%--<div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">--%>
                                <%--<input class="customDate"  readonly = "readonly" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="entry_date">--%>
                                <%--<span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>--%>
                                <%--<span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>--%>
                            <%--</div>--%>
                            <div class="linediv"></div>
                            <span>入席时间：</span>
                            <div id="ruxishijian" class=" input-group date form_datetime"  style="display:inline;margin:0">
                                <input class="notnull sknotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="atthe_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input class="date ruxitime notnull sknotnull" name="atthe_time" type="datetime-local" />--%>
                            <span>结束时间：</span>
                            <div id="jieshushijian" class="input-group date form_datetime"  style="display:inline;margin:0">
                                <input class="notnull sknotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="end_date">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input class="date jieshutime" name="end_date" type="datetime-local" />--%>
                            <div class="linediv"></div>


                            <%--<input name="entry_date" type="datetime-local" />--%>

                            <span>记录操作人：</span><input class="loginUser" readonly = "readonly" name="record_operator" type="text"  style="margin-right: 86px"/>
                            <span>记录时间：</span>
                            <div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input style="width:172px;clear: both;margin:0;position:relative;left:-4px;" class="customDate" readonly = "readonly"  type="text" name="recording_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input name="recording_time" type="datetime-local" />--%>
                            <div class="linediv"></div>
                            <span>最后修改人：</span><input readonly = "readonly" name="final_amendment" type="text" style="margin-right: 86px"/>
                            <span>最后修改时间</span>
                            <div class="input-group date form_datetime" id="startpicker" style="display:inline;margin:0">
                                <input style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  readonly = "readonly" type="text" name="last_modified_time">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <%--<input name="last_modified_time" type="datetime-local" />--%>
                            <div class="linediv"></div>
                            <span>取消原因</span><input readonly = "readonly" style="width:460px" class="input" name="cancellation_reason" type="text" /><div class="linediv"></div>
                            <div id="fentings" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>
                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束时间</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>
                        </form>
                    </div>

                    <!--酒席-->
                    <div id="jiuxi" class="ydType" style="display: none;width: 100%;height: 100%;">
                        <form id="jiuxiform" action="<%=basePath%>/addJxreserve" method="post">
                            <span>类型：</span><select name="customerType" style="height: 25px ">
                            <option>会议酒席</option>
                            <option>VIP</option>
                            <option>散客</option>
                            <option>团体</option>
                            <option>公司接待</option>
                            <option>单位接待</option>
                            <option>会议</option>
                        </select>
                            <span>客人姓名：</span><input class="notnull jxnotnull" name="customerName" type="text" />
                            <span>营业经理：</span>
                            <select name="salesManager" style="width: 172px;text-align: center; height: 25px; position: relative; left: -4px;" >
                                <option></option>
                                <c:forEach items="${salesman.data}" var="item">
                                    <option>${item.userName}</option>
                                </c:forEach>
                            </select>
                            <div class="linediv"></div>
                            <span>入单时间：</span><input  class="customDate" readonly = "readonly" name="entryDate" type="text" />
                            <span>联系 人：</span><input name="contacts" type="text" />
                            <span>联系电话：</span><input name="contactsNumber" type="text" />
                            <div class="linediv"></div>
                            <span>预约时长(分钟)</span><input name="appointmentLength" type="text" />
                            <span>摆酒位置：</span><input name="winePosition" type="text" />
                            <span>开　　票：</span><input style="width: 18px;height: 18px;position: relative ;top: 5px;" value="1" name="isbilling" type="checkbox" />
                            <div class="linediv"></div>

                            <span>入席时间：</span>
                            <div  class=" input-group date form_datetime jruxishijian"  style="display:inline;margin:0">
                                <input class="notnull jxnotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="attheTime">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <span>结束时间：</span>
                            <div  class=" input-group date form_datetime jruxishijian"  style="display:inline;margin:0">
                                <input class="notnull jxnotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="endDate">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <div class="linediv"></div>
                            <span>公司名称：</span><input style="width: 258px" class="input" name="corporateName" type="text" />
                            <span>合约单位：</span><input style="width: 258px" class="input" name="contractUnit" type="text" />
                            <div class="linediv"></div>
                            <span>席　　数：</span><input name="seatsNum" type="text" />
                            <span>付款方式：</span><select name="paymentMethod" style="height: 25px ">
                            <option>现　金</option>
                            <option>挂　账</option>
                            <option>签　单</option>
                            <option>银　联</option>
                            <option>支付宝</option>
                            <option>微　信</option>
                        </select>
                            <div class="linediv"></div>
                            <span>取消原因：</span><input readonly = "readonly" class="input" name="cancellationReasons" type="text" />
                            <div class="linediv"></div>
                            <span>人　　数：</span><input name="peopleNumber" type="text" />
                            <span>花车数量：</span><input name="floatNum" type="text" />
                            <span>请柬数量：</span><input name="invitationNum" type="text" />
                            <div class="linediv"></div>
                            <span>司仪收费：</span><input name="ceremoniesCharge" type="text" />
                            <span>花车收费：</span><input name="floatCharge" type="text" />
                            <span>请柬收费：</span><input name="invitationCharge" type="text" />
                            <div class="linediv"></div>
                            <span>襟花收费：</span><input name="corsagesCharge" type="text" />
                            <span>美工布置收费</span><input name="artlayoutCharge" type="text" />
                            <span>蛋糕布置收费</span><input name="cakeCharge" type="text" />
                            <div class="linediv"></div>
                            <span>瓜子糖果收费</span><input name="meloncandyCharge" type="text" />
                            <span>酒水折扣：</span><input name="drinksDiscount" type="text" />
                            <span>签到薄收费：</span><input name="attendancebookCharge" type="text" />
                            <div class="linediv"></div>
                            <span>临时工收费：</span><input name="temporaryworkerCharge" type="text" />
                            <span>灯光收费：</span><input name="lightingCharge" type="text" />
                            <span>装车收费：</span><input name="loadingCharge" type="text" />
                            <div class="linediv"></div>
                            <span>授　权人：</span><input name="authorizedPerson" type="text" />
                            <span>菜　　肴：</span><input name="dish" type="text" />
                            <span>饮　　料：</span><input name="drinks" type="text" />
                            <div class="linediv"></div>
                            <span>鲜　　花：</span><input name="flower" type="text" />
                            <span>香　　烟：</span><input name="cigarette" type="text" />
                            <span>礼　　品：</span><input name="gift" type="text" />
                            <div class="linediv"></div>
                            <span>印　菜单：</span><input name="printMenu" type="text" />
                            <span>房间节目：</span><input name="roomProgram" type="text" />
                            <span>厅堂节目：</span><input name="auditoriumProgram" type="text" />
                            <div class="linediv"></div>
                            <span>场地布置：</span><input name="siteLayout" type="text" />
                            <span>冻　毛巾：</span><input name="frozenTowel" type="text" />
                            <span>桌　　牌：</span><input name="monogram" type="text" />
                            <div class="linediv"></div>
                            <span>指　示牌：</span><input name="indicator" type="text" />
                            <span>投　影仪：</span><input name="projector" type="text" />
                            <span>纸　　笔：</span><input name="paperandpen" type="text" />
                            <div class="linediv"></div>
                            <span>车　　位：</span><input name="parkingLot" type="text" />
                            <span>背　景架：</span><input name="backgroundFrame" type="text" />
                            <span>花_植物背景：</span><input name="floralPlantBack" type="text" />
                            <div class="linediv"></div>
                            <span>花　　歇：</span><input name="teaBreak" type="text" />
                            <span>礼仪服务：</span><input name="etiquetteService" type="text" />
                            <span>喷绘安装：</span><input name="lnkjetInstallation" type="text" />
                            <div class="linediv"></div>
                            <span>l e d 屏：</span><input name="ledScreen" type="text" />
                            <span>欢　迎匾：</span><input name="welcomePlaque" type="text" />
                            <span>活动舞台：</span><input name="revolvingStage" type="text" />
                            <div class="linediv"></div>
                            <span>桌　　签：</span><input name="tableSign" type="text" />
                            <span>笠　　牌：</span><input name="liCard" type="text" />
                            <span>表　　演：</span><input name="perform" type="text" />
                            <div class="linediv"></div>
                            <span>布　　场：</span><input name="cloth_field" type="text" />
                            <span>租　场费：</span><input name="rental_fee" type="text" />
                            <span>大门广告：</span><input name="gate_advertisement" type="text" />
                            <div class="linediv"></div>
                            <span>彩虹拱门：</span><input name="rainbowArchedEntrance" type="text" />
                            <span>腾空气球：</span><input name="flyingBalloon" type="text" />
                            <span>罗　马旗：</span><input name="romeFlag" type="text" />
                            <div class="linediv"></div>
                            <span>场租已含：</span><input name="rentIncluded" type="text" />
                            <span>影视音像：</span><input name="videoAndAudio" type="text" />
                            <div class="linediv"></div>
                            <span style="position:relative;top: -45px;">其他要求：</span><textarea style="width: 748px;height: 100px;resize: none;" name="otherRequirements"></textarea>
                            <div class="linediv"></div>
                            <div id="fentings3" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>

                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth3">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束时间</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>

                        </form>
                    </div>

                    <!--宴会-->
                    <div id="yanhui" class="ydType" style="display: none;width: 100%;height: 100%;">
                        <form id="yanhuiform" action="<%=basePath%>/addYhreserve" method="post">
                            <span>类型：</span><select name="customerType" style="height: 25px ">
                            <option>会议酒席</option>
                            <option>VIP</option>
                            <option>散客</option>
                            <option>团体</option>
                            <option>公司接待</option>
                            <option>单位接待</option>
                            <option>会议</option>
                        </select>
                            <span>客人姓名：</span><input class="notnull yhnotnull" name="customerName" type="text" />
                            <span>营业经理：</span>
                            <select name="salesManager" style="width: 172px;text-align: center; height: 25px; position: relative; left: -4px;" >
                                <option></option>
                                <c:forEach items="${salesman.data}" var="item">
                                    <option>${item.userName}</option>
                                </c:forEach>
                            </select>

                            <div class="linediv"></div>
                            <span>入单时间：</span>
                            <input  class="customDate" readonly = "readonly"  style="width:172px;clear: both;"  type="text" name="entryDate">
                            <span>联　系人：</span><input name="contacts" type="text" style="position: relative;left:-3px" />
                            <span>联系电话：</span><input name="contactsNumber" type="text"  style="position: relative;left:-3px"/>
                            <div class="linediv"></div>
                            <span>预约时长(分钟)</span><input name="appointmentLength" type="text" />
                            <span>摆酒位置：</span><input name="winePosition" type="text" />
                            <span>车　　位：</span><input name="parkingLot" type="text" />
                            <div class="linediv"></div>
                            <%--<span>入席时间：</span><input name="attheTime" type="datetime-local" />--%>
                            <%--<span>结束时间：</span><input name="endDate" type="datetime-local" />--%>
                            <span>入席时间：</span>
                            <div  class=" input-group date form_datetime jruxishijian"  style="display:inline;margin:0">
                                <input class="notnull yhnotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="attheTime">
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <span>结束时间：</span>
                            <div  class=" input-group date form_datetime jruxishijian"  style="display:inline;margin:0">
                            <input class="notnull yhnotnull" style="width:172px;clear: both;margin:0;position:relative;left:-4px;"  type="text" name="endDate">
                            <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-5px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span  style="display:inline;padding:3px 5px;margin:0;position:relative;left:-9px;top:-2px;" class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <div class="linediv"></div>
                            <span>公司名称：</span><input style="width:250px" class="input" name="corporateName" type="text" />
                            <span>合约单位：</span><input style="width:250px" class="input" name="contractUnit" type="text" />
                            <span>开　　票：</span><input style="width: 18px;height: 18px;position: relative ;top: 5px;" name="isbilling" type="checkbox" />
                            <div class="linediv"></div>
                            <span>付款方式：</span><select name="paymentMethod" style="height: 25px ">
                            <option>现　金</option>
                            <option>挂　账</option>
                            <option>签　单</option>
                            <option>银　联</option>
                            <option>支付宝</option>
                            <option>微　信</option>
                        </select>
                            <span>取消原因：</span><input readonly = "readonly" class="input" name="cancellationReasons" type="text" />
                            <div class="linediv"></div>
                            <span>会员卡号：</span><input name="memberCard" type="text" />
                            <span>授　权人：</span><input name="authorizedPerson" type="text" />
                            <span>席　　数：</span><input name="seatsNum" type="text" />
                            <div class="linediv"></div>
                            <span>人　　数：</span><input name="peopleNumber" type="text" />
                            <span>花车数量：</span><input name="floatNum" type="text" />
                            <span>请柬数量：</span><input name="invitationNum" type="text" />
                            <div class="linediv"></div>
                            <span>活　　动：</span><input name="activity" type="text" />
                            <span>有效签单人：</span><input name="validSignature" type="text" />
                            <span>地　　点：</span><input name="place" type="text" />
                            <div class="linediv"></div>
                            <span>保证人数：</span><input name="guaranteeNumber" type="text" />
                            <span>台　　型：</span><input name="tableType" type="text" />
                            <span>电子屏内容：</span><input name="electronicScreenContent" type="text" />
                            <div class="linediv"></div>
                            <span>会场布置1：</span><input name="venueLayout1" type="text" />
                            <span>会场布置2：</span><input name="venueLayout2" type="text" />
                            <span>付款说明1：</span><input name="paymentInstructions1" type="text" />
                            <div class="linediv"></div>
                            <span>付款说明2：</span><input name="paymentInstructions2" type="text" />
                            <span>付款说明3：</span><input name="paymentInstructions3" type="text" />
                            <span>其他要求：</span><input name="otherEquirements" type="text" />
                            <div class="linediv"></div>
                            <span>工程部1：</span><input name="engineeringDpartment1" type="text" />
                            <span>工程部2：</span><input name="engineeringEpartment2" type="text" />
                            <span>安保部1：</span><input name="securityEpartment1" type="text" />
                            <div class="linediv"></div>
                            <span>安保部2：</span><input name="securityEpartment2" type="text" />
                            <span>财务部1：</span><input name="financeEpartment1" type="text" />
                            <span>财务部2：</span><input name="financeEpartment2" type="text" />
                            <div class="linediv"></div>
                            <span>前　台1：</span><input name="reception1" type="text" />
                            <span>前　台2：</span><input name="reception2" type="text" />
                            <span>客房部1：</span><input name="keepingDpartment1" type="text" />
                            <div class="linediv"></div>
                            <span>客房部2：</span><input name="keepingDpartment2" type="text" />
                            <div class="linediv"></div>
                            <span style="position: relative;top: -45px;">备　　注：</span>
                            <textarea style="width: 748px;height: 100px;resize: none;" name="remarks"></textarea>
                            <div class="linediv"></div>
                            <div id="fentings2" style="color:#000000;width: 98%;height: auto;border: solid 1px #929292;margin-left: 10px">
                                <button type="button" class="addfenting btn btn-default">添加</button>
                                <button type="button" class="removefenting btn btn-default">删除</button>

                                <table class="fentingtable" width="100%" cellpadding="2" cellspacing="1" align="center">
                                    <tr id="fentingth2">
                                        <th>分厅</th>
                                        <th>餐台</th>
                                        <th>入席时间</th>
                                        <th>结束时间</th>
                                        <th>市别</th>
                                        <th>状态</th>
                                    </tr>

                                </table>

                            </div>

                        </form>
                    </div>

                </div>
                <div class="modal-footer" style="border-top:2px solid #1BD7BF;margin-top: 0;">
                    <span class="joinText" style="position: relative;left: -240px;color:red;font-size: 15px;"></span>
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



<div id="deleteReason" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h3>请输入取消原因</h3>
            </div>
            <div class="modal-body" style="height: 100px">
                <input  type="hidden" class="deleteId" />
                <textarea  class="reasonText notnull" style="width:100%;height: 99px">

                </textarea>
            </div>
            <div class="modal-footer">
                <a data-toggle="modal"  id="deleteSubmit" class="btn btn-primary btn-large">提交</a>
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
            </div>
        </div>
    </div>
</div>


</body>

<script>
        <c:if test="${addResult!=null}">
        alert("${addResult}");
        </c:if>


        //获取当前时间
        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            var minutes=date.getMinutes();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " +
                (date.getHours()<10 ?"0"+date.getHours():date.getHours()) + seperator2 +
                (date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes())+ seperator2 +
                (date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds());
            return currentdate;
        }


    var halls = ''; //分厅
    var hallTables = ''; //餐台

        var newDate = new Date();
        var DriguTime = newDate.toJSON();
        //    //时间控件
        $('.form_datetime').datetimepicker({
            format:'yyyy-mm-dd hh:ii:00',
            autoclose : true,
            language : 'zh-CN',
            pickerPosition : 'bottom-left',
            todayBtn : false,
            viewSelect : 'hour',
            startDate :new Date(DriguTime)
        });

   //查看当天或全部
    $(".selectRadio").on("change",function () {
    if($(this).val()=='1'){ //查看当天
    window.location.href="<%=basePath%>/reserve?loginUser=${loginUser}<c:if test="${sign!=null}">&sign=${sign}</c:if>";
    }else if($(this).val()=='0'){ //查看全部
        window.location.href="<%=basePath%>/reserve?staetTime=1&loginUser=${loginUser}<c:if test="${sign!=null}">&sign=${sign}</c:if>";
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
                var lean=$(".leadsuns:checkbox:checked");
                var reservId=lean.parent("td").siblings(".reserveId").val();
                viewDetails(reservId);
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

                $("#deleteReason").find(".deleteId").val(ids);
                $("#deleteReason").find(".reasonText").val("");
                $("#deleteReason").find(".reasonText").removeClass("notnullBorder");
                $("#deleteReason").modal("show");


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
                                //console.log(data1);
                                hallTables = data1;
                            }
                        });
                    }
                }
            });

            $("#skform").find("input").val("");
            $("#skform").find("textarea").val("");

            $("#jiuxiform").find("input").val("");
            $("#jiuxiform").find("textarea").val("");

            $("#yanhuiform").find("input").val("");
            $("#yanhuiform").find("textarea").val("");
            $(".notnullBorder").removeClass("notnullBorder");

            $(".customDate").val(getNowFormatDate());
            $(".loginUser").val("${loginUser}");

            //console.log( $("#skform").find(".fentingtable"));
            $("#skform").find(".fentingtable").html('<tr id="fentingth">'+
                '<th>分厅</th>'+
                '<th>餐台</th>'+
                '<th>入席时间</th>'+
                '<th>结束时间</th>'+
                '<th>市别</th>'+
                '<th>状态</th>'+
                '</tr>');
            $("#jiuxiform").find(".fentingtable").html('<tr id="fentingth">'+
                '<th>分厅</th>'+
                '<th>餐台</th>'+
                '<th>入席时间</th>'+
                '<th>结束时间</th>'+
                '<th>市别</th>'+
                '<th>状态</th>'+
                '</tr>');
            $("#yanhuiform").find(".fentingtable").html('<tr id="fentingth">'+
                '<th>分厅</th>'+
                '<th>餐台</th>'+
                '<th>入席时间</th>'+
                '<th>结束时间</th>'+
                '<th>市别</th>'+
                '<th>状态</th>'+
                '</tr>');


                $("#skform").attr("action","<%=basePath%>/addreserve");
                $("#jiuxiform").attr("action","<%=basePath%>/addJxreserve");
                $("#yanhuiform").attr("action","<%=basePath%>/addYhreserve");
            $('#myModal').modal('show');
        }
    });


    //取消原因提交
    $("#deleteSubmit").on("click",function(){

        var reserveId= $(this).parent("div").parent("div").find(".deleteId").val();
        var deleteReason= $(this).parent("div").parent("div").find(".reasonText");
        var deleteReasonval= $(this).parent("div").parent("div").find(".reasonText").val();

      //console.log(reserveId);
      //console.log(deleteReasonval);

      if(deleteReasonval=='' || deleteReasonval.length==0) {
          return;
      }else{
          if($("#reserveTypeOption").val()=='1'){
          $.ajax({
              url: "<%=basePath%>/updateReserveState",
              type: "post",
              dataType: "json",
              data: "state=2&"+reserveId,
              success: function(data) {
                  if(data.result=="修改成功"){
                      $.ajax({
                          url: "<%=basePath%>/updateReserveReason",
                          type: "post",
                          dataType: "json",
                          data: "cancellationReason="+deleteReasonval+"&"+reserveId,
                          success: function(data1) {
                          }
                      });
                  }
                  alert(data.result);
                  window.location.href="<%=basePath%>/reserve?currentPage=${pageBean.currentPage}&loginUser=${loginUser}&pageSize=${pageBean.pageSize}<c:if test="${sign!=null}">&sign=${sign}</c:if><c:if test="${staetTime!=null}">&staetTime=1=${sign}</c:if>";
              }
          });
           }else if($("#reserveTypeOption").val()=='2'){
              $.ajax({
                  url: "<%=basePath%>/updateJxReserveState",
                  type: "post",
                  dataType: "json",
                  data: "state=2&"+reserveId,
                  success: function(data) {
                      if(data.result=="修改成功"){
                          $.ajax({
                              url: "<%=basePath%>/updateJxReserveReason",
                              type: "post",
                              dataType: "json",
                              data: "cancellationReason="+deleteReasonval+"&"+reserveId,
                              success: function(data1) {
                              }
                          });
                      }
                      alert(data.result);
                      window.location.href="<%=basePath%>/reserve?currentPage=${pageBean.currentPage}&loginUser=${loginUser}&pageSize=${pageBean.pageSize}";
                  }
              });

          }else if($("#reserveTypeOption").val()=='3'){
//              //console.log("-----"+deleteReasonval);
//              //console.log("-----"+reserveId);
              $.ajax({
                  url: "<%=basePath%>/updateYhReserveState",
                  type: "post",
                  dataType: "json",
                  data: "state=2&"+reserveId,
                  success: function(data) {
                      if(data.result=="修改成功"){
                          $.ajax({
                              url: "<%=basePath%>/updateYhReserveReason",
                              type: "post",
                              dataType: "json",
                              data: "cancellationReason="+deleteReasonval+"&"+reserveId,
                              success: function(data1) {
                              }
                          });
                      }
                      alert(data.result);
                      window.location.href="<%=basePath%>/reserve?currentPage=${pageBean.currentPage}&loginUser=${loginUser}&pageSize=${pageBean.pageSize}";
                  }
              });
          }
      }
    });


        function jinggaosh() {
            $("#jinggao").hide();
    }

    //添加分厅
    $(".addfenting").click(function() {

       if($('.selectydType')[0].textContent == '散客') {
           var atteTime = $(this).parent("div").siblings("#ruxishijian").find("input[name='atthe_time']");
           var endTime = $(this).parent("div").siblings("#jieshushijian").find("input[name='end_date']");
       }else if($('.selectydType')[0].textContent != '散客'){
           var atteTime = $(this).parent("div").siblings(".jruxishijian").find("input[name='attheTime']");
           var endTime = $(this).parent("div").siblings(".jruxishijian").find("input[name='endDate']");
       }

        if(atteTime.val()==null || atteTime.val()=='' ){
             //atteTime.css("border","solid 1px red");
            atteTime.addClass("notnullBorder");
           return ;
       }else if(endTime.val()==null || endTime.val()==''){
//            endTime.css("border","solid 1px red");
            endTime.addClass("notnullBorder");
            return ;
        }
       else{
           atteTime.removeClass("notnullBorder");
           endTime.removeClass("notnullBorder");
//            atteTime.removeAttr("border");
//            endTime.removeAttr("border");
//            atteTime.css("border","solid 1px #929292");
//            endTime.css("border","solid 1px #929292");
        }


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
        if($('.selectydType')[0].textContent == '散客') {
            var st = ss.siblings("#ruxishijian").find("input[name='atthe_time']").val();
            var et = ss.siblings("#jieshushijian").find("input[name='end_date']").val();
        }else if($('.selectydType')[0].textContent != '散客'){
            var st = $(this).parent("div").siblings(".jruxishijian").find("input[name='attheTime']").val();
            var et = $(this).parent("div").siblings(".jruxishijian").find("input[name='endDate']").val();
        }

        st=st==''?'0':st; et=et==''?'0':et;


        $(this).siblings(".fentingtable").append('<tr class="trbnr" onclick="trbnronclick(this)">' +
            '<td><select name="reserve_hall" onchange="fentingchange(this)" class="optionHall">' + hallstring + '</select></td>' +
            '<td><select name="reserve_table" class="optionTable">' + hallsTabletring + '</select></td>' +
            '<td><input class="notnull sknotnull" type="text" name="reserve_start_time" value="'+st+'"/></td>'+
            '<td><input class="notnull sknotnull" type="text" name="reserve_end_time"  value="'+et+'"/></td>'+
            '<td><select name="shibie"><option>早市</option><option>中市</option> <option>晚市</option></select></td>' +
            '<td><input name="reserve_hall_status" type="hidden" value="未到"/>未到</td></tr>');

        $(".scrollse").scrollTop($(".scrollse")[0].scrollHeight);

        //非空判断
        $(".notnull").on("change", function() {
            if($(this).length == 0 || $(this).val() == "") {
                $(this).addClass("notnullBorder");
                //$(this).css("border", "solid 1px red");
            } else {
                $(this).removeClass("notnullBorder");
                //$(this).css("border", "solid 1px #d4d2d1");
            }
        });
    });

    //删除分厅
    $(".removefenting").on("click", function() {
        if($(".thisoption").length == 0) {
            if($(".fentingtable .trbnr").length != 0) {
                ////console.log($(this).siblings(".fentingtable").children(".trbnr"));
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
        //console.log(s.value);
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
        })
    }

    //新增提交
    $("#formsubmit").on("click", function() {

        if($('.selectydType')[0].textContent == '散客') {
            var flag = true;
            $(".sknotnull").each(function() {

                if($(this).length == 0 || $(this).val() == "") {
                    $(this).addClass("notnullBorder");
                    //$(this).css("border", "solid 1px red");
                    flag = false;
                }
            });

            $("#skform").children("#fentings").find(".optionTable").each(function() {
                var tableSelect = $(this);
                var tableId = $(this).val();
                var startTime = $(this).parent("td").next("td").children("input[name='reserve_start_time']").val();
//                joinText
                if( $("#skform").attr("action")=="<%=basePath%>/addreserve"){
                $.ajax({
                    url: "<%=basePath%>/restaurantReservation/joinTableAndDate",
                    type: "get",
                    dataType: "json",
                    async: false,
                    data: {"tableId": tableId, "startTime": startTime},
                    success: function (data) {
                        //console.log(data);
                        if (data > 0) {
                            $(".joinText").html("餐台已被预订");
                            tableSelect.addClass("notnullBorder");
                            flag = false;
                        } else {
                            $(".joinText").html("");
                            tableSelect.removeClass("notnullBorder");

                        }
                    }
                });
            }
                });

            if(flag) {
                $(".halloptions").removeAttr("value");
                $("#skform").submit();
            }
        }


        //酒席
        if($('.selectydType')[0].textContent == '酒席') {
            flag = true;

            $(".jxnotnull").each(function () {
                if ($(this).length == 0 || $(this).val() == "") {
                    $(this).addClass("notnullBorder");
                    flag = false;
                }
            });

            $("#jiuxiform").children("#fentings3").find(".optionTable").each(function() {
                var tableSelect = $(this);
                var tableId = $(this).val();
                var startTime = $(this).parent("td").next("td").children("input[name='reserve_start_time']").val();
//                joinText
                if( $("#jiuxiform").attr("action")=="<%=basePath%>/addJxreserve"){
                $.ajax({
                    url: "<%=basePath%>/restaurantReservation/joinTableAndDate",
                    type: "get",
                    dataType: "json",
                    async: false,
                    data: {"tableId": tableId, "startTime": startTime},
                    success: function (data) {
                        //console.log(data);
                        if (data > 0) {
                            $(".joinText").html("餐台已被预订");
                            tableSelect.addClass("notnullBorder");
                            flag = false;
                        } else {
                            $(".joinText").html("");
                            tableSelect.removeClass("notnullBorder");
                        }
                    }
                });
            }
                  if(!flag){return;}
            });

            if (flag) {
            $(".halloptions").removeAttr("value");
            $("#jiuxiform").submit();
              }
        }


        //宴会
        if($('.selectydType')[0].textContent == '宴会') {
            flag = true;

            $(".yhnotnull").each(function () {
                if ($(this).length == 0 || $(this).val() == "") {
                    $(this).addClass("notnullBorder");
                    flag = false;
                }
            });

            $("#yanhui").children("#fentings2").find(".optionTable").each(function() {
                var tableSelect = $(this);
                var tableId = $(this).val();
                var startTime = $(this).parent("td").next("td").children("input[name='reserve_start_time']").val();
                if( $("#yanhui").attr("action")=="<%=basePath%>/addYhreserve"){
                $.ajax({
                    url: "<%=basePath%>/restaurantReservation/joinTableAndDate",
                    type: "get",
                    dataType: "json",
                    async: false,
                    data: {"tableId": tableId, "startTime": startTime},
                    success: function (data) {
                        //console.log(data);
                        if (data > 0) {
                            $(".joinText").html("餐台已被预订");
                            tableSelect.addClass("notnullBorder");
                            flag = false;
                        } else {
                            $(".joinText").html("");
                            tableSelect.removeClass("notnullBorder");
                        }
                    }
                });
            }
                if(!flag){return;}
            });

       if (flag) {
                $(".halloptions").removeAttr("value");
                $("#yanhuiform").submit();
                 }
        }
    });

    //非空判断
    $(".notnull").on("change", function() {

        if($(this).length == 0 || $(this).val() == "") {
            $(this).addClass("notnullBorder");
            //$(this).css("border", "solid 1px red");
        } else {
            $(this).removeClass("notnullBorder");
            //$(this).css("border", "solid 1px #d4d2d1");
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
        var reserveId = $(this).children(".reserveId").val();
        viewDetails(reserveId);
    });

    //修改按钮查看详情


    function viewDetails(reserveId){

        $(".notnullBorder").removeClass("notnullBorder");
        //更新厅堂信息
        $.ajax({
            url: "<%=basePath%>/restaurantReservation/selectHalls",
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                halls = data;
            }
        });

        var data5 = '';


        if ($("#reserveTypeOption").val() == '1') {     //散客
            //散客类型
            $.ajax({
                url: "<%=basePath%>/restaurantReservation/selectReserveInfo",
                type: "get",
                dataType: "json",
                async: false,
                data: {"reserveId": reserveId},
                success: function (data) {
                    data5 = data;
                    //console.log(data);
                    var form2 = $("#reverceDeacity").children("#skform");
                    form2.children(".appendreserveId").remove();
                    form2.append('<input class="appendreserveId" name="id" type="hidden" value=' + reserveId + '>');
                    form2.attr("action", "<%=basePath%>/updateReserve");

                    //赋值基本信息
                    $.each(data.reserve, function (k, v) {
                        form2.find("input[name='" + k + "']").val(v);
                    });
                    form2.find("textarea").val(data.reserve.remarks);
                    $(".ydType").hide();
                    $(".navul li").removeClass('selectydType');
                    $(".navul li[name='1']").addClass('selectydType');
                    $('#myModal').modal('show');
                    $("#reverceDeacity").show();
                    form2.children("select").children("option").each(function () {
                        var s = $.trim($(this).html());
                        s = s.replace(" ", "");
                        if (s == data.reserve.customer_type) {
                            $(this).attr("selected", "selected");
                        }
                    });
                    //添加分厅信息
                    $("#reverceDeacity").children("#skform").children("#fentings").children(".fentingtable").html("");
                }
            });

        } else if ($("#reserveTypeOption").val() == '2') {     //酒席

            //酒席类型
            $.ajax({
                url: "<%=basePath%>/restaurantReservation/selectJxReserveInfo",
                type: "get",
                dataType: "json",
                async: false,
                data: {"reserveId": reserveId},
                success: function (data) {
                    data5 = data;
                    //console.log(data);
                    var form2 = $("#jiuxi").children("#jiuxiform");
                    form2.children(".appendreserveId").remove();
                    form2.append('<input class="appendreserveId" name="id" type="hidden" value=' + reserveId + '>');
                    form2.attr("action", "<%=basePath%>/updateJxReserve");

                    //赋值基本信息
                    $.each(data.reserve, function (k, v) {
                        form2.find("input[name='" + k + "']").val(v);
                    });
                    form2.find("textarea").val(data.reserve.otherRequirements);
                    $(".ydType").hide();
                    $(".navul li").removeClass('selectydType');
                    $(".navul li[name='2']").addClass('selectydType');
                    $('#myModal').modal('show');
                    $("#jiuxi").show();
                    form2.children("select[name='customerType']").children("option").each(function () {
                        var s = $.trim($(this).html());
                        s = s.replace(" ", "");
                        if (s == data.reserve.customerType) {
                            $(this).attr("selected", "selected");
                        }
                    });
                    //添加分厅信息
                    $("#jiuxi").children("#jiuxiform").children("#fentings3").children(".fentingtable").html("");
                }
            });


        } else if ($("#reserveTypeOption").val() == '3') {      //宴会

            //宴会类型
            $.ajax({
                url: "<%=basePath%>/restaurantReservation/selectYhReserveInfo",
                type: "get",
                dataType: "json",
                async: false,
                data: {"reserveId": reserveId},
                success: function (data) {
                    data5 = data;
                    //console.log(data);
                    var form2 = $("#yanhui").children("#yanhuiform");
                    form2.children(".appendreserveId").remove();
                    form2.append('<input class="appendreserveId" name="id" type="hidden" value=' + reserveId + '>');
                    form2.attr("action", "<%=basePath%>/updateYhReserve");

                    //赋值基本信息
                    $.each(data.reserve, function (k, v) {
                        form2.find("input[name='" + k + "']").val(v);
                    });
                    form2.find("textarea").val(data.reserve.remarks);
                    $(".ydType").hide();
                    $(".navul li").removeClass('selectydType');
                    $(".navul li[name='3']").addClass('selectydType');
                    $('#myModal').modal('show');
                    $("#yanhui").show();
                    form2.children("select[name='customerType']").children("option").each(function () {
                        var s = $.trim($(this).html());
                        s = s.replace(" ", "");
                        if (s == data.reserve.customerType) {
                            $(this).attr("selected", "selected");
                        }
                    });
                    //添加分厅信息
                    $("#yanhui").children("#yanhuiform").children("#fentings2").children(".fentingtable").html("");
                }
            });
        }


        for (var i = 0; i < data5.halls.length; i++) {

            var hallstring = '';
            var hallsTabletring = '';
            var shibies = '';
            if (halls.length == 0) {
                hallstring = '<option>无</option>'
            } else {
                for (var j = 0; j < halls.length; j++) {

                    if (halls[j].HALL_NAME == data5.halls[i].reserve_hall) {
                        hallstring += '<option selected="selected" class="halloptions" value="' + halls[j].id + '">' + halls[j].HALL_NAME + '</option>'
                        $.ajax({
                            url: "<%=basePath%>/restaurantReservation/selectTablesByHall",
                            type: "get",
                            dataType: "json",
                            data: {"hallId": halls[j].id},
                            async: false,
                            success: function (data1) {
                                hallTables = data1;
                            }
                        });
                    } else {
                        hallstring += '<option  class="halloptions" value="' + halls[j].id + '">' + halls[j].HALL_NAME + '</option>'
                    }
                }

                if (hallTables.length != 0) {
                    for (var j = 0; j < hallTables.length; j++) {
                        if (hallTables[j].id == data5.halls[i].table_id) {
                            hallsTabletring += '<option selected="selected" value="' + hallTables[j].id + '">' + hallTables[j].table_codee + hallTables[j].table_name + '</option>';
                        } else {
                            hallsTabletring += '<option value="' + hallTables[j].id + '">' + hallTables[j].table_codee + hallTables[j].table_name + '</option>';
                        }
                    }
                } else {
                    hallsTabletring = '<option>无</option>';
                }
            }


            if (data5.halls[i].shibie == "早市") {
                shibies = '<td><select name="shibie"><option selected="selected">早市</option> <option>中市</option><option>晚市</option></select></td>'
            } else if (data5.halls[i].shibie == "晚市") {
                shibies = '<td><select name="shibie"><option >早市</option> <option>中市</option><option selected="selected">晚市</option></select></td>'
            }else if(data5.halls[i].shibie == "中市"){
                shibies = '<td><select name="shibie"><option >早市</option> <option selected="selected">中市</option><option selected="selected">晚市</option></select></td>'
            }

            var ft = '';

            if ($("#reserveTypeOption").val() == '1') {
                ft = $("#reverceDeacity").children("#skform").children("#fentings").children(".fentingtable");
            } else if ($("#reserveTypeOption").val() == '2') {
                ft = $("#jiuxi").children("#jiuxiform").children("#fentings3").children(".fentingtable");
            } else if ($("#reserveTypeOption").val() == '3') {
                ft = $("#yanhui").children("#yanhuiform").children("#fentings2").children(".fentingtable");
            }

            ft.append(
                '<tr class="trbnr" onclick="trbnronclick(this)">' +
                '<td><select name="reserve_hall" onchange="fentingchange(this)" class="optionHall">' + hallstring + '</select></td>' +
                '<td><select name="reserve_table" class="optionTable">' + hallsTabletring + '</select></td>' +
                '<td><input class="notnull sknotnull" name="reserve_start_time" type="text" value="' + data5.halls[i].reserve_start_time + '"/></td>' +
                '<td><input class="notnull sknotnull" name="reserve_end_time" type="text" value="' + data5.halls[i].reserve_end_time + '"/></td>' +
                shibies +
                '<td><input name="reserve_hall_status" type="hidden"  value="' + data5.halls[i].reserve_hall_status + '"/></td></tr>'
            );
        }



        //非空判断
        $(".notnull").on("change", function() {
            if($(this).length == 0 || $(this).val() == "") {
                $(this).addClass("notnullBorder");
                //$(this).css("border", "solid 1px red");
            } else {
                $(this).removeClass("notnullBorder");
                //$(this).css("border", "solid 1px #d4d2d1");
            }
        });
    }




</script>
</html>