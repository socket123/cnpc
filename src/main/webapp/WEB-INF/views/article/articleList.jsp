<!-- 宸︿晶缁勪欢 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/article.js"></script>
<div class="page-header userList">
	<h1>
		文章列表
		<button class="btn btn-info" id="addArticle">新增文章</button>
	</h1>
	
</div>
<!-- /.page-header -->

<div class="table-responsive userList" id="article_table" style="height: 66px; ">
</div>

<script type="text/javascript">
$(function() {
	su.article.articleList.init();
});
</script>