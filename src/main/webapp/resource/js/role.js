var su = su || {};
su.role = su.role || {};
/**
 * 公众方法
 */
su.role.comFn = {
	toRoleTable:function(currentIndex){
		var action="role/roleTable.do";
		var data = {
				currentIndex:currentIndex
		};
		base.AJAX_POST(action, data, 'html',function(html){
			$("#role_table").empty().append($(html));
		});
		
	}
},

//订单列表JS
su.role.roleList = {
	init : function() {
		this.page.init();
		this.btn.init();
	},
	btn:{
		init:function(){
			this.addRole();
		},
		addRole:function(){
			$("#addNewRole").click(function(){
			var action='role/getRoleList.do';
			base.getAction(action);
			});
		}
	},
	page : {
		init : function() {
			this.loadUserTable();
		},

		loadUserTable : function() {
			su.role.comFn.toRoleTable(1);
		}
	}

},

su.role.roleTable = {
	init : function() {
		this.page.init();
	},
	page : {
		init : function() {
			this.pagenation();
		},
		pagenation : function() {
			$(".tcdPageCode").createPage({
				pageCount : $("#totalPage").val(),
				current : $("#currentIndex").val(),
				backFn : function(p) {
					su.role.comFn.toRoleTable(p);
				}
			});
		}
	},opreation:{
		init:function(){
			
		},
	updateRoleStatus:function(orderId,status)
	{
		bootbox.dialog({
			message : "确定对该角色进行该操作？",
			title : "提示信息",
			buttons : {
				OK : {
					label : "确定",
					className : "btn-primary",
					callback : function() {
						$.ajax({
							url : '../role/updateRoleStatus.do',
							data : {
								roleId :orderId,
								status : status
							},
							success : function(data) {
								if ("error" == data) {
									bootbox.alert('此角色不可进行该操作');
								} else if ("false" == data) {
									bootbox.alert("操作失败");
									su.role.comFn.toRoleTable(1);

								} else if ("true" == data) {
									bootbox.alert("操作成功");
									su.role.comFn.toRoleTable(1);
								}
							}
						});
					}
				},

				Cancel : {
					label : "取消",
					className : "btn-default",
					callback : function() {

					}
				}
			}
		});
	},
		editRole:function(id){
			var action='role/getRoleList.do?id='+id;
			base.getAction(action);
		}		}
		
	
};
