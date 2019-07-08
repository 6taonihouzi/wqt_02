<%--
  Created by IntelliJ IDEA.
  User: wqt
  Date: 2019/7/7
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
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
  <h3><strong>添加联系人页面</strong></h3>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
    <div class="form-group">
        <label for="username">姓名</label>
        <input type="text" class="form-control" id="username" placeholder="姓名" name="username">
    </div>
    <div class="form-group">
        <label>性别</label>
        <input type="radio" name="sex" value="男" checked="checked">男 <input type="radio" name="sex" value="女">女
    </div>
    <div class="form-group">
        <label for="age">年龄</label>
        <input type="text" class="form-control" id="age" placeholder="年龄" name="age">
    </div>
    <div class="form-group">
        <label for="palce">籍贯</label>
        <input type="text" class="form-control" id="palce" placeholder="籍贯" name="palce">
    </div>
    <div class="form-group">
        <label for="create_time">创建时间</label>
        <input type="text" class="form-control" id="create_time" placeholder="创建时间" name="create_time">
    </div>
    <div class="form-group">
        <label for="modify_time">修改时间</label>
        <input type="text" class="form-control" id="modify_time" placeholder="修改时间" name="modify_time">
    </div>
    <button type="submit" class="btn btn-primary">提交</button>
    <button type="reset" class="btn btn-primary">重置</button>
</form>
</div>
</body>
</html>
