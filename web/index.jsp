<%--
  Created by IntelliJ IDEA.
  User: liuchang
  Date: 2016/3/30
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <title>系统界面 OutlookTree</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="<%=path%>/scripts/demo.css" rel="stylesheet" type="text/css" />

    <script src="<%=path%>/scripts/boot.js" type="text/javascript"></script>
    <script src="<%=path%>/scripts/core.js" type="text/javascript"></script>
    <style type="text/css">
        body{
            margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
        }
        .header
        {
            background:url(<%=path%>/scripts/header.gif) repeat-x 0 -1px;
        }
        .lijin
        {
            background:url(<%=path%>/scripts/image/lijin.png) no-repeat;width:32px;height:32px;
        }
        .zhichu
        {
            background:url(<%=path%>/scripts/image/zhichu.png) no-repeat;width:32px;height:32px;
        }
        .shouru
        {
            background:url(<%=path%>/scripts/image/shouru.png) no-repeat;width:32px;height:32px;
        }
        .jieyu
        {
            background:url(<%=path%>/scripts/image/jieyu.png) no-repeat;width:32px;height:32px;
        }
        .ztong
        {
            background:url(<%=path%>/scripts/image/tongji.png) no-repeat;width:32px;height:32px;
        }
        .stong
        {
            background:url(<%=path%>/scripts/image/tongji1.png) no-repeat;width:32px;height:32px;
        }
        .ltong
        {
            background:url(<%=path%>/scripts/image/tongji2.png) no-repeat;width:32px;height:32px;
        }
    </style>
</head>
<body>

<!--Layout-->
<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
        <h1 style="margin:0;padding:15px;cursor:default;font-family:微软雅黑,黑体,宋体;">剁手记事本 V2</h1>
        <div style="position:absolute;right:12px;bottom:8px;font-size:12px;line-height:25px;font-weight:normal;">
            皮肤：
            <select id="selectSkin" onchange="onSkinChange(this.value)" style="width:100px;margin-right:10px;" >
                <option value="">Default</option>
                <option value="blue">Blue</option>
                <option value="pure">Pure</option>
                <option value="gray">Gray</option>
                <option value="olive2003">Olive2003</option>
                <option value="blue2003">Blue2003</option>
                <option value="blue2010">Blue2010</option>
                <option value="bootstrap">Bootstrap</option>
                <option value="metro">metro</option>
                <option value="metro-green">metro-green</option>
                <option value="metro-orange">metro-orange</option>
                <option value="jqueryui-cupertino">jqueryui-cupertino</option>
                <option value="jqueryui-smoothness">jqueryui-smoothness</option>
            </select>
            <%--尺寸：--%>
            <%--<select id="selectMode" onchange="onModeChange(this.value)" style="width:100px;" >--%>
                <%--<option value="">Default</option>--%>
                <%--<option value="medium" >Medium</option>--%>
                <%--<option value="large">Large</option>--%>
            <%--</select>--%>
        </div>


    </div>
    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
        <div style="line-height:28px;text-align:center;cursor:default">Copyright © chang&yuan 2016.3 </div>
    </div>
    <div title="center" region="center" style="border:0;" bodyStyle="overflow:hidden;">
        <!--Splitter-->
        <div class="mini-splitter" style="width:100%;height:100%;" borderStyle="border:0;">
            <div size="150" maxSize="250" minSize="100" showCollapseButton="true" style="border:0;">
                <!--OutlookTree-->
                <div class="mini-outlookmenu" url="<%=path%>/scripts/data/outlookmenu.txt" onitemselect="onItemSelect"
                     idField="id" parentField="pid" textField="text"
                >
                </div>

            </div>
            <div showCollapseButton="false" style="border:0;">
                <!--Tabs-->
                <div id="mainTabs" class="mini-tabs" activeIndex="0" style="width:100%;height:100%;"
                     plain="false" onactivechanged="onTabsActiveChanged">
                    <div title="首页" url="" >
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    mini.parse();

    var tree = mini.get("leftTree");

    mini.parse();

    function showTab(node) {
        var tabs = mini.get("mainTabs");

        var id = "tab$" + node.id;
        var tab = tabs.getTab(id);
        if (!tab) {
            tab = {};
            tab.name = id;
            tab.title = node.text;
            tab.showCloseButton = true;
            tab.url = node.url;

            tabs.addTab(tab);
        }
        tabs.activeTab(tab);
    }

    function onItemSelect(e) {
        var item = e.item;
        showTab(item);
    }

    function onClick(e) {
        var text = this.getText();
        alert(text);
    }
    function onQuickClick(e) {
        tree.expandPath("datagrid");
        tree.selectNode("datagrid");
    }

    function onTabsActiveChanged(e) {
        var tabs = e.sender;
        var tab = tabs.getActiveTab();
        if (tab && tab._nodeid) {

            var node = tree.getNode(tab._nodeid);
            if (node && !tree.isSelectedNode(node)) {
                tree.selectNode(node);
            }
        }
    }
</script>

</body>
</html>
