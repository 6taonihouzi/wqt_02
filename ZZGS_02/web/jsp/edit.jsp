<%--
  Created by IntelliJ IDEA.
  User: wqt
  Date: 2019/7/7
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<style>
    .main{
        padding: 0px;
        margin: 0 auto;
        margin-top: 50px;
        width: 350px;
        height: 500px;
    }
    button{
        margin-left: 60px;
    }
    h3{
        text-align: center;
    }
</style>
</head>
<body>
<div class="main">
    <h3><strong>修改联系人页面</strong></h3>
    <form action="${pageContext.request.contextPath}/UpdateServlet" method="post">
        <div class="form-group" style="display: none;">
            <label for="id">id</label>
            <input type="text" name="id" class="form-control" id="id" value="${user.id}">
        </div>
        <div class="form-group">
            <label for="username">姓名</label>
            <input type="text" class="form-control" id="username" placeholder="姓名" name="username" value="${user.name}">
        </div>
        <div class="form-group">
            <label>性别</label>
            <c:if test="${user.sex == '男'}">
                <input type="radio" name="sex" value="男" checked="checked">男
                <input type="radio" name="sex" value="女" >女
            </c:if>
            <c:if test="${user.sex == '女'}">
                <input type="radio" name="sex" value="男" >男
                <input type="radio" name="sex" value="女" checked="checked">女
            </c:if>
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" placeholder="年龄" name="age" value="${user.age}">
        </div>
        <div class="form-group">
            <label for="palce">籍贯</label>
            <input type="text" class="form-control" id="palce" placeholder="籍贯" name="palce" value="${user.palce}">
        </div>
        <div class="form-group">
            <label for="create_time">创建时间</label>
            <input type="text" class="form-control" id="create_time" placeholder="创建时间" name="create_time" value="${user.ctrate_time}">
        </div>
        <div class="form-group">
            <label for="modify_time">修改时间</label>
            <input type="text" class="form-control" id="modify_time" placeholder="修改时间" name="modify_time" value="${user.modify_time}">
        </div>
        <button type="submit" class="btn btn-primary">修改</button>
        <button type="reset" class="btn btn-primary">重置</button>
    </form>
</div>
</body>
</body>
</html>
