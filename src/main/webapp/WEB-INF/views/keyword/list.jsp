<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/keyword.js"></script>
<div class="page-header keywordList">
	<h1>
		资料分类
		<button class="btn btn-info" id="addkeyword">新建</button>
	</h1>
	
</div>
<!-- /.page-header -->

<div class="table-responsive userList" id="keyword_table">
</div>

<script type="text/javascript">
$(function() {
	su.keyword.keywordList.init();
});
</script>