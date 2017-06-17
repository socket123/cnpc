<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/data.js"></script>
<div class="page-header userList">
	<h1>
	资料管理
		<button class="btn btn-info" id="addTopic" >
		新增资料
		</button>
	</h1>
	
</div>

<div class="table-responsive topicList" id="Data_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		su.Data.DataList.init();
	});
	</script>