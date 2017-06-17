<!-- 页头组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed');}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
					<i class="icon-leaf"></i>
					后台管理系统
				</small>
			</a>
		</div>
		
		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav" style="height: inherit;">
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<i class="icon-bell-alt"></i>
						<span class="user-info">
							<small>欢迎光临</small>
							${sessionScope.user.username}
						</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>