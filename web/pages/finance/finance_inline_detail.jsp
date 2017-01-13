<%--
  行内详细
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/4/15
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="<%=path%>/scripts/boot.js" type="text/javascript"></script>
    <title>行内明细</title>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            border: 0;
            margin: 0;
            padding: 0;
            overflow: visible;
        }

        #collapseSpan {
            text-align: center;
            display: inline-block;
            width: 20px;
        }

        #searchSpan {
            display: none;
        }

    </style>

</head>
<body>
<%--<div class="mini-toolbar" style="padding:2px;border-bottom:0;">--%>
    <%--<table style="width:100%;">--%>
        <%--<tr>--%>
            <%--<td style="width:100%;">--%>
                <%--<span id="operateSpan">--%>
                    <%--<a class="mini-button" iconCls="icon-add" onclick="add()">添加</a>--%>
                    <%--<a class="mini-button" iconCls="icon-edit" onclick="edit()">修改</a>--%>
                    <%--<a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>--%>
                    <%--<a class="mini-button" iconCls="icon-download" onclick="exportExcel()">导出</a>--%>
                <%--</span>--%>
            <%--</td>--%>
            <%--<td style="white-space:nowrap;">--%>
                <%--<form>--%>
                    <%--<div id="searchForm">--%>
                        <%--<span id="searchSpan">--%>
                            <%--<input id="page_type" name="page_type" class="mini-hidden" value="${type}"/>--%>
                            <%--<input id="startTime" name="startTime" value="${startTime}" class="mini-datepicker"/> ~--%>
                            <%--<input id="endTime" name="endTime" value="${endTime}" class="mini-datepicker"/>--%>
                            <%--<input id="type" name="type" class="mini-combobox" style="width:100px;" textField="name"--%>
                                   <%--valueField="id"--%>
                                   <%--url="getTypeData?type=${type}" showNullItem="true" allowInput="true"--%>
                                   <%--emptyText="请选择类型" nullItemText="请选择类型"/>--%>
                            <%--<input id="name" name="name" class="mini-textbox" emptyText="请输入关键字" style="width:150px;"/>--%>
                            <%--<a class="mini-button" onclick="search()">查询</a>--%>
                        <%--</span>--%>
                        <%--<span id="collapseSpan"><img id="collapseButton"--%>
                                                     <%--src="<%=path%>/scripts/miniui/themes/default/images/layout/west.gif"/></span>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>

<div class="mini-fit">
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;"
         url="getInlineDetailData?type=${type}"  idField="id" showPager="false"
         onshowrowdetail="onShowRowDetail">
        <div property="columns">
            <div type="expandcolumn" width="10"></div>
            <div field="MONTH" width="200" headerAlign="center" align="center" >时间</div>
            <%--<div field="name" width="320" headerAlign="left" >部门名称</div>--%>
        </div>
    </div>

    <div id="detailGrid_Form" style="display:none;">
        <div id="inlinegrid" class="mini-datagrid" style="width:100%;height:auto;"
             url="getInlineData" showPager="false" sortMode="client">
            <div property="columns">
                <div width="10" type="indexcolumn"></div>
                <div field="date" width="100" headerAlign="center" align="center" dateFormat="yyyy-MM-dd" allowSort="true"
                     dataType="date">日期
                </div>
                <div field="type_name" width="100" headerAlign="center" align="center" allowSort="true">类型</div>
                <div field="name" width="100" headerAlign="center" align="center" allowSort="true">名称</div>
                <div field="money" width="100" headerAlign="center" align="center" allowSort="true" dataType="int">金额</div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    mini.parse();

    var grid = mini.get("datagrid");
    var inlinegrid = mini.get("inlinegrid");
    var detailGrid_Form = document.getElementById("detailGrid_Form");

    grid.load();

    ///////////////////////////////////////////////////////

    function onShowRowDetail(e) {
        var grid = e.sender;
        var row = e.record;

        var td = grid.getRowDetailCellEl(row);
        td.appendChild(detailGrid_Form);
        detailGrid_Form.style.display = "block";

        inlinegrid.load({ startTime: row.MONTH,
            page_type:"${type}"});
    }


    grid.on("load",function(e){
        setTimeout(function(){
            var row=grid.getRow(0)
            grid.showRowDetail(row)
        },100)
    });
</script>
</body>
</html>
