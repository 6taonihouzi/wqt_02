<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
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
</head>
<body>
<div class="data_list backMain">
    <div class="dataHeader navi">
       >>>博客类别维护
    </div>
    <div class="data_content">
        <table class="table table-hover table-bordered">
            <tr>
                <th>序号</th>
                <th>博客类别名称</th>
                <th>操作</th>
            </tr>
            <c:forEach var="blogtypes" items="${blogTypes}" varStatus="status">
                <tr>
                    <td>${status.index+1 }</td>
                    <td>${blogtypes.title}</td>
                    <td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='../background/type?action=edit&id=${blogtypes.id}'">修改</button>&nbsp;&nbsp;<a style="color: white;" class="btn btn-mini btn-danger" href="../background/delete?id=${blogtypes.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>