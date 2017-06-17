<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<jsp:include page="common/base.jsp"></jsp:include>
	
  </head>
  
  <body style="font-family: 微软雅黑;">
	  <%@ include file="common/head.jsp"%>
	  <div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed');}catch(e){}
			</script>
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				<div class="sidebar leftMenu" id="sidebar">
					<jsp:include page="common/leftMenu.jsp"></jsp:include>
				</div>
				<div class="main-content">
					<jsp:include page="common/nav.jsp"></jsp:include>
					
					<div class="page-content" id="myContent">
			  			<jsp:include page="${page}"></jsp:include>
			  		</div>
			  	</div>
			</div>
	  </div>
  </body>
  
  <script type="text/javascript">
  </script>
</html>
