<!-- 页头组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed');}catch(e){}
	</script>
	
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large" >
			<button class="btn btn-success" title="修改密码" id="updatapw">
				<i class="icon-lock"></i>
			</button>

			<button class="btn btn-info" title="退出登录" id="exitLogin">
				<i class="icon-off"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>
			<span class="btn btn-info"></span>
			<span class="btn btn-warning"></span>
			<span class="btn btn-danger"></span>
		</div>
	</div>
	
	
	<ul class="nav nav-list">
		<input type="hidden" id="menuId" value="${menuId}">
		<c:forEach items="${sessionScope.user.menuList}" var="list">
		<li menuId="${list.id}">
			<a href="${base}/${list.link}" <c:if test="${list.childMenu!= null && fn:length(list.childMenu) > 0}">class="dropdown-toggle"</c:if> />
				<i class="${list.icon}"></i>
				<span class="menu-text"> ${list.menuName}</span>
				<c:if test="${list.childMenu!= null && fn:length(list.childMenu) > 0}">
					<b class="arrow icon-angle-down"></b>
				</c:if>
			</a>
			<c:if test="${list.childMenu!= null && fn:length(list.childMenu) > 0}">
			<ul class="submenu">
				<c:forEach items="${list.childMenu}" var="childList">
				<li  menuId="${childList.id}">
					<a href="${base}/${childList.link}">
						<i class="icon-double-angle-right"></i>
						${childList.menuName}
					</a>
				</li>
				</c:forEach>
				
			</ul>
			</c:if>
		</li>
		</c:forEach>
	</ul><!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed');}catch(e){}
		$(function(){
			su.leftMenu.init();
		});
	</script>
