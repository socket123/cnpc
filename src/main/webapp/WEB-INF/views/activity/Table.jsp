<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/activity.js"></script>
<table id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>课程名称</th>
			<th style="width: 50px;" class="cons">课程内容</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>随机码</th>
			<th>参与人数</th>
			<th>上课地点</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	 <c:when test="${pages.dataList.size()>0}">
		<c:forEach items="${pages.dataList }" var="topic" varStatus="status">
			<tr>
			    <td  class="center">${status.count+(pages.currentIndex-1)*10}</td>
				<td>${topic.activityename}</td>
				<td style="width: 50px;" class="cons">
					<%--<a title="${topic.content}"></a>--%>
						<a title="${topic.countactive}" href="javascript:void(0);" style="color:black;text-decoration:none ">
					<c:if test="${fn:length(topic.countactive)>15 }">
						${fn:substring(topic.countactive, 0,15)}......
					</c:if>
					<c:if test="${fn:length(topic.countactive)<=15 }">
						${topic.countactive}
					</c:if>
						</a>
				</td>
				<td>${topic.starttime}</td>
				<td>${topic.endtime}</td>
				<th>${topic.randomcode}</th>
				<th>${topic.count}</th>
				<th>${topic.location}</th>
				<td>
					<div
						class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
						 <a name ="updateTopic" class="blue" href="#" data-id="${topic.id}">修改</a>
						 <a name ="del" class="red" href="#" data-id="${topic.id}">删除</a>
						<a name="join" id="join" class="green" href="#"  data-id="${topic.id}">参与人数</a>
					</div>
				</td>
			</tr>
		</c:forEach>
		</c:when>
			<c:otherwise>
				<tr>
					<td
						colspan="14"
						style="text-align: center;">未查到任何信息</td>
				</tr>

			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div>
	<input
		type="hidden"
		value="${pages.totalPage}"
		id="totalPage" /> <input
		type="hidden"
		value="${pages.currentIndex}"
		id="currentIndex" />
	<div class="tcdPageCode"></div>
</div>
<script type="text/javascript">
	$(function() {
	su.activity.ActivityTable.init();
		$(".cons").css("width","60px");

	});
</script>