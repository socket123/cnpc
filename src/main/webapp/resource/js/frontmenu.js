var su = su || {};
su.frontmenu = su.frontmenu || {};
/**
 * 公众方法
 */
su.frontmenu.comFn = {
	toTopicTable : function(currentIndex) {
		var action = "FrontMenu/FrontMenuTable.do";
		var data = {
			currentIndex : currentIndex
		};
		base.AJAX_POST(action, data, "html", function(html) {
			$("#FrontMenu_table").empty().append($(html));
		});
	}
},

su.frontmenu.FrontMenuList = {
	init : function() {
		su.frontmenu.comFn.toTopicTable(1);
		this.btn.init();
	},
	btn : {
		init : function() {
			this.addTopic();
		},
		addTopic : function() {
			$("#addTopic").click(function() {
 				var action = "FrontMenu/addUpdateFrontMenu.do";
				base.getAction(action);
			});
		}
	}
}, 
su.frontmenu.FrontMenuTable = {
		init : function() {
			this.page.init();
			this.btn.init();
		},
		btn : {
			init : function() {	
				this.del();
				this.updateTopic();
			},
			updateTopic : function() {
					$("[name=updateTopic]").click(function() {
						var FrontMenuId = $(this).attr("data-id");
						var action = "FrontMenu/addUpdateFrontMenu.do?FrontMenuId=" + FrontMenuId+'';
						base.getAction(action);
					});
				},
	        del:function(){
	        	$.each($("[name=del]"), function() {
	        		$(this).on("click", function() {
	        			var id = $(this).data("id");
	            		bootbox.dialog({
	                        message: "确定要删除吗？",
	                        title: "提示",
	                        buttons: {
	                            OK: {
	                                label: "确定",
	                                className: "btn-primary",
	                                callback: function() {
	                                    $.ajax({
	                                        url: 'delFrontMenu.do',
	                                        data: {
	                                            id: id
	                                        },
	                                        success: function(data) {
	                                            if ("error" == data) {
	                                                bootbox.alert("删除失败");
	                                            } else if ("false" == data) {
	                                                bootbox.alert("删除失败");
	                                                su.frontmenu.comFn.toTopicTable(1);

	                                            } else if ("true" == data || true == data) {
	                                                bootbox.alert("删除成功");
	                                                su.frontmenu.comFn.toTopicTable(1);
	                                            }
	                                        }
	                                    });
	                                }
	                            },
	                            Cancel: {
	                                label: "取消",
	                                className: "btn-default",
	                                callback: function() {}
	                            }
	                        }
	                    });
	            	});
	        	});
	        }
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
						var shop_id = $('select[name=shopName] option:selected').val();
						su.frontmenu.comFn.toTopicTable(p, shop_id);
						$("#currentIndex").val($("#currentIndex").val());
					}
				});
			},
			returnAdd : function(id) {
				var action = 'FrontMenu/toReturn.do?Id=' + id;
				base.getAction(action);
			},
			detail : function(id) {
				var action = "FrontMenu/FrontMenuDetail.do?id=" + id;
				base.getAction(action);

			}
		}
},


su.frontmenu.addTopic = {
	init : function() {
		this.btn.init();
	},
	btn: {
        init: function() {
            this.saveTopic();
            this.cancelTopic();
        },
        cancelTopic: function() {
        	$("[name=cancel]").click(function() {
                var action = 'FrontMenu/FrontMenuList.do';
                base.getAction(action);
            });
        },
	   saveTopic : function() {
		$("#saveTopic").click( function() {
			var id = $("#id").val();
			var name = $("#menuname").val()||"";
			var menuURL =$("#menuurl").val()||"";
			if (name == null || name == "" || name == undefined) {
				bootbox.alert("名称不能为空！");
				return;
			}
			if(menuURL==null ||menuURL==""||menuURL==undefined){
				bootbox.alert("URL不能为空！");
				return;

			}
			
			var url= 'updateFrontMenu.do';
			if(id == null || id == "" || id == undefined){
				url = 'saveFrontMenu.do';
			}
			var dataObj= {
					id : id,
					menuname : name,
					menuurl:menuURL
				};
			$.ajax({
				type : 'post',
				url : url,
				data :dataObj,

				success : function(data) {
					console.log(data);
					if (true == data || "true" == data) {
						bootbox.alert("操作成功！", function() {
							var action = 'FrontMenu/FrontMenuList.do';
							base.getAction(action);
						});
					}else{
						bootbox.alert("操作异常！");
					}
				}
			});
		});
	},
}
	};
