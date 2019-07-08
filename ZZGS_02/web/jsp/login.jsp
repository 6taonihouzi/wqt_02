<%--
  Created by IntelliJ IDEA.
  User: wqt
  Date: 2019/7/8
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<html>
<head>
    <title>登录页面</title>
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
    </style>
    <script>
        function refreshcode(){
            var vcode = document.getElementById("code");
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time"+new Date().getTime();
        }
    </script>
</head>
<body>
<div class="main">
    <h2>用户登录页面</h2>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/loginServlet">
        <div class="form-group">
            <label for="name">账号</label>
            <input type="text" class="form-control" id="name" placeholder="请输入账号" name="name">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
        </div>
        <div class="form-inline">
            <label for="vscode">验证码:</label>
            <input type="text" name="vscode" class="form-control" id="vscode" placeholder="请输入验证码" autocomplete="off">
            <a href="javascript:refreshcode();"><img height="34px" width="120px" src="${pageContext.request.contextPath}/checkCodeServlet" alt="" title="看不起点击刷新" id="code"></a>
            <br>
        </div>
        <hr>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" style="margin-right: 30px;margin-left: 100px;">登录</button>
            <a href="${pageContext.request.contextPath}/jsp/register.jsp" class="btn btn-success">注册</a>
        </div>
    </form>
    <div class="alert alert-warning alert-dismissable" role="alert">
      <button type="button" class="close" data-dismiss="alert">
          <span>×</span>
      </button>
        <strong style="color: red;">${login_msg}</strong>
    </div>
</div>
</body>
</html>
