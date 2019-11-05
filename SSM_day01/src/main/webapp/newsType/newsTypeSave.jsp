<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="data_list backMain">
    <div class="dataHeader navi">
       博客类别或修改
    </div>
    <div class="data_content">
        <form action="../background/save" method="post">
            <table cellpadding="5">
                <tr>
                    <td>
                        <label>新闻类别名称：</label>
                    </td>
                    <td>
                        <input type="text" id="title" name="title" value="${blogTypes.title }"/>
                    </td>
                    <td>
                        <label>新闻类别描述：</label>
                    </td>
                    <td>
                        <input type="text" id="description" name="description" value="${blogTypes.description}" placeholder="可不填"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" id="id" name="id" value="${blogTypes.id}"/>
                    </td>
                    <td>
                        <input type="submit" class="btn btn-primary" value="保存新闻类别"/>&nbsp;&nbsp;
                        <input type="button" class="btn btn-primary" value="返回" onclick="javascript:history.back()"/>&nbsp;&nbsp;<font id="error" color="red">${error }</font>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>