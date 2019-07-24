<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2019/5/19
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="15">
    <tr>
        <td>编号</td>
        <td>菜名</td>
        <td>口味</td>
        <td>菜品图片</td>
        <td>价格</td>
        <td>菜品描述</td>
    </tr>

        <tr>
            <td>${greens.id}</td>
            <td>${greens.name}</td>
            <td>${greens.taste }</td>
            <td><img src="${greens.url}" alt="" style="width: 100px;height: 100px" ></td>
            <td>${greens.price}</td>
            <td>${greens.descript}</td>
        </tr>

</table >
</body>
</html>
