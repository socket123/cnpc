<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/account.js"></script>
<div class="page-header userList">
	<h1>
		用户列表
		<button class="btn btn-info" id="addUser">开通新账号</button>
	</h1>
	
</div>
<!-- /.page-header -->

<div class="table-responsive userList" id="user_table">
</div>

<script type="text/javascript">
$(function() {
	su.account.userList.init();
});
</script>