<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/keyword.js"></script>
<div class="page-header userList">
	<h1>新增用户</h1>
</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="addUseForm">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">关键字： </label>
	<input type="hidden" id="id" name="id" value="${keyword.id}"/>
				<div class="col-sm-9">
					<input type="text" id="keyword"  placeholder="请输入关键字" value="${keyword.keyword}"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>

			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button" id="saveKeyword" name="saveKeyword">
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
	su.keyword.update.init();
});
</script>