<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/frontmenu.js"></script>
<div class="page-header userList">
	<h1>
		<c:choose>
			<c:when test="${FrontMenu.id == null || FrontMenu.id =='' }">
				增加栏目
			</c:when>
			<c:otherwise>
				修改栏目
			</c:otherwise>
		</c:choose>
	</h1>

</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal">
		
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">栏目名称
				</label>
				<div class="col-sm-9">

					<input type="text" value="${FrontMenu.menuname}" id="menuname" name="menuname"
						placeholder="请输入栏目名称"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">栏目URL
				</label>
				<div class="col-sm-9">

					<input type="text" value="${FrontMenu.menuurl}" id="menuurl" name="menuurl"
						   placeholder="请输入栏目URL"
						   class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			
			<input id="id" name="id" type="hidden" value="${FrontMenu.id}" />
			
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button" id="saveTopic" name="saveTopic">
					<i class="icon-ok bigger-110"></i>
					保存
				</button>
				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="button" name="cancel">
					<i class="icon-undo bigger-110"></i>
					取消
				</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		su.frontmenu.addTopic.init();
	});
</script>