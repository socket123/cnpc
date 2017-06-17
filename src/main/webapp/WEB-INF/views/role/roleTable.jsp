<!-- 左侧组件 -->
<%@ page
	language="java"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/role.js"></script>
<table
	id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th class="center">#</th>
			<th>角色名称</th>
			<th>角色描述</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${pages.totalNum>0}">
				<c:forEach
					items="${pages.dataList}"
					var="role"
					varStatus="status">
					<tr>
						<td class="center">${status.count}</td>
						<td>${role.roleName}</td>
						<td>${role.desc}</td>
						<td>
							<div
								class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a
									class="blue"
									href="javascript:void(0);"
									onclick="su.role.roleTable.opreation.editRole(${role.id})">
									<i>编辑</i>
								</a>
								<c:if test="${role.stauts==1}">
									<a
										class="green"
										href="javascript:void(0);"
										onclick="su.role.roleTable.opreation.updateRoleStatus(${role.id}, 0)">
										<i>删除</i>
									</a>
								</c:if>
								<c:if test="${role.stauts==0}">

									<a
										class="red"
										href="javascript:void(0);"
										onclick="su.role.roleTable.opreation.updateRoleStatus(${role.id}, 1)">
										<i>删除</i>
									</a>
								</c:if>
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
											onclick="su.role.roleTable.opreation.editRole(${role.id})"
											class="tooltip-info"
											data-rel="tooltip"
											title="编辑"> <span class="blue"> <i>编辑</i>
											</span>
										</a></li>
										<%--<c:if test="${role.stauts==1}">--%>

											<%--<li><a--%>
												<%--class="tooltip-success"--%>
												<%--href="javascript:void(0);"--%>
												<%--onclick="su.role.roleTable.opreation.updateRoleStatus(${role.id},0)"--%>
												<%--data-rel="tooltip"--%>
												<%--title="关闭"> <span class="green"> <i>关闭</i>--%>
												<%--</span>--%>
											<%--</a></li>--%>
										<%--</c:if>--%>
										<%--<c:if test="${role.stauts==0}">--%>


											<%--<li><a--%>
												<%--href="javascript:void(0);"--%>
												<%--onclick="su.role.roleTable.opreation.updateRoleStatus(${role.id}, 1)"--%>
												<%--class="tooltip-error"--%>
												<%--data-rel="tooltip"--%>
												<%--title="Delete"> <span class="red"> <i>恢复</i>--%>
												<%--</span>--%>
											<%--</a></li>--%>
										<%--</c:if>--%>
										<li><a
												href="javascript:void(0);"
												onclick="su.role.roleTable.opreation.updateRoleStatus(${role.id}, 0)"
												class="tooltip-error"
												data-rel="tooltip"
												title="Delete"> <span class="red"> <i>删除</i>
												</span>
										</a></li>
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
						style="text-align: center;">没有查询到任何渠道信息</td>
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
		su.role.roleTable.init();
	});
</script>