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
    <%--<link rel="stylesheet" href="${base}/resource/css/jquery.monthpicker.css" />--%>
    <script src="${base}/resource/js/jquery.easing.min.js"></script>
    <script src="${base}/resource/js/jquery.flexslider-min.js"></script>
    <script src="${base}/resource/js/oil.js"></script>
    <script src="${base}/resource/js/oil2s.js"></script>
    <script src="${base}/resource/js/account.js"></script>
    <script src="${base}/resource/js/jqueryPage.js"></script>
    <script src="${base}/resource/js/jquery_page.js"></script>
    <%--<script src="${base}/resource/js/jquery.monthpicker.js"></script>--%>


    <script type="text/javascript">
//                $(function() {
//                    $('#monthly').monthpicker({
//                        years: [2015, 2014, 2013, 2012, 2011],
//                        topOffset: 0
//                    })
//
//                });
    </script>
    <script type="text/javascript">


    </script>
    <title>培训计划</title>
</head>
<body class="mainbody">
<div class="_mainbody_div_tz">

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
        <div class="bomans_div_hear">
            <p class="main_tz_div_hear_p1"><span class="main_tz_div_hear_span1">培训计划</span></p>
        </div>

        <div class="baoming_main_div_1">

            <div class="baoming_main_div_1_hera">
                <ul class="baoming_main_div_1_hera_ul">
                    <li class="baoming_main_div_1_hera_li sdeefd">
                        <span class="baoming_main_div_1_hera_sapn ">课程名称</span>
                    </li>
                    <li class="baoming_main_div_1_hera_li  boamengcontent">
                        <span class="baoming_main_div_1_hera_sapn">课程介绍</span>
                    </li>
                    <li class="baoming_main_div_1_hera_li sdefs">
                        <span class="baoming_main_div_1_hera_sapn">操作</span>
                    </li>
                </ul>
            </div>

            <!--表-->
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



                    <c:forEach items="${pages.dataList}" var="Activity" varStatus="pages">



            <c:if test="${fn:length(Activity.activityename)<15 }">
                         <div class="baoming_main_div_1_foote  ">
                             </c:if>


                             <c:if test="${fn:length(Activity.activityename)>20 }">
                                 <div class="baoming_main_div_1_foote  lcseds">
                             </c:if>
                            <ul class="baoming_main_div_1_foote_ul">
                                <li class="baoming_main_div_1_foote_li sdeefd" style="display:inline;">

                                    <a class="baoming_main_div_1_foote_a1 "  title="${Activity.activityename}" >
                                        <p class="sped">  ${Activity.activityename}</p>
                                           <%--<c:if test="${fn:length(Activity.activityename)>10 }">--%>
                                               <%--${Activity.activityename}--%>
                                           <%--</c:if>--%>
                                           <%--<c:if test="${fn:length(Activity.activityename)<=10 }">--%>
                                               <%--${Activity.activityename}--%>
                                           <%--</c:if>--%>

                                    </a>
                                    <input type="hidden" class="" name="" value="${Activity.id}"/>
                                    <input type="hidden" class="" name="" value="${Activity.teacher}">
                                </li>
                                <li class="baoming_main_div_1_foote_li boamengcontentssed" style="display:inline;">

                                    <a class="baoming_main_div_1_foote_a1 contexts"
                                        href="javascript:void(0);" data = "">

                                        <c:if test="${fn:length(Activity.countactive)>30 }">
                                            ${fn:substring(Activity.countactive, 0, 30)}......
                                        </c:if>
                                        <c:if test="${fn:length(Activity.countactive)<=30 }">
                                            ${Activity.countactive}
                                        </c:if>

                                    </a>
                                    <div style="display: none">${Activity.content}</div>

                                </li>
                                <li class="baoming_main_div_1_foote_li sdefs">

                                    <span class="baoming_main_div_1_foote_a1 baomingssa" onclick="dinjie(${Activity.id},&quot;${Activity.activityename}&quot;,&quot;${Activity.teacher}&quot; )"  >申请</span>
                                </li>
                            </ul>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <li>
                        <span>没有文章</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </div>


    </div>

    <!--弹窗 -->
    <div class="baoming_tanchuang_count" style="display: none; overflow: auto;">



    </div>
    <!--弹窗 -->
    <div class="baoming_tanchuang" style="display: none;">
        <div class="baoming_tanchuang_shenqing">
            <span class="baoming_tanchuang_span">课程申请</span>
        </div>
        <form action="baomingtijiao.html" method="post" id="edform" class="edform">
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">课程名称：</p>
                <input type="hidden" value="" name="actId" class="zhujingid" />
                <input type="text" value=""  class="zhujiangkc"  placeholder=""   disabled="disabled"/>
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">申请人：</p>
                <input type="text" value="" class="shenqr" placeholder="申请人信息填写" name="username" />
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">申请单位：</p>
                <input type="text" value="" placeholder="请填写申请单位"  class="company" name="company"  />
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">上课地点：</p>
                <input type="text" value="" placeholder=""  class="teacher" name="teacher"   disabled="disabled" />
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">上课时间：</p>
                <%--<input type="text" value="" class="" placeholder="时间格式yyyy-mm-dd" name="jointime" id="sctimes"/>--%>
                <select  id="sctimes">

                </select>
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">联系方式: </p>
                <input type="text" value="" class="lianxifangshi" placeholder="填写联系方式" name="phone"/>
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">邮箱: </p>
                <input type="text" value="" class="email" placeholder="填写邮箱" name="email"/>
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">报名人数: </p>
                <input type="text" value="" class="number" placeholder="填写报名人数" name="number"/>
            </div>
            <div class="baoming_tanchuang_div1">
                <p class="baoming_tanchuang_mingcehng">随机码: </p>
                <input type="text" value="" class="randomcode" placeholder="填写随机码" name="randomcode"/>
            </div>

            <div class="sutijiao">
                <input type="button" name="" id="" value="取消"  class="sunds"/>
                <input type="button" name="" class="quxiao" value="提交" />

            </div>
        </form>
    </div>
    <!--背景阴影 -->
    <div class="zhihui" style="display: none;" >

    </div>

    <div class="page_baoming">
        <div class="tcdPageCode" id="tcdPageCode">
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
/*${Activity.id},&quot;${Activity.activityename}&quot;*/
        $(".baoming_tanchuang").hide();
        $(".zhihui").hide();
console.log(document.body.scrollHeight);
$(".zhihui").css("height",document.body.scrollHeight+"px");
        



        

        $(".contexts").click(function () {

            xianshisss($(this).next().html());
        })



            function   xianshisss (name) {
                $(".baoming_tanchuang_count").show();
                $(".zhihui").show();
                $(".baoming_tanchuang_count").html(name);

            }



            /**点击申请
             * */
                function  dinjie(id,name,teachers) {
                    $(".baoming_tanchuang").show();
                    $(".zhihui").show();
                    $(".zhujingid").val(id);//id

                    var zhujiankc = $(".zhujiangkc");
                    zhujiankc.val(name);
                      yueFengxianshi(id);
                var teacher =  $(".teacher");
                teacher.val(teachers);
                    $(".shenqr").val("");
                    $(".lianxifangshi").val("");
                    $("#sctimes").val("");
                    $(".company").val("");
                    $(".email").val("");
                    $(".randomcode").val("");
                    $(".number").val("");

                }
            function isEmail(str){
                var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
                return reg.test(str);
            }

        /**月份显示
         * */
        function yueFengxianshi (id) {
            var html_1 ="";
            $.ajax({
                type: "post",
                dataType: "json",
                url: "baomingtijiatime.html",
                data: {
                    id:id
                },
                success: function (o) {
//                    alert(o);
                    for(var i = 0 ; i < o.rCode.length ; i ++){
                        html_1 += ' <option value="'+ o.rCode[i]+'">'+ o.rCode[i]+'</option>';
                    }
//                    alert(html_1);
                   $("#sctimes").append(html_1);
                }
            });
        }
        // 点击事件 隐藏报名
        $(".zhihui").click(function(){
            $(".baoming_tanchuang_count").hide();
            $(".baoming_tanchuang").hide();
            $(".zhihui").hide();
            $("#sctimes").empty();
        })
//				quxiao
        // 点击事件取消  隐藏报名页面
        $(".sunds").click(function(){
            $(".baoming_tanchuang_count").hide();
            $(".baoming_tanchuang").hide();
            $(".zhihui").hide();
            $("#sctimes").empty();
        })

        $(".quxiao").click(function(){
            var shenqr = $(".shenqr").val();
            var zhujingid = $(".zhujingid").val();
            var lianxifangshi = $(".lianxifangshi").val();
            var sctimes =  $("#sctimes").val();
            var company =  $(".company").val();
            var email=$(".email").val();
            var number = $(".number").val();//报名人数
            var randomcode =$(".randomcode").val();//随机码
            var id = $(".zhujingid").val();//
            var reg=/^\d+$/;
            if(shenqr == null || shenqr == ""){
                alert("申请人不能为空");
                return false;
            }else if(lianxifangshi == null || lianxifangshi == ""){
                alert("联系方式不能为空");
                return false;

            }else if(sctimes == null || sctimes == ""){
                alert("申请时间不能为空");
                return false;
            }else if(company == null || company == ""){
                alert("申请单位不能为空");
                return false;
            }else if(email==null || email==""){
                alert("申请邮箱不能为空");
                return false;
            }
            else if(!isEmail(email)){
                    alert("输入正确的邮箱");
                    return false;
            }
            else if(number == null || number == ""){
                    alert("输入报名人数");
                    return false;
            }else if(!reg.test(number)){
                alert("输入格式错误");
                return false;
            }
            else if(randomcode == null || randomcode == ""){
                    alert("输入随机码");
                    return false;
            }
            var flag = null;
            $.ajax({
                type: "post",
                dataType: "json",
                url: "randomcodeActions.html",
                data: {
                    id:id,
                    randomcode:randomcode
                },
                success: function (o) {
                    alert(o);
                    if(o == true){
                        sumbiet(shenqr,zhujingid,lianxifangshi,sctimes,company,email,number,randomcode,id);
                    }else {
                        flag = false;
                        alert("随机码不正确");
                    }
                }
            });
//                if (flag){
//                    sumbiet(shenqr,zhujingid,lianxifangshi,sctimes,company,email,number,randomcode,id);
//                }
//            $("#edform").submit();
        });

        <%--var message = '${message}';--%>
        <%--if(message == 1){--%>
            <%--alert("报名成功");--%>
        <%--}--%>

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
                window.location.href ="baoming.html?currentIndex="+p+"";
            }

    });

/**
 * 提交数据
 */
function sumbiet(shenqr,zhujingid,lianxifangshi,sctimes,company,email,number,randomcode,id) {
    $.ajax({
        type: "post",
        dataType: "json",
        url: "baomingtijiaoActions.html",
        data: {
            actId:zhujingid,
            username:shenqr,
            phone:lianxifangshi,
            jointime:sctimes,
            email:email,
            company:company,
            number:number,
            randomcode:randomcode
        },
        success: function (o) {
            if(o == true){
                alert("报名成功");
                $(".baoming_tanchuang").hide();
                $(".zhihui").hide();
                $("#sctimes").empty();
                return false;
            }else {
                alert("报名失败");
                return false;
            }
        }
    });
}
    /**
     * 判断随机数
     */
    function ajaxromande(id,randomcode,flag) {
        $.ajax({
            type: "post",
            dataType: "json",
            async: false,   // 同步为false
            url: "randomcodeActions.html",
            data: {
                id:id,
                randomcode:randomcode
            },
            success: function (o) {
                if(o == "true"){
                }else {
                    alert("随机码不正确");
                    return false;
                }
            }
        });
        }
</script>
<%--<script src="${base}/resource/js/time/datetime.js"></script>--%>
</body>
</html>