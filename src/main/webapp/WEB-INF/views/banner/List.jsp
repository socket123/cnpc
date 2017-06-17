<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/banner.js"></script>
<div class="page-header userList">
	<h1>
		图片管理
		<input type="hidden" id="type" name="type" value="${type}"/>
		<button class="btn btn-info" id="addTopic" >
		添加图片
		</button>
	</h1>
	
</div>

<div class="table-responsive topicList" id="Banner_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		su.Banner.BannerList.init();
	});
	</script>