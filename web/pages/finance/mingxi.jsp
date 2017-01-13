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
    <title>支出统计明细</title>
    <style type="text/css">
        html,body
        {
            width:100%;
            height:100%;
            border:0;
            margin:0;
            padding:0;
            overflow:visible;
        }
    </style>
</head>
<body>
<div class="mini-fit">
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;" showPager="false">
        <div property="columns">
            <div width="20" type="indexcolumn"></div>
            <div field="date" width="100" headerAlign="center" align="center" dateFormat="yyyy-MM-dd" allowSort="true" dataType="date">日期</div>
            <div field="type_name" width="100" headerAlign="center" align="center" allowSort="true">类型</div>
            <div field="name" width="100" headerAlign="center" align="center" allowSort="true">名称</div>
            <div field="money" width="100" headerAlign="center" align="center" allowSort="true" dataType="int">金额</div>
        </div>
    </div>
</div>

<script type="text/javascript">
    mini.parse();
    var grid = mini.get("datagrid");

    var dataJson = '${dataJson}';
    var json = mini.decode(dataJson);

    grid.set({
        data: json
    });

</script>
</body>
</html>
