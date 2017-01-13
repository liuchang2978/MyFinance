<%--
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/4/5
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="<%=path%>/scripts/boot.js" type="text/javascript"></script>
    <title>支出明细</title>
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
<div class="mini-toolbar" style="padding:2px;border-bottom:0;">
    <table style="width:100%;">
        <tr>
            <td style="width:100%;">
                <span id="operateSpan">
                    <a class="mini-button" iconCls="icon-add" onclick="add()">添加</a>
                    <a class="mini-button" iconCls="icon-edit" onclick="edit()">修改</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
                    <a class="mini-button" iconCls="icon-download" onclick="exportExcel()">导出</a>
                </span>
            </td>
            <td style="white-space:nowrap;">
                <form>
                    <div id="searchForm">
                        <span id="searchSpan">
                            <input id="page_type" name="page_type" class="mini-hidden" value="${type}"/>
                            <input id="startTime" name="startTime" value="${startTime}" class="mini-datepicker"/> ~
                            <input id="endTime" name="endTime" value="${endTime}" class="mini-datepicker"/>
                            <input id="type" name="type" class="mini-combobox" style="width:100px;" textField="name"
                                   valueField="id"
                                   url="getTypeData?type=${type}" showNullItem="true" allowInput="true"
                                   emptyText="请选择类型" nullItemText="请选择类型"/>
                            <input id="name" name="name" class="mini-textbox" emptyText="请输入关键字" style="width:150px;"/>
                            <a class="mini-button" onclick="search()">查询</a>
                        </span>
                        <span id="collapseSpan"><img id="collapseButton"
                                                     src="<%=path%>/scripts/miniui/themes/default/images/layout/west.gif"/></span>
                    </div>
                </form>
            </td>
        </tr>
    </table>
</div>

<div class="mini-fit">
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;"
         url="getDetailData" idField="id" showPager="false" sortMode="client" ondrawcell="drawcell" showSummaryRow="true" ondrawsummarycell="onDrawSummaryCell">
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

<script type="text/javascript">
    mini.parse();

    var form = new mini.Form("#searchForm");

    var grid = mini.get("datagrid");
    grid.load(form.getData(true));

    function search() {
        var data = form.getData(true);      //获取表单多个控件的数据
        data.is_search = "1";
//        var json = mini.encode(data);   //序列化成JSON
        grid.load(data);
    }

    function onDrawSummaryCell(e) {
        var result = e.result;
        if (e.field == "date") {
            e.cellHtml = "<div style='text-align:center;height:20px;'>合计:</div>";
        }
        if (e.field == "money") {
            e.cellHtml = "<div style='text-align:center;'>"+result.sum+"<div>";
        }
    }

    function drawcell(e){
        var field = e.field;
        var value = e.value;

        //结余为负，红色标识
        if (field == "money" && value < 0) {
            e.cellStyle = "color:red;font-weight:bold;";
        }
    }

    function add() {

        mini.open({
            url: "finance/toAdd?type=${type}",
            title: "哇哦！又有新的伙伴了！", width: 350, height: 260,
            onload: function () {
                var iframe = this.getIFrameEl();
                var data = {action: "add"};
                iframe.contentWindow.SetData(data);
            },
            ondestroy: function (action) {

                grid.reload();
            }
        });
    }

    function edit() {

        var row = grid.getSelected();
        if (row) {
            mini.open({
                url: "finance/toAdd?type=${type}",
                title: "你真的要修改我吗？", width: 350, height: 260,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = {action: "edit", row: row};
                    iframe.contentWindow.SetData(data);

                },
                ondestroy: function (action) {
                    grid.reload();

                }
            });

        } else {
            alert("请选中一条记录");
        }

    }

    function remove() {

        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            if (confirm("确定删除选中记录？")) {
                var id = rows[0].id;
                grid.loading("操作中，请稍后......");
                $.ajax({
                    url: "del",
                    data: {id: id},
                    success: function (text) {
                        if (text == "1") {
                            grid.reload();
                        } else {
                            mini.alert("删除失败！", "失败");
                        }
                    },
                    error: function () {
                    }
                });
            }
        } else {
            alert("请选中一条记录");
        }
    }

    function exportExcel(){
        var expForm = document.forms[0];
        expForm.action = "exportExcel";
        debugger
        expForm.submit();
    }

    $(function () {
        var sSpan = false;
        $("#collapseSpan").click(function () {
            if (!sSpan) {
                $("#searchSpan").show();
                $("#collapseButton").attr("src", "<%=path%>/scripts/miniui/themes/default/images/layout/east.gif");
                sSpan = true;
            } else {
                $("#searchSpan").hide();
                $("#collapseButton").attr("src", "<%=path%>/scripts/miniui/themes/default/images/layout/west.gif");
                sSpan = false;
            }
        });

    });
</script>
</body>
</html>
