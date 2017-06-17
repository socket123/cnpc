var su = su || {};
su.updatePwd = su.updatePwd || {};
su.updatePwd.update = {
	init : function() {
		this.btn.init();
	},
	btn : {
		init : function() {
			this.confirm();
			this.cancel();
		},
		confirm : function() {
			$("#confirm").click(
					function() {
						var oldPass = $("#oldPass").val();
						var newPass = $("#newPass").val();
						var conPass = $("#conPass").val();
						if (base.validInputNull(oldPass)
								|| base.validInputNull(newPass)
								|| base.validInputNull(conPass)) {
							bootbox.alert("输入的密码不得为�?");
						} else if (conPass != newPass) {
							bootbox.alert("两次输入的密码不�?�?");
						} else {
							$.ajax({
								url : 'savePwd.do',
								data : {
									userId:$("#userId").val(),
								oldPass:oldPass,
								newPass:newPass
								},
								success:function(data){
									if ("true" == data) {
										bootbox.alert("操作成功!", function() {
											var action = 'index.do';
											base.getAction(action);
										});
									} else if ("false" == data) {
										bootbox.alert("操作失败!", function() {
											var action = 'index.do';
											base.getAction(action);
										});
									} else if ("error" == data) {
										bootbox.alert("旧密码错�?");
									}

								}

							});
						}
					});

		},
		cancel : function() {
			$("#cancel").click(function() {
				var action = 'index.do';
				base.getAction(action);

			});
		}

	}

};