<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!doctype html>
<html>
  <head>
    <title>登陆</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="author" content="Jophy" />
	  <jsp:include page="common/base.jsp"></jsp:include>
  </head>
<body class="login-layout login">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red"></span>
									<span class="white">后台管理系统</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入登陆账号
											</h4>

											<div class="space-6"></div>
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="userName" class="form-control" placeholder="用户名" tip="用户名不能为空" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password"  id="password" class="form-control" placeholder="密码" tip="密码不能为空"  />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div id="errorInfo">
														
													</div>

													<div class="clearfix" style="padding-top:11px">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 记住密码</span>
														</label>

														<div id="loginBtn" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登陆
														</div>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
										</div>
										<div class="toolbar clearfix">
											<div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
  <script type="text/javascript">
  $(function() {
	  su.login.init();
  });
  </script>
</html>