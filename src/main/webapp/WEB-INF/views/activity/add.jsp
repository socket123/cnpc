<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/activity.js"></script>
<script src="${base}/ueditor/ueditor.config.js"></script>
<script src="${base}/ueditor/ueditor.all.js"></script>
<div class="page-header userList">
	<h1>
		<c:choose>
			<c:when test="${topic.id == null || topic.id =='' }">
				增加活动
			</c:when>
			<c:otherwise>
				修改活动
			</c:otherwise>
		</c:choose>
	</h1>

</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal">
		
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">活动名称
				</label>
				<div class="col-sm-9">
					<input type="text" value="${topic.activityename}" id="activityname" name="activityname"
						placeholder="请输入活动名称"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">课程内容
				</label>
				<div class="col-sm-9">
					<%--<input type="text" value="${topic.content}" id="content" name="content"--%>
						   <%--placeholder="请输入课程内容"--%>
						   <%--class="col-xs-10 col-sm-5"> <span--%>
						<%--class="help-inline col-xs-12 col-sm-7"> <span--%>
						<%--class="middle"></span>--%>
					<%--</span>--%>
						<script id="content"  name="content" type="text/plain" style="width:840px;height:500px;">${topic.content}</script>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">主讲人
				</label>
				<div class="col-sm-9">
					<input type="text" value="${topic.teacher}" id="teacher" name="teacher"
						   placeholder="请输入主讲人"
						   class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">上课地点
				</label>
				<div class="col-sm-9">
					<input type="text"  id="location" name="location" value="${topic.location}"
						   placeholder="请输入上课地点"
						   class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">开始时间
				</label>
				<div class="col-sm-9">
					<input type="date" value="${topic.endtime}" id="starttime"  name="starttime"
						   class="col-xs-10 col-sm-5"
							> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">结束时间
				</label>
				<div class="col-sm-9">
					<input type="date" value="${topic.endtime}" id="endtime" name="endtime"
						   class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">随机码
				</label>
				<div class="col-sm-9">
					<c:choose>
						<c:when test="${topic.id == null || topic.id =='' }">
						<input type="text"  id="randomcode" name="randomcode" value="${randomcode}"
						</c:when>
						<c:otherwise>
						<input type="text"  id="randomcode" name="randomcode" value="${topic.randomcode}"
						</c:otherwise>
					</c:choose>

						   placeholder="请输入随机码"
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
		ue = UE.getEditor('content');
		su.activity.addTopic.init();
	});
</script>