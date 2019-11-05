<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery-1.8.3.min.js"></script>
    <title>登录页面</title>
    <script>
     function check() {
         var nameLogin = $("#name_login").val();
         if (nameLogin == "" || nameLogin == null)
         {
             alert("用户名不能为空!");
             return false;
         }
         var passwordLogin = $("#password_login").val();
         if(passwordLogin==""||passwordLogin==null) {
                alert("密码不能为空！");
                return false;
         }
     }
    </script>
    <style>
        .main{
            width:400px;
            height: 300px;
            margin:0 auto;
            margin-top: 120px;
        }
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="main">
    <h2>用户登录页面</h2>
    <form class="form-horizontal" method="post" role="form" onsubmit="return check()" action="/dologin">
        <div class="form-group">
            <label for="name_login">账号</label>
            <input type="text" class="form-control " id="name_login" placeholder="请输入账号" name="name_login" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="name_login">密码</label>
            <input type="password" class="form-control" id="password_login" placeholder="请输入密码" name="password_login">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" style="margin-right: 30px;margin-left: 170px;" >登录</button>
        </div>
    </form>
    <c:if test="${sessionScope.warn != null}">
        <h2 color="red" align="center"><c:out value="${sessionScope.warn}" /></h2>
    </c:if>
</div>
</body>
</html>
