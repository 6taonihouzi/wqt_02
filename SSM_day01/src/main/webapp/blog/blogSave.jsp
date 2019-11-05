<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="data_list backMain">
    <div class="dataHeader navi">
        博客新增或修改
    </div>
    <div class="data_content">
        <form action="../blog/save" method="post">
            <table cellpadding="5" width="100%">
                <tr>
                    <td width="80px">
                        <label>博客标题：</label>
                    </td>
                    <td>
                        <input type="text" id="title" name="title" class="input-xxlarge" value="${blog.title}" autocomplete="off"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>博客类别：</label>
                    </td>
                    <td>
                        <select id="blogTypeId" name="blogTypeId">
                            <option value="">请选择博客类别</option>
                            <c:forEach var="blogtypes" items="${blogtypes}" begin="1">
                                <option value="${blogtypes.id}" ${blogtypes.id==blog.blogTypeId?'selected' :''}>${blogtypes.title}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td valign="top">
                        <label>博客主题：</label>
                    </td>
                    <td>
                        <textarea class="ckeditor" id="content" name="content" style="resize: none;width: 550px;height: 70px;">${blog.content }</textarea>
                    </td>
                </tr>
                <tr>
                    <td valign="top">
                        <label>博客详细内容：</label>
                    </td>
                    <td>
                        <textarea class="ckeditor" id="contentOne" name="contentOne" style="resize: none;width: 550px;height: 70px;">${blog.contentOne }</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" id="id" name="id" value="${blog.id }"/>&nbsp;
                    </td>
                    <td>
                        <input type="submit" class="btn btn-primary" value="保存新闻"/>&nbsp;&nbsp;
                        <input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>