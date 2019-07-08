<%--
  Created by IntelliJ IDEA.
  User: wqt
  Date: 2019/7/8
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <style>
        .main{
            width: 400px;
            height: 300px;
            margin:0 auto;
            margin-top: 120px;
        }
        h2{
            text-align: center;
        }
        a{
            margin-left: 140px;
            margin-top: 5px;
        }
    </style>
    <script>
        function checkform(){
            if(document.getElementById("name").value == "")
            {
                alert("姓名内容为空");
                return false;
            }
            if(document.getElementById("password").value == "")
            {
                alert("密码内容为空");
                return false;
            }
            if(document.getElementById("Ipassword").value == "")
            {
                alert("确认密码内容为空");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="main">
    <h2>用户注册页面</h2>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/registerServlet" onsubmit="checkform()">
        <div class="form-group">
            <label for="name">账号</label>
            <input type="text" class="form-control" id="name" placeholder="请输入账号" name="name" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="Ipassword">确认密码</label>
            <input type="password" class="form-control" id="Ipassword" placeholder="请输入密码" name="Ipassword" autocomplete="off">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success" style="margin-right: 30px;margin-left: 100px;">提交注册</button>
            <button type="reset" class="btn btn-primary" style="margin-right: 30px;margin-left: 70px;">重置</button>
            <a href="${pageContext.request.contextPath}/jsp/login.jsp" class="btn btn-primary">已有账号，去登录</a>
        </div>
    </form>
    <div class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>×</span>
        </button>
        <strong style="color: red;">${register_msg}</strong>
    </div>
</div>
</body>
</html>
