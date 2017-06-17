<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${base}/resource/css/zTree/zTreeStyle/zTreeStyle.css" />

<script type="text/javascript"
	src="${base}/resource/js/vendor/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${base}/resource/js/rolemenu.js"></script>


<div class="page-header roleMenuList">
	<h1>
	角色编辑
	</h1>

</div>
<!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="addUseForm">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">角色名称： </label>

				<div class="col-sm-9">
					<input type="text" id="roleName" name="roleName"
						value="${role.roleName}" class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 角色描述：</label>

				<div class="col-sm-9">
					<input type="text" id="desc" name="desc" value="${role.desc}"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2"> 角色权限：</label>

				<div class="col-sm-9">

					<ul id="treeDemo" class="ztree" valign="top"></ul>
				</div>
			</div>
			<div class="col-md-offset-3 col-md-9">
				<input id="roleId" name="roleId" value="${role.id}" type="hidden"/>
				<button class="btn btn-info" type="button" id="saveRole"
					name="saveRole">
					<i class="icon-ok bigger-110"></i> 保存
				</button>

				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="button" id="cancelRole">
					<i class="icon-undo bigger-110"></i> 返回
				</button>
		<input id="menuId" name="menuId" type="hidden" value=""/>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	jQuery(function($) {
		initZtree($("#roleId").val());
		su.load.init();
		
	});
</script>