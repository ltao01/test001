<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

   <c:forEach    items="${pageInfo.list}" var="gs" >

            <tr>
                <td>${gs.id}</td>
                <td>${gs.name}</td>
               <td>${gs.taste }</td>
                <td><img src="${gs.url}" alt="" style="width: 100px;height: 100px" ></td>
                <td>${gs.price}</td>
                <td>${gs.descript}</td>
            </tr>
       </c:forEach>
</table >

<table border="1" cellspacing="5" cellpadding="10">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${pageInfo.pageNum-1})">上一页</a></td>
        <c:forEach begin="1" var="i" end="${pageInfo.pages}"> <%--pages  count size  pageNum--%>
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${pageInfo.pageNum+1})">下一页</a></td>
        <td><a href="javascript:goPage(${pageInfo.pages})">尾页</a></td>
        <td>
            <a href="javascript:toPage()">跳转</a>到第<input type="text" id="go" value="${pageInfo.pageNum}" size="2">页
        </td>
    </tr>
</table>

</body>
<script>
    function goPage(page) {//1.接受到的page 赋值给 form中的隐藏表单 2.提交表单
        location.href="/search?pageNum="+page
    }

    function toPage() {
        var page=$("#go").val();
        goPage(page)
    }



</script>
</html>
