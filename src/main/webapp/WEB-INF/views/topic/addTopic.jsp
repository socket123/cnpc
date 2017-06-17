<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/topic.js"></script>
<div class="page-header userList">
	<h1>
		<c:choose>
			<c:when test="${topic.id == null || topic.id =='' }">
				增加分类
			</c:when>
			<c:otherwise>
				修改分类
			</c:otherwise>
		</c:choose>
	</h1>

</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal">
		
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">分类名称
				</label>
				<%--<c:choose>--%>
					<%--<c:when test="${topic.id == null || topic.id =='' }">--%>
				<%--<div class="form-group">--%>
					<%--<label class="col-sm-3 control-label no-padding-right"--%>
						   <%--for="form-field-2">： </label>--%>
					<%--<div class="col-sm-9">--%>
						<%--<!-- <input type="text" id="isHome" placeholder="请输入1或则0(1代表推荐，0代表不推荐)"--%>
                            <%--class="col-xs-10 col-sm-5"> <span--%>
                            <%--class="help-inline col-xs-12 col-sm-7"> <span--%>
                            <%--class="middle"></span>--%>
                        <%--</span> -->--%>
						<%--<select  id="isHome">--%>
							<%--<option value="1">是</option>--%>
							<%--<option value="0">否</option>--%>
						<%--</select>--%>
					<%--</div>--%>
				<%--</div>--%>
					<%--</c:when>--%>
					<%--<c:otherwise>--%>
					<%--</c:otherwise>--%>
				<%--</c:choose>--%>
				<div class="col-sm-9">

					<input type="text" value="${topic.name}" id="name" name="name"
						placeholder="请输入分类名称"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>

			
			<input id="id" name="id" type="hidden" value="${topic.id}" />
			
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
		vrv.topic.addTopic.init();
	});
</script>