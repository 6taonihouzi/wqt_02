<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>展示页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <style>
        tr,th{
            text-align: center;
        }
        .main{
            width: 1100px;
            margin-left: 120px;
        }
        #show{
           margin-top: 5px;
           margin-right:20px;
        }
        body{
            margin: 0px;
            padding: 0px;
        }
    </style>
    <script>
        $(function(){
            $("a:contains('删除')").click(function(){
                if(!confirm('确定要删除吗')){
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<div class="btn btn-success col-sm-pull-3 pull-right" id="show">欢迎您登录</div>
<form action="${pageContext.request.contextPath}/jsp/add.jsp" style="float: right;margin-right: 20px;margin-top: 5px;" method="get">
    <input type="submit" value="添加联系人" class="btn btn-primary">
</form>
<div class="main">
<table  class="table table-bordered table-hover">
    <caption>用户信息展示</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th colspan="2">操作</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="user">
      <tr>
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.sex}</td>
          <td>${user.age}</td>
          <td>${user.palce}</td>
          <td>${user.ctrate_time}</td>
          <td>${user.modify_time}</td>
          <td><a href="${pageContext.request.contextPath}/editServlet?id=${user.id}" class="btn btn-primary">修改</a></td>
          <td><a href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}" class="btn btn-primary">删除</a></td>
      </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
