<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/frontmenu.js"></script>
<div class="page-header userList">
	<h1>
	前端栏目菜单列表
		<button class="btn btn-info" id="addTopic" >
		添加栏目
		</button>
	</h1>
	
</div>

<div class="table-responsive topicList" id="FrontMenu_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		su.frontmenu.FrontMenuList.init();;
	});
	</script>