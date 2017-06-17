<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ include file="common/base.jsp" %>--%>
<%@include  file="common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <script src="${base}/resource/js/jquery-1.10.1.min.js"></script>
    <link rel="stylesheet" href="${base}/resource/css/oil.css" />
    <link rel="stylesheet" href="${base}/resource/css/flexslider.css" />
    <link rel="stylesheet" href="${base}/resource/css/oil2s.css" />


    <script src="${base}/resource/js/jquery.easing.min.js"></script>
    <script src="${base}/resource/js/jquery.flexslider-min.js"></script>
    <script src="${base}/resource/js/oil.js"></script>
    <script src="${base}/resource/js/oil2s.js"></script>


    <title>文章详情</title>
</head>
<body class="mainbody">
<div class="mainbody_div_deat">

    <div class="_top1">
        <div class="_top1_div">
            <a href="findex.html">
                <img src="${base}/resource/img/CPNPLOGO.png" width="50" height="50" class="_top1_img">
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



    <div class="main">

        <div class="main_div2_hear">
            <p class="main_div2_hear_p1"><span class="main_div2_hear_span1">常见问题</span></p>
        </div>
        <div class="xqy_main_div1">
            <div class="xqy_main_div1_hear1">
                <span class="xqy_main_div1_hear1_span1">${article.title}</span>
            </div>
            <div class="xqy_main_div1_hear2">
                <div class="xqy_main_div1_hear2_time">
                    <span class="xqy_main_div1_hear2_sapn">${article.createtime}</span>
                </div>
                <div class="xqy_main_div1_hear2_fonsiz">
                    <span class="xqy_main_div1_hear2_sapn yuan">字体大小</span>
                    <span class="xqy_main_div1_hear2_sapn dat"  >大</span>
                    <span class="xqy_main_div1_hear2_sapn zhong" >中</span>
                    <span class="xqy_main_div1_hear2_sapn xiao" >小</span>
                </div>
                <div class="xqy_main_div1_hear2_dayin">
                    <img src="${base}/resource/img/wd.jpg" class="xqy_mainimg"/>
                    <span class="xqy_main_div1_hear2_sapn"><a onclick="javascript:window.print();"  class="xqy_main_div1_hear2_sapn_a" >打印</a></span>
                </div>
            </div>
        </div>
        <div class="xqy_main_div1_hear3">
            <div class="xqeydiv2">
                <!-- <p class="xqeydiv2_pw"> -->
                ${article.content}

                <!-- </p> -->

            </div>

            <div class="xqeyds">
                <p class="xqy_p1">
									<span>${article.createtime}
                                    </span>
                </p>
                <p class="xqy_p2">
									<span>
									来源：
								</span>
                </p>
                <p class="xqy_p3">
									<span>
									责任编辑 :${article.createusername}
								</span>
                </p>
            </div>

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
</body>

<script>

        $(".xqeydiv2>p").css("width","100%");


        $(".dat").click(function(){
            $(".xqeydiv2>p").css("font-size","1.5em");
            $(".xqeydiv2_pw").css("font-size","20px");
            $(".xqeydiv2_pw>span").css("font-size","20px");
        })
        $(".zhong").click(function(){
            $(".xqeydiv2>p").css("font-size","1em");
            $(".xqeydiv2_pw").css("font-size","14px");
            $(".xqeydiv2_pw>span").css("font-size","14px");

        })
        $(".xiao").click(function(){
            $(".xqeydiv2>p").css("font-size","12px");
            $(".xqeydiv2_pw").css("font-size","12px");

            $(".xqeydiv2_pw>span").css("font-size","12px");
        })

</script>




</html>