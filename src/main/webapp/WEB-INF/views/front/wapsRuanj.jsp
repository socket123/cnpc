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

    <!--   <script type="text/javascript">
          $(function() {
              $(".flexslider").flexslider({
                  slideshowSpeed: 4000, //展示时间间隔ms
                  animationSpeed: 40, //滚动时间ms
                  touch: true //是否支持触屏滑动
              });

          });
      </script> -->
    <title>软件详情</title>
</head>
<body class="mainbody">
<div class="mainbody_div_wps_chan">

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
        <div class="main_xw_left">




                                        <div class="">
                                                ${articles.content}
                                        </div>
                        <c:if test="${articles == null}">
                                没有文章
                        </c:if>



        </div>

        <div class="main_xw_right">

            <div class="main_xw_right_div1">
                <ul>
                    <li class="main_xw_right_div1_li">
                        <img src="${base}/resource/img/jsb2.jpg" class="main_xw_right_div1_img"/>
                        <p class="main_xw_right_div1_p1">
                            <a href="ziliaofen.html"  class="main_xw_right_div1_span1">产品资料</a>
                        </p>
                    </li>
                    <li class="main_xw_right_div1_li">
                        <img src="${base}/resource/img/wd.jpg" class="main_xw_right_div1_img"/>
                        <p class="main_xw_right_div1_p1">
                            <a href="changjianWt.html" class="main_xw_right_div1_span1">常见问题</a>
                        </p>
                    </li>
                </ul>
            </div>

            <div class="main_xw_right_div2">
                <div class="main_xw_right_div2_hear">
                    <p class="main_xw_right_div2_p1">
                        <span class="main_xw_right_div2_span1">友情链接</span>
                    </p>
                </div>
                <div class="main_xw_right_div2_foot">
                    <ul class="main_xw_right_div2_foot_ul">
                        <li class="main_xw_right_div2_foot_li">
                            <p class="main_xw_right_div2_foot_p1">
                                <a href="http://www.cnpc.com.cn/cnpc/index.shtml" class="main_xw_right_div2_foot_span">中国石油集团公司</a>
                            </p>
                        </li>
                        <li class="main_xw_right_div2_foot_li">
                            <p class="main_xw_right_div2_foot_p1">
                                <a href="http://www.petrochina.com.cn/" class="main_xw_right_div2_foot_span">中国石油股份有限公司</a>
                            </p>
                        </li>
                        <li class="main_xw_right_div2_foot_li">
                            <p class="main_xw_right_div2_foot_p1">
                                <a href="http://bgp.cnpc.com.cn/" class="main_xw_right_div2_foot_span">东方地球物理勘探有限责任公司</a>
                            </p>
                        </li>

                    </ul>
                </div>
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



</html>