<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ include file="common/base.jsp" %>--%>
<%@include  file="common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <script src="${base}/resource/js/jquery-1.10.1.min.js"></script>
    <link rel="stylesheet" href="${base}/resource/css/flexslider.css" />
    <link rel="stylesheet" href="${base}/resource/css/oil.css" />
    <link rel="stylesheet" href="${base}/resource/css/oil2s.css" />
    <script src="${base}/resource/js/jquery.easing.min.js"></script>

    <script src="${base}/resource/js/jquery.flexslider-min.js"></script>
    <script src="${base}/resource/js/oil.js"></script>
    <script src="${base}/resource/js/oil2s.js"></script>

    <title>中国石油软件正版化推广平台</title>
</head>

<body class="mainbody">
<div class="mainbody_div">
    <div class="_top1" >
        <div class="_top1_div" >
            <a href="findex.html">
                <img src="${base}/resource/img/CPNPLOGO.png" width="50" height="50" class="_top1_img"  style="border: 1px solid #3898c2">
                <h2 class="_title">中国石油软件正版化推广平台</h2>
            </a>
        </div>
        <ul class="_top1_ul">
            <li class="current"><a href="findex.html">首页</a></li>

            <li><a href="tongzhi.html" class="sf-with-ul" style="cursor: pointer;">通知公告</a></li>
            <li><a href="newzixun.html" class="sf-with-ul" style="cursor: pointer;">新闻动态</a></li>
            <li><a href="baoming.html" class="sf-with-ul" style="cursor: pointer;">培训计划</a></li>
            <li>
                <a class="" style="cursor: pointer;">产品介绍
                   <span class="sf-sub-indicator">
                   <i class="icon-angle-down "></i>
                   </span>
                </a>
                <ul class="_top1_ul_ul">


                    <c:forEach items="${fronList}" varStatus="" var="fronList">

                      <li><a href="${fronList.menuurl}" class="sf-with-ul">${fronList.menuname}</a></li>


                    </c:forEach>
                </ul>
            </li>
            <li><a class="" href="ziliaofen.html" style="cursor: pointer;">资料共享</a></li>
            <li><a href="changjianWt.html" class="sf-with-ul" style="cursor: pointer;">常见问题</a></li>
            <c:forEach items="${fronListGuan}" varStatus="" var="fronListGuan">

                <li><a href="${fronListGuan.menuurl}" class="sf-with-ul">${fronListGuan.menuname}</a></li>


            </c:forEach>
        </ul>
    </div>

    <div class="maindivEs">
        <div class="main_div1">
            <div class="main">
                <div class="mianc">
                    <div class="flexslider" style="width:100%;margin-top: -10px;">
                        <ul class="slides">
                            <c:choose>
                            <c:when test="${pageBanner.totalNum>0}">
                            <c:forEach items="${pageBanner.dataList}" var="pageBanner" varStatus="status">
                            <li>
                                <img src="${pageBanner.url}"  class="pagebannerimg" />
                            </li>
                            <%--<li><img src="${base}/resource/img/s2.jpg" /></li>--%>
                            <%--<li><img src="${base}/resource/img/s3.jpg" /></li>--%>
                            <%--<li><img src="${base}/resource/img/s4.jpg" /></li>--%>
                            </c:forEach>
                            </c:when>
                                <c:otherwise>
                                    <li>
                                        <span>没有图片</span>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="main_div2">
            <div class="main_div2_hear">
                <p class="main_div2_hear_p1"><span class="main_div2_hear_span1">培训计划</span></p>
                <p class="main_div2_hear_p2"><a href="baoming.html" class="main_div2_hear_a1">查看更多></a></p>
            </div>
            <div class="main_div2_foot">
                <ur >
                    <c:choose>
                    <c:when test="${pagesAxtivit.totalNum>0}">
                    <c:forEach items="${pagesAxtivit.dataList}" var="pagesAxtivit" varStatus="status">
                    <li class="main_div2_foot_li">
                        <p class="main_div2_foot_p1"><a href="baoming.html"  class="main_div2_foot_span1">${pagesAxtivit.activityename}</a></p>
                        <p class="main_div2_foot_p2"><span class="main_div2_foot_spantime">${pagesAxtivit.createtime}</span></p>
                    </li>
                    </c:forEach>
                    </c:when>
                        <c:otherwise>
                            <li>
                                <span>没有文章</span>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ur>
            </div>
        </div>
        <div class="main_div3">
            <div class="main_div3_hear">
                <p class="main_div3_hear_p1"><span class="main_div3_hear_span1">通知公告</span></p>
                <p class="main_div3_hear_p2"><a href="tongzhi.html" class="main_div3_hear_a1">查看更多></a></p>
            </div>
            <div class="main_div3_foot">
                <ur >
                    <c:choose>
                    <c:when test="${pages.totalNum>0}">
                        <c:forEach items="${pages.dataList}" var="article" varStatus="status">
                    <li class="main_div3_foot_li">
                        <p class="main_div3_foot_p1"><a href="Articledetails.html?id=${article.id}"  class="main_div3_foot_span1">${article.title}</a></p>
                        <p class="main_div3_foot_p2"><span class="main_div3_foot_spantime">${article.createtime}</span></p>
                    </li>
                        </c:forEach>
                    </c:when>
                        <c:otherwise>
                            <li>
                                <span>没有文章</span>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ur>
            </div>
        </div>
        <div class="main_div3">
            <div class="main_div3_hear">
                <p class="main_div3_hear_p1"><span class="main_div3_hear_span1">新闻动态</span></p>
                <p class="main_div3_hear_p2"><a href="newzixun.html" class="main_div3_hear_a1">查看更多></a></p>
            </div>
            <div class="main_div3_foot">
                <ur >
                    <c:choose>
                    <c:when test="${pagesnew.totalNum>0}">
                    <c:forEach items="${pagesnew.dataList}" var="articlenew" varStatus="status">
                    <li class="main_div3_foot_li">
                        <p class="main_div3_foot_p1"><a href="newAcdetails.html?id=${articlenew.id}"  class="main_div3_foot_span1">${articlenew.title}</a></p>
                        <p class="main_div3_foot_p2"><span class="main_div3_foot_spantime">${articlenew.createtime}</span></p>
                    </li>
                    </c:forEach>
                    </c:when>
                        <c:otherwise>
                            <li>
                                <span>没有文章</span>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ur>
            </div>
        </div>
        <div class="main_div4">

            <div class="main_div4_hear">
                <p class="main_div4_hear_p1"><span class="main_div4_hear_span1">动态新闻</span></p>
                <p class="main_div4_hear_p2"><a href="newzixun.html" class="main_div4_hear_a1">查看更多></a></p>
            </div>
            <div class="main">
                <div class="mianc">
                    <div class="flexslider" style="width:98%;height: 200px;" id="flexsliderdiv">
                        <ul class="slides">
                            <c:choose>
                            <c:when test="${pageBannerZB.totalNum>0}">
                            <c:forEach items="${pageBannerZB.dataList}" var="pageBannerZB" varStatus="status">
                            <li><img src="${pageBannerZB.url}" class="main_div4_imgs"/></li>
                            <%--<li><img src="${base}/resource/img/s2.jpg" class="main_div4_imgs"/></li>--%>
                            <%--<li><img src="${base}/resource/img/s3.jpg" class="main_div4_imgs"/></li>--%>
                            <%--<li><img src="${base}/resource/img/s4.jpg" class="main_div4_imgs"/></li>--%>
                            </c:forEach>
                            </c:when>
                                <c:otherwise>
                                    <li>
                                        <span>没有图片</span>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>


                </div>
            </div>
        </div>

        <div class="main_div5 nomarginLeft">
            <div class="main_div5_hear">
                <img src="${base}/resource/img/wps.png" alt="wps" class="main_div5_hear_img1"/>
                <p class="main_div5_hear_p1"><span class="main_div5_hear_span1">WPS产品</span></p>
                <p class="main_div5_hear_p2"><a href="findex.html" class="main_div5_hear_a1">查看更多></a></p>
            </div>
            <%--<div class="main_div5_foots">--%>
                <%--<ul class="main_div5_footul">--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/wd.jpg" class="main_div5_footli_img"/>--%>
                        <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/ditu.jpg" class="main_div5_footli_img"/>--%>
                        <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/zxt.jpg" class="main_div5_footli_img"/>--%>
                            <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>

        <div class="main_div5 ">
            <div class="main_div5_hear">
                <img src="${base}/resource/img/weiruans.jpg" alt="wps" class="main_div5_hear_img1"/>
                <p class="main_div5_hear_p1"><span class="main_div5_hear_span1">微软产品</span></p>
                <p class="main_div5_hear_p2"><a href="findex.html" class="main_div5_hear_a1">查看更多></a></p>
            </div>
            <%--<div class="main_div5_foots">--%>
                <%--<ul class="main_div5_footul">--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/yj.jpg" class="main_div5_footli_img"/>--%>
                            <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/jsb.jpg" class="main_div5_footli_img"/>--%>
                            <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                        <%--<img src="${base}/resource/img/jsb2.jpg" class="main_div5_footli_img"/>--%>
                            <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>


        <div class="main_div5 ">
            <div class="main_div5_hear">

                <img src="${base}/resource/img/oracle_proc.jpg" alt="wps" class="main_div5_hear_img1"/>
                <p class="main_div5_hear_p1"><span class="main_div5_hear_span1">oracle产品</span></p>
                <p class="main_div5_hear_p2"><a href="findex.html" class="main_div5_hear_a1">查看更多></a></p>
            </div>
            <%--<div class="main_div5_foots">--%>
                <%--<ul class="main_div5_footul">--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                            <%--<img src="${base}/resource/img/yyq.jpg" class="main_div5_footli_img"/>--%>
                        <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                            <%--<img src="${base}/resource/img/gwb.jpg" class="main_div5_footli_img"/>--%>
                        <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                    <%--<li class="main_div5_footli">--%>
                        <%--<div class="imgcalssindex">--%>
                            <%--<img src="${base}/resource/img/wd.jpg" class="main_div5_footli_img"/>--%>
                        <%--</div>--%>
                        <%--<p class="main_div5_footli_p1">--%>
                            <%--<a href="" class="main_div5_footli_a"><writer>Wirite:最适合中文创作的先进文字工具，强大图文排版，丰富的在线资源库</writer></a>--%>
                        <%--</p>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
        </div>
    <div class="clear"></div>
    <div class="foot_erld">
        <p class="foot_erld_p1">
                <span class="foot_erld_span1">
                   ©&nbsp;1998-2016 &nbsp;中国石油天然气集团公司&nbsp;版权所有&nbsp;|&nbsp;法律声明
                </span>
        </p>
        <p class="foot_erld_p2">
            <span class="foot_erld_span2">技术支持:</span>
            <span class="foot_erld_span2">中国石油信息技术服务中心</span>&nbsp;
            <span class="foot_erld_span2">京ICP证:010289&nbsp;|</span>&nbsp;
            <span class="foot_erld_span2">京公网安备:110401400007</span>&nbsp;

        </p>
    </div>



</div>
<script type="text/javascript">
        $(".flexslider").flexslider({
            slideshowSpeed: 4000, //展示时间间隔ms
            animationSpeed: 40, //滚动时间ms
            touch: true //是否支持触屏滑动
        });

</script>

</body>




</html>