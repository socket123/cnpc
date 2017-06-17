<!-- 用户列表 -->
<%@ page
	language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/keyword.js"></script>
<!-- 用户信息列表显示 -->
<table
	id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="center">#</th>
			<th>名称</th>
	<!-- 		<th>使用者</th>
	-->		<th>操作</th>
	 	</tr>
	</thead>
	<tbody>
		<!-- 遍历数据 -->

		<c:choose>
			<c:when test="${pages.totalNum>0}">
				<c:forEach
					items="${pages.dataList}"
					var="keyword"
					varStatus="status">
					<tr>
						<td class="center">${status.count}</td>
						<td>${keyword.keyword}</td>
<td>
							<div
								class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
							<a
									class="blue"
									href="javascript:void(0);"
									onclick="su.keyword.keywordTable.opreation.update(${keyword.id})">
									<i>编辑</i>
								</a>
							<a
										class="green"
										href="javascript:void(0);"
										onclick="su.keyword.keywordTable.opreation.deleteKeyWord(${keyword.id})">
									<i>删除</i>
									</a>
							</div>

							<div class="visible-xs visible-sm hidden-md hidden-lg">
								<div class="inline position-relative">
									<button
										class="btn btn-minier btn-yellow dropdown-toggle"
										data-toggle="dropdown">
										<i class="icon-caret-down icon-only bigger-120"></i>
									</button>

									<ul
										class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
										<li><a
											href="javascript:void(0);"
											onclick="su.keyword.keywordTable.opreation.update(${keyword.id})"
											class="tooltip-info"
											data-rel="tooltip"
											title="编辑"> <span class="blue"> <i>编辑</i>
										 	</span>
										</a></li>

											<li> <a
												class="tooltip-success"
												href="javascript:void(0);"
												onclick="su.keyword.keywordTable.opreation.deleteKeyWord(${keyword.id})"
												data-rel="tooltip"
												title="关闭"> <span class="green"> <i>关删除</i>
												</span>
											</a></li>
																</ul>
								</div>
							</div>
						</td>		</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td
						colspan="4"
						style="text-align: center;">没有查询到任何信息</td>
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
	$(function(){
		su.keyword.keywordTable.init();
	});
	</script>
