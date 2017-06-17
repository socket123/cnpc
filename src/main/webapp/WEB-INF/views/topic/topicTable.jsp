<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/topic.js"></script>
<table id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>分类名称</th>
			<th>创建时间</th>
			<th>创建人</th>
			<th>更新时间</th>
			<th>更新人</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	 <c:when test="${pages.dataList.size()>0}">
		<c:forEach items="${pages.dataList }" var="topic" varStatus="status">
			<tr>
			    <td  class="center">${status.count+(pages.currentIndex-1)*10}</td>
				<td>${topic.name}</td>
				<td>${topic.createTime}</td>
				<td>${topic.createUserName}</td>
				<td>${topic.updateTime}</td>
				<td>${topic.updateUser}</td>
				<td>
					<div
						class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
						 <a name ="updateTopic" class="blue" href="#" data-id="${topic.id}">修改</a>
						 <a name ="del" class="red" href="#" data-id="${topic.id}">删除</a>
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
		vrv.topic.topicTable.init();
	});
</script>