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
            font-size: 13px;
            padding: 0;
            margin: 0;
            border: 0;
            height: 100%;
            overflow: hidden;
        }

        .fitem {
            padding: 5px;
        }
    </style>
</head>
<body>
<div id="form" style="width:300px;height:280px;padding:10px 20px">
    <input name="id" class="mini-hidden" value="0"/>
        <div style="padding:5px;text-align:center;">
            <div class="fitem">
                <label>日期：</label>
                <input name="date" name="date" value="${time}" class="mini-datepicker" required="true" emptyText="请选择日期"
                       requiredErrorText="请选择日期"/>
            </div>
            <div class="fitem">
                <label>类型：</label>
                <input id="type" name="type" class="mini-combobox" textField="name" valueField="id" required="true"
                       url="getTypeData?type=${type}" showNullItem="true" allowInput="true" requiredErrorText="请选择类型"
                       emptyText="请选择类型" nullItemText="请选择类型" popupHeight="120"/>

            </div>
            <div class="fitem">
                <label>名称：</label>
                <input id="name" name="name" class="mini-textbox"/>
            </div>
            <div class="fitem">
                <label>金额：</label>
                <input id="money" name="money" class="mini-textbox" required="true" vtype="int"/>
            </div>
        </div>
    <div style="text-align:center;padding:10px;">
        <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
        <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>
    </div>
</div>


<script type="text/javascript">
    mini.parse();

    var action = "";

    var form = new mini.Form("form");

    function SaveData() {
        var o = form.getData(true);

        form.validate();
        if (form.isValid() == false) return;

        $.ajax({
            url: "add",
            type: 'post',
            data: o,
            cache: false,
            success: function (text) {
                if (text == "1") {
                    if (action == "edit") {
                        CloseWindow("cancel");
                    } else {
//                    mini.alert("添加成功！");
                        mini.get("money").setValue("");
                        mini.get("name").setValue("");
                        mini.get("type").setValue("");
                    }
                } else {
                    mini.alert("添加失败！", "失败");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                mini.alert("添加失败！", "失败");
            }
        });
    }

    ////////////////////
    //标准方法接口定义
    function SetData(data) {
        data = mini.clone(data);
        action = data.action;
        if (data.action == "edit") {
            //跨页面传递的数据对象，克隆后才可以安全使用
            form.setData(data.row);
        }
    }

    function GetData() {
        var o = form.getData();
        return o;
    }
    function CloseWindow(action) {
        if (action == "close" && form.isChanged()) {
            if (confirm("数据被修改了，是否先保存？")) {
                return false;
            }
        }
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }
    function onOk(e) {
        SaveData();
    }
    function onCancel(e) {
        CloseWindow("cancel");
    }

</script>
</body>
</html>
