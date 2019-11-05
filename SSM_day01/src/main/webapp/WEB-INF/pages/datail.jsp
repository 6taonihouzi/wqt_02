<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页-王泉钛个人博客模板主题《今夕何夕》</title>
    <meta name="keywords" content="blog" />
    <meta name="description" content="blog" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/m.css" rel="stylesheet">
    <script src="../js/jquery-1.8.3.min.js" ></script>
    <script src="../js/comm.js"></script>
    <!--[if lt IE 9]-->
    <script src="../js/modernizr.js"></script>
    <!--[endif]-->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!--top begin-->
<header id="header">
    <div class="navbox">
        <h2 id="mnavh"><span class="navicon"></span></h2>
        <div class="logo"><a href="http://www.yangqq.com">杨青青个人博客</a></div>
        <nav>
            <ul id="starlist">
                <li><a href="../index/findAll">${blogtypes[0].title}</a></li>
                <c:forEach items="${blogtypes}" var="blogtypes" begin="1">
                    <li><a href="../list/findList?page=1&size=2&id=${blogtypes.id}">${blogtypes.title}</a></li>
                </c:forEach>
            </ul>
        </nav>
        <div class="searchico"></div>
    </div>
</header>
<div class="searchbox">
    <div class="search">
        <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
            <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字词" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}" type="text">
            <input name="show" value="title" type="hidden">
            <input name="tempid" value="1" type="hidden">
            <input name="tbname" value="news" type="hidden">
            <input name="Submit" class="input_submit" value="搜索" type="submit">
        </form>
    </div>
    <div class="searchclose"></div>
</div>
<!--top end-->
<article>
    <!--lbox begin-->
    <div class="lbox">
        <div class="content_box whitebg">
            <h2 class="htitle"><span class="con_nav">您现在的位置是：<a href="#">网站首页</a>><a href="#">个人博客模板</a></span>个人博客模板</h2>
            <h1 class="con_tilte">个人博客，属于我的小世界！</h1>
            <p class="bloginfo"><i class="avatar"><img src="../images/avatar.jpg"></i><span>杨青青</span><span>2018-10-28</span><span>【<a href="#">程序人生</a>】</span><span>${blogs.browse}次浏览量</span></p>
            <p class="con_info"><b>简介</b>个人博客，用来做什么？我刚开始就把它当做一个我吐槽心情的地方，也就相当于一个网络记事本，写上一些关于自己生活工作中的小情小事，也会放上一些照片，音乐。每天工作回家后就能访问自己的网站，一边听着音乐，一边写写文章。</p>
            <div class="con_text">
                ${blogs.contentOne}
                <p class="share">
                <div class="nextinfo">
                <c:if test="${blogs.id == 1}">
                   <p>上一篇：<a href="../list/findById?id=1" class="disabled">这已经是第一篇了</a></p>
                   <p>下一篇：<a href="../list/findById?id=${blogs1[0].id}">${blogs1[0].title}</a></p>
                </c:if>

                <c:if test="${blogs.id != 1}">
                    <p>上一篇：<a href="../list/findById?id=${blogs1[0].id}" class="active">${blogs1[0].title}</a></p>
                </c:if>
                <c:if test="${blogs.id != 16 && blogs.id !=1}">
                    <p>下一篇：<a href="../list/findById?id=${blogs1[1].id}">${blogs1[1].title}</a></p>
                </c:if>

                <c:if test="${blogs.id == 16}">
                    <p>下一篇：<a href="../list/findById?id=16" class="disabled">这已经是最后篇了</a></p>
                </c:if>
                </div>
            </div>
        </div>
    </div>
    <!--lbox end-->
</article>
</body>
</html>
