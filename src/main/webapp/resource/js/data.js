var su = su || {};
su.Data = su.Data || {};
/**
 * 公众方法
 */
su.Data.comFn = {
	toTopicTable : function(currentIndex) {
		var action = "Data/DataTable.do";
		var data = {
			currentIndex : currentIndex
		};
		base.AJAX_POST(action, data, "html", function(html) {
			$("#Data_table").empty().append($(html));
		});
	}
},

su.Data.DataList = {
	init : function() {
		su.Data.comFn.toTopicTable(1);
		this.btn.init();
	},
	btn : {
		init : function() {
			this.addTopic();
		},
		addTopic : function() {
			$("#addTopic").click(function() {
 				var action = "Data/addUpdateData.do";
				base.getAction(action);
			});
		}
	}
}, 
su.Data.DataTable = {
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
						var DataId = $(this).attr("data-id");
						var action = "Data/addUpdateData.do?DataId=" + DataId;
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
	                                        url: 'delData.do',
	                                        data: {
	                                            id: id
	                                        },
	                                        success: function(data) {
	                                            if ("error" == data) {
	                                                bootbox.alert("删除失败");
	                                            } else if ("false" == data) {
	                                                bootbox.alert("删除失败");
	                                                su.Data.comFn.toTopicTable(1);

	                                            } else if ("true" == data || true == data) {
	                                                bootbox.alert("删除成功");
	                                                su.Data.comFn.toTopicTable(1);
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
						su.Data.comFn.toTopicTable(p, shop_id);
						$("#currentIndex").val($("#currentIndex").val());
					}
				});
			},
			returnAdd : function(id) {
				var action = 'Data/toReturn.do?Id=' + id;
				base.getAction(action);
			},
			detail : function(id) {
				var action = "Data/DataDetail.do?id=" + id;
				base.getAction(action);

			}
		}
},


su.Data.addTopic = {
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
                var action = 'Data/DataList.do';
                base.getAction(action);
            });
        },
	   saveTopic : function() {
		$("#saveTopic").click( function() {
			var id = $("#id").val();
			var name = $("#name").val()||"";
			var image=$("#image").val()||"";
			var keywords=$("#keywords").find("option:selected").val();
			var content = $("[name='content']").val();

			if (name == null || name == "" || name == undefined) {
				bootbox.alert("名称不能为空！");
				return;
			}
			if (image == null || image == "" || image == undefined) {
				bootbox.alert("请选择文件");
				return;
			}if (content == null || content == "") {
				bootbox.alert("请确入文章内容");
				return false;
			}

			var url= 'updateData.do';
			if(id == null || id == "" || id == undefined){
				url = 'saveData.do';
			}
			var dataObj= {
				id : id,
				name: name,
				url:image,
				type:keywords,
				content:content
				};
			$.ajax({
				type : 'post',
				url : url,
				data :dataObj,

				success : function(data) {
					console.log(data);
					if (true == data || "true" == data) {
						bootbox.alert("操作成功！", function() {
							var action = 'Data/DataList.do';
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
