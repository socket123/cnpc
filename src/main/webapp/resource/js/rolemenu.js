/**
 * 
 */
var su = su || {};

su.load = {
	init : function() {
		this.page.init();
		this.btn.init();

	},
	btn : {
		init : function() {
			this.saveUser();
			this.cancelUser();
		},
		cancelUser : function() {
			$("#cancelRole").click(function() {
				var action = 'role/roleList.do';
				base.getAction(action);
			});
		},
		saveUser : function() {
			$("#saveRole").click(function() {
				var roleName = $("#roleName").val();
				var desc = $("#desc").val();
				var id = $("#roleId").val();
				var menuId = $("#menuId").val();
				$.ajax({
					type : 'post',
					url : 'saveRole.do',
					data : {
						roleName : roleName,
						desc : desc,
						id : id,
						menuIds : menuId
					},
					beforeSend : function() {
						$("#saveRole").attr("disabled", "disabled");
					},

					success : function(data) {
						if ("true" == data) {
							bootbox.alert("操作成功!", function() {
								var action = 'role/roleList.do?menuId=4';
								base.getAction(action);
							});
						} else if ("false" == data) {
							bootbox.alert("操作失败!", function() {
								var action = 'role/roleList.do?menuId=4';
								base.getAction(action);
							});
						} else if ("error" == data) {
							bootbox.alert("此角色已经存�?...");
						}
					}

				});
				// }
			});
		}
	},

	page : {
		init : function() {
			this.ztree();
		},
		ztree : function() {

		}
	}

};
var setting = {
	data : {
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "pId",
			rootPId : 0
		}
	},
	key : {
		name : "name"
	},
	check : {
		enable : true
	},
	callback : {
		onCheck : onCheckTree
	}
};
function initZtree(id) {
	$.post("../role/ztree.do", {
		roleId : id
	}, function(data) {
		zNodes = eval(data);
		var treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	}, 'json');
}
function onCheckTree(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	nodes = zTree.getCheckedNodes(true);
	id = "";
	name = "";
	for (var i = 0; i < nodes.length; i++) {
		id += nodes[i].id + ",";
	}
	if (id.length > 0) {
		id = id.substring(0, id.length - 1);
	}
	if (name.length > 0) {
		name = name.substring(0, name.length - 1);
	}
	$("#menuId").val(id);
}
