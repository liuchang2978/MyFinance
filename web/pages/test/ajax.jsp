<%--
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/4/5
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="<%=request.getContextPath()%>/scripts/jquery-1.6.2.min.js" type="text/javascript"></script>
    <title></title>
</head>
<body>
    <input type="button" value="testAjax" onclick="ajax();">
</body>
<script type="text/javascript">

    function ajax(){
        $.ajax({
            url:"<%=request.getContextPath()%>/ajax",
            type:"get",
            data:{"name":"liuchang"},
            success:function(data){
                alert(data);
            }
        });
    }
</script>
</html>
