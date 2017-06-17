<!-- 文章列表 -->
<%@ page
	language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/article.js"></script>
<!-- 文章信息列表显示 -->
<table
	id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="center" style="width:5%">#</th>
			<th style="width:15%">标题</th>
			<th class="jianjie" style="width:60px;">简介</th>
			<th style="width:15%">分类</th>
			<th style="width:10%">文章keywordId</th>
			<%--<th>创建者用户名</th>--%>
			<!-- <th>是否推荐首页</th>
			<th>是否置顶</th>

 -->			<th style="width:15%">操作</th>
		</tr>
	</thead>
	<tbody>
		<!-- 遍历数据 -->

		<c:choose>
			<c:when test="${pages.totalNum>0}">
				<c:forEach
					items="${pages.dataList}"
					var="article"
					varStatus="status">
					<tr>
						<td class="center">${status.count}</td>
						<td>${article.title}</td>
						<td style="width:50%" >${article.summary}</td>
						<td>?keywordId=${article.id}</td>
					<td>${article.keywordText}</td>
						<td>
							<div
								class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a
									class="blue"
									href="javascript:void(0);"
									onclick='su.article.articleTable.opreation.delArticle(${article.id})'>
									<i>删除</i>
								</a> 
								<a
									class="blue"
									href="editArticle.do?id=${article.id}" id="updateArticle"
									>
									<i>修改</i>
								</a> 
							<%--	<a
									class="blue"
									href="javascript:void(0);"
											onclick='su.account.userTable.opreation.editPass(${user.id})'>
									<i>修改密码</i>
								</a> <a
									class="green"
									href="javascript:void(0);"
									onclick="su.account.userTable.opreation.updateRole(${user.id})">
									<i>分配角色</i>
								</a>
							--%>	<%-- <c:if test='${user.status==1}'>
									<a
										class="red"
										href="javascript:void(0);"
										onclick="su.account.userTable.opreation.updateStatus(${user.id},0)">
										<i>关闭</i>
									</a>
								</c:if>

								<c:if test='${user.status==0}'>
									<a
										class="light-blue"
										title="恢复"
										href="javascript:void(0);"
										onclick="su.account.userTable.opreation.updateStatus(${user.id},1)">
										<i>恢复</i>
									</a>
								</c:if> --%>
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
									<%-- 	<li><a
											class="blue"
											href="#"
											title="重置密码"
											onclick='su.article.articleTable.opreation.delArticle(${article.id})'
											data-rel="tooltip"> <i>重置密码</i>
										</a></li> --%>


								<%--		<li><a
											class="blue"
											href="#"
											title="修改密码"
											onclick='su.account.userTable.opreation.editPass(${user.id})'
											data-rel="tooltip"> <i>修改密码</i>
										</a></li>
										<li><a
											class="green"
											href="javascript:void(0);"
											title="分配角色"
											onclick="su.account.userTable.opreation.updateRole(${user.id})"
											data-rel="tooltip"> <i>分配角色</i>
										</a></li>
								--%>		<%-- <c:if test='${user.status==1}'>
											<li><a
												class="red"
												href="#"
												data-rel="tooltip"
												onclick="su.account.userTable.opreation.updateStatus(${user.id},0)">
													<i>关闭</i>
											</a></li>
										</c:if>

										<c:if test='${user.status==0}'>
											<li><a
												title="恢复"
												class="light-blue"
												href="#"
												data-rel="tooltip"
												onclick="su.account.userTable.opreation.updateStatus(${user.id},1)">
													<i>恢复</i>
											</a></li>
										</c:if> --%>

									</ul>
								</div>
							</div>
						</td>
					</tr>
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
		su.article.articleTable.init();
	});
	</script>
