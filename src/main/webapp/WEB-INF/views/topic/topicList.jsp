<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/topic.js"></script>
<div class="page-header userList">
	<h1>
	分类列表
		<button class="btn btn-info" id="addTopic" >
		添加分类
		</button>
	</h1>
	
</div>

<div class="table-responsive topicList" id="topic_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		vrv.topic.topicList.init();
	});
	</script>