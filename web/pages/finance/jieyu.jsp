<%--
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/4/12
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="<%=path%>/scripts/boot.js" type="text/javascript"></script>
    <title>结余</title>
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
<div class="mini-fit" >
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;"
         url="jieyuData" idField="id" showPager="false" ondrawcell="drawcell">
        <div property="columns">
             <div type="indexcolumn" width="10"></div>
             <div field="date" width="100" headerAlign="center" align="center" dateFormat="yyyy-MM-dd" allowSort="true">日期</div>
             <div field="shouru" width="100" headerAlign="center" align="center" allowSort="true">收入</div>
             <div field="zhichu" width="100" headerAlign="center" align="center" allowSort="true">支出</div>
             <div field="jieyu" width="100" headerAlign="center" align="center" allowSort="true">结余</div>
        </div>
    </div>
</div>
<script type="text/javascript">
    mini.parse();

    var grid = mini.get("datagrid");
    grid.load();

    function drawcell(e){
        var field = e.field;
        var value = e.value;

        //结余为负，红色标识
        if (field == "jieyu" && value < 0) {
            e.cellStyle = "color:red;font-weight:bold;";
        }
    }
</script>
 </body>
 </html>
