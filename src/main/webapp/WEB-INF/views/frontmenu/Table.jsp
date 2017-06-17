<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/frontmenu.js"></script>
<table id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>菜单名称</th>
			<th>菜单URL</th>
			<th>创建时间</th>
			<th>创建人</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	 <c:when test="${pages.dataList.size()>0}">
		<c:forEach items="${pages.dataList }" var="topic" varStatus="status">
			<tr>
			    <td  class="center">${status.count+(pages.currentIndex-1)*10}</td>
				<td>${topic.menuname}</td>
				<td>${topic.menuurl}</td>
				<td>${topic.menucreatetime}</td>
				<td>${topic.menucreateuser}</td>

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
	su.frontmenu.FrontMenuTable.init();
	});
</script>