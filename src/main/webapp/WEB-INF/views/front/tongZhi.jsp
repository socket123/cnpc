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
    <script src="${base}/resource/js/account.js"></script>
    <script src="${base}/resource/js/jqueryPage.js"></script>
    <script src="${base}/resource/js/jquery_page.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".flexslider").flexslider({
                slideshowSpeed: 4000, //展示时间间隔ms
                animationSpeed: 40, //滚动时间ms
                touch: true //是否支持触屏滑动
            });

        });
    </script>
    <title>通知公告</title>
</head>
<body class="mainbody">
<div class="mainbody_div_tz">
    <!-- <div class="_top">
        <div class="pull-left _top_div">
            <a>部门电话 : +880 41 723 272</a>
            <a href="mail%40example.html">部门邮箱 : mail@example.com</a>
        </div>
    </div> -->
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


    <div class="main_tz">
        <div class="main_tz_div_hear">
            <p class="main_tz_div_hear_p1"><span class="main_tz_div_hear_span1">通知公告</span></p>
        </div>
        <div class="main_tz_div_footes">
            <ul class="main_tz_div_footes_ul">
                <c:choose>
                    <c:when test="${pages.totalNum>0}">
                        <%--// 每页显示条数--%>
                        <input type="hidden" value="${pages.pageNum}" class="pageNum"/>
                        <%--// 总记录数--%>
                        <input type="hidden" value="${pages.totalNum}" class="totalNum"/>
                        <%--/// 总页数--%>
                        <input type="hidden" value="${pages.totalPage}" class="totalPage"/>
                        <%--// 下一页页码--%>
                        <input type="hidden" value="${pages.nextPage}" class="nextPage"/>
                        <%--// 上一页页码--%>
                        <input type="hidden" value="${pages.previousPage}" class="previousPage"/>
                        <%--当前页页码--%>
                        <input type="hidden" value="${pages.currentIndex}" class="currentIndex"/>

                        <c:forEach items="${pages.dataList}" var="article" varStatus="status">
                            <li class="main_tz_div_footes_li">
                                <p class="main_tz_div_foot_p1">
                                    <a href="Articledetails.html?id=${article.id}" class="main_tz_div_footes_span1">${article.title}</a>
                                </p>
                                <p class="main_tz_div_foot_p2">
                                    <span class="main_tz_div_footes_span2">
                                            ${article.createtime}
                                    </span>
                                </p>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <span>没有文章</span>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="jqueryPage" id="jqueryPage">
        </div>
        <div class="tcdPageCode" id="tcdPageCode">
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





</div>

    <script type="text/javascript">
            var pageNum = $(".pageNum").val();//    每页显示条数
            var totalNum = $(".totalNum").val();// 总记录数
            var totalPage = $(".totalPage").val();// 总页数
            var nextPage = $(".nextPage").val();// 下一页页码
            var previousPage = $(".previousPage").val();// 上一页页码
            var currentIndex = $(".currentIndex").val();// 当前页页码
            if (totalPage == undefined) {
                totalPage = 1;
            }
            if (currentIndex == undefined) {
                currentIndex = 1;
            }
//        pageCount：总页数
//        current：当前页
            $(".tcdPageCode").createPage({
                pageCount:totalPage,
                current:currentIndex,
                backFn:function(p){
                    window.location.href ="tongzhi.html?currentIndex="+p+"";
                }
            });
//        $("#jqueryPage").pagination({
//            count: totalNum, //总数
//            size: 10, //每页数量
//            index: currentIndex,//当前页
//            lrCount: 3,//当前页左右最多显示的数量
//            lCount: 1,//最开始预留的数量
//            rCount: 1,//最后预留的数量
//            callback: function (options) {
//
//            },
//            beforeRender: function (jA) {
//                //jA.attr("href","default.php?index="+jA.text());
//            }
//        });
    </script>

</body>
</html>