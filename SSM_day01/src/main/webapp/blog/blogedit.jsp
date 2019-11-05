<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<script src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("a:contains('删除')").click(function () {
            if(!confirm("确定要删除吗?")){
                return false;
            }
        })
    })
</script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<style>
    table tr td{
        overflow: hidden;
    }
</style>
<body>
<div class="data_list backMain">
    <div class="dataHeader navi">
       博客维护界面
    </div>
    <div class="search_content" style="vertical-align: middle;">
        <form action="../blog/search" method="post">
            新闻标题：<input type="text" id="title" name="title" style="width:180px" value="${title}" autocomplete="off"/>&nbsp;&nbsp;
            &nbsp;&nbsp;      <button class="btn btn-mini btn-primary" type="submit" style="margin-top: -8px;">查询</button>
        </form>
    </div>
    <div class="data_content">
        <table class="table table-hover table-bordered" style="width: 820px;">
            <tr>
                <th style="width: 10px;"><input type="checkbox" id="checkedAll"/></th>
                <th style="width: 45px;">序号</th>
                <th style="width: 60px;">博客标题</th>
                <th style="width: 70px;">博客类别</th>
                <th style="width: 80px;"v>博客内容</th>
                <th style="width: 120px;">操作</th>
            </tr>
            <c:forEach var="blogs" items="${blogs}" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="newsIds" value="${blogs.id}"/></td>
                    <td>${status.index+1 }</td>
                    <td>${blogs.title }</td>
                    <td>${blogs.atitle }</td>
                    <td><p style="height:44px; overflow:hidden;font-size: 14px;">${blogs.content }</p></td>
                    <td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location.href='../blog/link?action=blogadd&id=${blogs.id}'">修改</button>&nbsp;<a style="color: white;" class="btn btn-mini btn-danger" href="../blog/delete?id=${blogs.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <nav aria-label="Page navigation" style="float:right;margin-right: 280px;">
        <ul class="pagination">
            <li>
                <a href="../blog/link" aria-label="Next">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <c:if test="${pageInfo.pageNum == 1}">
                <li class="disabled">
                    <a href="../blog/link" aria-label="Next">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageInfo.pageNum != 1}">
                <li>
                    <a href="../blog/link?page=${pageInfo.pageNum - 1}" aria-label="Next">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
                <c:if test="${pageInfo.pageNum==pageNum}">
                    <li class="active"><a href="../blog/link?page=${pageNum}">${pageNum}</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNum != pageNum}">
                    <li><a href="../blog/link?page=${pageNum}">${pageNum}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                <li class="disabled">
                    <a href="../blog/link?page=${pageInfo.pageNum}" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                <li>
                    <a href="../blog/link?page=${pageInfo.pageNum + 1}" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </c:if>
            <li>
                <a href="../blog/link?page=${pageInfo.pages}" aria-label="Next">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
        </ul>
    </nav></td>
</div>
</body>
</html>