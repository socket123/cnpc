<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/activity.js"></script>
<div class="page-header userList">
	<h1>
	活动列表
		<button class="btn btn-info" id="addTopic" >
		新增活动
		</button>
	</h1>
	
</div>

<div class="table-responsive topicList" id="Activity_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		su.activity.ActivityList.init();;
	});
	</script>