<!-- 导航栏 start-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
	try{ace.settings.check('breadcrumbs' , 'fixed');}catch(e){}
</script>
	<ul class="breadcrumb" style="line-height: inherit;">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="${base}/index.do">首页</a>
		</li>
		<c:if test="${sessionScope.navMap!= null && fn:length(sessionScope.navMap) > 0}">
			<c:forEach items="${sessionScope.navMap}" var="navmap">
				<c:if test="${navmap.key == 'parentMenu'}">
				<li>
					<a>${navmap.value}</a>
				</li>
				</c:if>
				<c:if test="${navmap.key == 'chlidMenu'}">
					<li class="active">${navmap.value}</li>
				</c:if>
			</c:forEach>
		</c:if>
	</ul>
</div>
<!-- 导航栏 end-->