<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2019/5/19
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.form.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align="center">添加菜品</h1>
<form action="/update" method="post"  id="myform1">
    <table border="1" align="center" >
        <tr><td>
            编号:</td><td><input type="text" name="id" value="">
            </td>
        </tr>
        <tr><td>
            菜品:</td><td><input type="text" name="name" value="">
            </td>
        </tr>
        <tr> <td>口味：</td>
            <td><input type="radio" name="taste" value="香辣">香辣
                <input type="radio" name="taste" value="微辣">微辣
                <input type="radio" name="taste" value="不辣">不辣
            </td></tr>
        <tr> <td> 菜品图片：</td>

            <td>
                <input type="file" name="bigHeadImg" onchange="upload()">
                <img src="" alt="大头贴" id="img1" style="width:100px;height:100px">
                <input type="hidden" name="url" id="url1" value="">
            </td></tr>

        <tr> <td> 价格：</td>
            <td><input type="text" name="price" value=""></td></tr>
        <tr> <td>菜品描述：</td>
            <td><input type="text" name="descript" value=""></td></tr>
        <tr> <td colspan="2" align="center">
            <input type="submit" value="提交">
            <input type="reset" value="重置"></td></tr>
    </table>
</form>
</body>
<script>
    function upload() {
        //  alert(1321)
        //1.ajax去 后台 上传 图片  2.回调函数中取出 相对路径
        var $form={//文件上传ajax
            type:'post',
            url:'/upload',
            dataType:'json',//期待服务器返回json格式数据
            success:function (data) {
                $("#img1").attr("src",data.url);//回显
                $("#url1").val(data.url);//新增 url
            }
        };

        $("#myform1").ajaxSubmit($form);

    }
</script>
</body>
</html>
