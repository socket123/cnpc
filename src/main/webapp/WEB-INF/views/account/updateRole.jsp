<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/account.js"></script>
<div class="page-header userList">
	<h1>分配用户</h1>
</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="addUseForm">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">用户名： </label>

				<div class="col-sm-9">
					<input type="text" id="userName" value="${user.username}"
						disabled="disabled" class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 使用人： </label>

				<div class="col-sm-9">
					<input type="text" id="nickname" value="${user.nike}"
						disabled="disabled" class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 角色： </label>

				<div class="col-sm-9">
					<input type="hidden" id="roleIdInput" name="roLeIdInput"
						value="${user.roleId }" /> <select id="roleId" name="roleId"
						class="form-control roleSelect">
						<option value="0">请选择..</option>
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</select> <span class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>


			<div class="col-md-offset-3 col-md-9">
				<input id="userId" name="userId" value="${user.id}" type="hidden" />
				<button class="btn btn-info" type="button" id="saveUser"
					name="saveUser">
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
		su.account.update.init();
	});
</script>