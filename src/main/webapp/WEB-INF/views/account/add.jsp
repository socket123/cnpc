<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/account.js"></script>
<div class="page-header userList">
	<h1>新增用户</h1>
</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="addUseForm">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">用户名： </label>

				<div class="col-sm-9">
					<input type="text" id="userName" placeholder="请输入用户名"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 密码： </label>

				<div class="col-sm-9">
					<input type="password" id="password" placeholder="请输入密码"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
						<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 确认密码： </label>

				<div class="col-sm-9">
					<input type="password" id="conpass" placeholder="请输入密码"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 使用人： </label>

				<div class="col-sm-9">
					<input type="text" id="nickname" placeholder="请输入昵称"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>

			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button" id="saveUser" name="saveUser">
					<i class="icon-ok bigger-110"></i> 保存
				</button>

				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="button" id="cancel">
					<i class="icon-undo bigger-110"></i> 返回
				</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
$(function() {
	su.account.addUser.init();
});
</script>