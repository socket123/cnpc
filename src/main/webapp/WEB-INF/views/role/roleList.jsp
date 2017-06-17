<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/role.js"></script>
<div class="page-header roleList">
	<h1>
	角色列表
		<button class="btn btn-info" id="addNewRole">增加</button>
	</h1>
	
</div>
<!-- /.page-header -->

<div class="table-responsive roleList" id="role_table">
	
</div>
	<script type="text/javascript">
	$(function(){
		su.role.roleList.init();
	});
	</script>