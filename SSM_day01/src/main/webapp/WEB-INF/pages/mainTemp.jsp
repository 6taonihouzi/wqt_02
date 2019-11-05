<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
    <meta  charset=UTF-8">
    <title>博客后台管理</title>
    <link href="../css/news.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
    <script src="../js/jQuery.js"/>
    <script src="../js/bootstrap.js"/>
    <script src="../js/ckeditor.js"/>
    <script src="../js/WdatePicker.js"/>
    <%
        String mainPage=(String)request.getAttribute("mainPage");
        if(mainPage==null || mainPage.equals("")){
            mainPage="/background/default.jsp";
        }
    %>
</head>
<body>
<div class="container">
    <jsp:include page="/common/head.jsp"/>
    <div class="row-fluid">
        <div class="span3">
            <div class="newsMenu">
                <ul class="nav nav-tabs nav-stacked">
                    <li><a href="${pageContext.request.contextPath}/background/mainTemp"><strong>主页</strong></a></li>
                    <li><a href=""><strong>博客类别管理</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/background/type?action=typeadd">博客类别添加</a></li>
                    <li><a href="${pageContext.request.contextPath}/background/type?action=typeedit">博客类别维护</a></li>
                    <li><a href=""><strong>博客管理</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/blog/link?action=blogadd">博客添加</a></li>
                    <li><a href="${pageContext.request.contextPath}/blog/link?action=blogedit">博客维护</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <jsp:include page="<%=mainPage %>"/>
        </div>
    </div>
<jsp:include page="/common/foot.jsp"/>
</div>
</body>
</html>