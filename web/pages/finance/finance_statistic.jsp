<%--
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/4/13
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="<%=path%>/scripts/boot.js" type="text/javascript"></script>
    <title>支出统计</title>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            border: 0;
            margin: 0;
            padding: 0;
            overflow: visible;
        }
    </style>
</head>
<body>
<div class="mini-fit">
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;" showPager="false">
    </div>
</div>
<script type="text/javascript">
    mini.parse();

    var grid = mini.get("datagrid");

    $(function () {
        $.ajax({
            url: "getData",
            type: "get",
            data: {type: "${type}"},
            dataType: "json",
            success: function (data, status) {
                var columns = new Array();
                var indexcolumn = {width: 20, type: "indexcolumn"};
                columns.push(indexcolumn);

                $.each(data.title, function (index, item) {
                    var column = {};
//                    field="date" width="100" headerAlign="center" align="center" dateFormat="yyyy-MM-dd"
                    column["header"] = item.NAME;
                    column["field"] = item.ID;
                    column["width"] = 80;
                    column["align"] = "center";
                    column["headerAlign"] = "center";
                    if (item.ID == "month") {
                        column["dateFormat"] = "yyyy-MM-dd";
                    }
                    columns.push(column);
                });

                var rowData = data.data;
                grid.set({
                    data: rowData,
                    columns: columns
                });

//                mini.parse();
            }
        });
    });

    grid.on("cellclick", function (e) {
        if (e.field != "month" && e.field != "total" && e.record.month != "合计" && e.record[e.field] != null) {
            var id = e.field.substring(1, e.field.length);
            var url = "finance/toMingxi?id=" + id + "&month=" + e.record.month;
            mini.open({
                url: url,
                title: "明细", width: 650, height: 400
//                onload: function () {
//                    var iframe = this.getIFrameEl();
//                    var data = { action: "add"};
//                    iframe.contentWindow.SetData(data);
//                },
//                ondestroy: function (action) {
//
//                    grid.reload();
//                }
            });
        }
    })
</script>
</body>
</html>
