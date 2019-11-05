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
        <div class="logo"><a href="/">王泉钛个人博客</a></div>
        <nav>
            <ul id="starlist">
                <li><a href="../index/findAll">${blogtypes[0].title}</a></li>
                <c:forEach items="${blogtypes}" var="blogtypes" begin="1">
                    <li><a href="../list/findList?id=${blogtypes.id}">${blogtypes.title}</a></li>
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
        <!--banbox begin-->
        <div class="banbox">
            <div class="banner">
                <div id="banner" class="fader">
                    <li class="slide" ><a href="#" target="_blank"><img src="../images/1.jpg"></a></li>
                    <li class="slide" ><a href="#" target="_blank"><img src="../images/2.jpg"></a></li>
                    <li class="slide" ><a href="#" target="_blank"><img src="../images/3.jpg"></a></li>
                    <li class="slide" ><a href="#" target="_blank"><img src="../images/4.jpg"></a></li>
                    <div class="fader_controls">
                        <div class="page prev" data-target="prev"></div>
                        <div class="page next" data-target="next"></div>
                        <ul class="pager_list">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--banbox end-->
        <!--headline begin-->
        <div class="headline">
            <ul>
                <li><a href="#" title="为什么说10月24日是程序员的节日？"><img src="../images/h1.jpg" alt="为什么说10月24日是程序员的节日？"><span>为什么说10月24日是程序员的节日？</span></a></li>
                <li><a href="#" title="个人网站做好了，百度不收录怎么办？来，看看他们怎么做的"><img src="../images/h2.jpg" alt="个人网站做好了，百度不收录怎么办？来，看看他们怎么做的。"><span>个人网站做好了，百度不收录怎么办？来，看看他们怎么做的。</span></a></li>
            </ul>
        </div>
        <!--headline end-->
        <div class="clearblank"></div>
        <!--tab_box end-->
        <div class="whitebg bloglist">
            <h2 class="htitle">最新博文</h2>
            <ul>
                <!--单图-->
                <c:forEach items="${pageInfo.list}" var="blog" begin="0" >
                    <li>
                        <h3 class="blogtitle"><a href="../list/findById?id=${blog.id}" >${blog.title}</a></h3>
                        <span class="blogpic imgscale"><i><a href="#">${blog.atitle}</a></i><a href="#" title=""><img src="${blog.img1}" alt=""></a></span>
                        <p class="blogtext">${blog.content}</p>
                        <p class="bloginfo"><i class="avatar"><img src="../images/avatar.jpg"></i><span>全身红17</span><span>2019-08-05</span><span>【<a href="../list/findList?page=1&size=2&id=${blog.blogTypeId}">${blog.atitle}</a>】</span></p>
                        <a href="../list/findById?id=${blog.id}" class="viewmore">阅读更多</a></li>
                </c:forEach>
            </ul>
            <nav aria-label="Page navigation" style="float:right;margin-right: 280px;">
                <ul class="pagination">
                    <li>
                        <a href="../index/findAll?page=1" aria-label="Next">
                            <span aria-hidden="true">首页</span>
                        </a>
                    </li>
                    <c:if test="${pageInfo.pageNum == 1}">
                        <li class="disabled">
                            <a href="../index/findAll?page=1&size=${pageInfo.pageSize}" aria-label="Next">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != 1}">
                        <li>
                            <a href="../index/findAll?page=${pageInfo.pageNum - 1}" aria-label="Next">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
                        <c:if test="${pageInfo.pageNum==pageNum}">
                            <li class="active"><a href="../index/findAll?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != pageNum}">
                            <li><a href="../index/findAll?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                        <li class="disabled">
                            <a href="../index/findAll?page=${pageInfo.pageNum}&size=${pageInfo.pageSize}" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                        <li>
                            <a href="../index/findAll?page=${pageInfo.pageNum + 1}&size=${pageInfo.pageSize}" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="../list/findAll?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">
                            <span aria-hidden="true">尾页</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--bloglist end-->
    </div>
    <div class="rbox">
        <div class="card">
            <h2>我的名片</h2>
            <p>网名：DanceSmile | 即步非烟</p>
            <p>职业：Web前端设计师、网页设计</p>
            <p>现居：四川省-成都市</p>
            <p>Email：dancesmiling@qq.com</p>
            <ul class="linkmore">
                <li><a href="http://www.yangqq.com" target="_blank" class="iconfont icon-zhuye" title="网站地址"></a></li>
                <li><a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=HHh9cn95b3F1cHVye1xtbTJ-c3E" target="_blank" class="iconfont icon-youxiang" title="我的邮箱"></a></li>
                <li><a href="http://wpa.qq.com/msgrd?v=3&uin=476847113&site=qq&menu=yes" target="_blank" class="iconfont icon---" title="QQ联系我"></a></li>
                <li id="weixin"><a href="#" target="_blank" class="iconfont icon-weixin" title="关注我的微信"></a><i><img src="../images/wx.png"></i></li>
            </ul>
        </div>
        <div class="whitebg notice">
            <h2 class="htitle">网站公告</h2>
            <ul>
                <li><a href="#">十条设计原则教你学会如何设计网页布局!</a></li>
                <li><a href="#">用js+css3来写一个手机栏目导航</a></li>
                <li><a href="#">6条网页设计配色原则,让你秒变配色高手</a></li>
                <li><a href="#">三步实现滚动条触动css动画效果</a></li>
            </ul>
        </div>
        <div class="whitebg paihang">
            <h2 class="htitle">点击排行</h2>
            <section class="topnews imgscale"><a href="/"><img src="../images/h1.jpg"><span>6条网页设计配色原则,让你秒变配色高手</span></a></section>
            <ul>
                <li><i></i><a href="#">十条设计原则教你学会如何设计网页布局!</a></li>
                <li><i></i><a href="#">用js+css3来写一个手机栏目导航</a></li>
                <li><i></i><a href="#">6条网页设计配色原则,让你秒变配色高手</a></li>
                <li><i></i><a href="#">三步实现滚动条触动css动画效果</a></li>
                <li><i></i><a href="#">个人博客，属于我的小世界！</a></li>
                <li><i></i><a href="#">安静地做一个爱设计的女子</a></li>
                <li><i></i><a href="#">个人网站做好了，百度不收录怎么办？来，看看他们怎么做的。</a></li>
                <li><i></i><a href="#">做个人博客如何用帝国cms美化留言增加头像选择</a></li>
            </ul>
        </div>
        <div class="whitebg tuijian">
            <h2 class="htitle">站长推荐</h2>
            <section class="topnews imgscale"><a href="/"><img src="../images/h2.jpg"><span>6条网页设计配色原则,让你秒变配色高手</span></a></section>
            <ul>
                <li><a href="#"><i><img src="../images/text01.jpg"></i>
                    <p>十条设计原则教你学会如何设计网页布局!</p>
                </a></li>
                <li><a href="#"><i><img src="../images/text02.jpg"></i>
                    <p>用js+css3来写一个手机栏目导航</p>
                </a></li>
                <li><a href="#"><i><img src="../images/text03.jpg"></i>
                    <p>6条网页设计配色原则,让你秒变配色高手</p>
                </a></li>
                <li><a href="#"><i><img src="../images/text04.jpg"></i>
                    <p>三步实现滚动条触动css动画效果</p>
                </a></li>
                <li><a href="#"><i><img src="../images/text05.jpg"></i>
                    <p>个人博客，属于我的小世界！</p>
                </a></li>
            </ul>
        </div>
    </div>
</article>
<footer>
    <div class="box">
        <div class="wxbox">
            <ul>
                <li><img src="../images/wxgzh.jpg"><span>微信公众号</span></li>
                <li><img src="../images/wx.png"><span>我的微信</span></li>
            </ul>
        </div>
        <div class="endnav">
            <p><b>站点声明：</b></p>
            <p>1、本站个人博客模板，均为杨青青本人设计，个人可以使用，但是未经许可不得用于任何商业目的。</p>
            <p>2、所有文章未经授权禁止转载、摘编、复制或建立镜像，如有违反，追究法律责任。举报邮箱：<a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=HHh9cn95b3F1cHVye1xtbTJ-c3E" target="_blank">dacesmiling@qq.com</a></p>
            <p>Copyright © <a href="http://www.yangqq.com" target="_blank">www.yangqq.com</a> All Rights Reserved. 备案号：<a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a></p>
        </div>
    </div>
    <a href="#">
        <div class="top"></div>
    </a>
</footer>
</body>
</html>

