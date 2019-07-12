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
    <c:forEach items="${pb.list}" var="user">
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
<nav aria-label="Page navigation" style="text-align: center;">
    <ul class="pagination">
    <c:if test="${pb.currentpage==1}">
        <li class="disabled">
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${pb.currentpage}&rows=5" aria-label="Previous">
                <span aria-hidden="true">上一页</span>
            </a>
        </li>
    </c:if>
    <c:if test="${pb.currentpage!=1}">
        <li>
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${pb.currentpage-1}&rows=5" aria-label="Previous">
                <span aria-hidden="true">上一页</span>
            </a>
        </li>
    </c:if>
        <c:forEach begin="1" end="${pb.totalpage}" var="i">
            <c:if test="${pb.currentpage == i}">
                <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${pb.currentpage != i}">
                <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${i}&rows=5">${i}</a></li>
            </c:if>
        </c:forEach>
     <c:if test="${pb.currentpage == pb.totalpage}">
            <li class="disabled">
                <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${pb.currentpage}&rows=5" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
     </c:if>
     <c:if test="${pb.currentpage!=pb.totalpage}">
            <li>
                <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentpage=${pb.currentpage+1}&rows=5" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</html>
