<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/taglib.jsp"%>
<script type="text/javascript" src="${base}/resource/js/updatePwd.js">
</script>
<div class="page-header editPass">
	<h1>修改密码</h1>
</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 旧密码： </label>

				<div class="col-sm-9">
					<input type="password" id="oldPass" placeholder="请输入旧密码"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 新密码： </label>

				<div class="col-sm-9">
					<input type="password" id="newPass" placeholder="请输入密码"
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
					<input type="password" id="conPass" placeholder="请确认密码"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>

			<div class="col-md-offset-3 col-md-9">
				<input type="hidden" id="userId" name="userId" value="${userId}" />
				<button class="btn btn-info" type="button" id="confirm">
					<i class="icon-ok bigger-110"></i> 确认
				</button>

				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="button" id="cancel">
					<i class="icon-undo bigger-110"></i> 取消
				</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		su.updatePwd.update.init();
	});
	</script>
