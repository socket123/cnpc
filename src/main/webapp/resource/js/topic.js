var vrv = vrv || {};
vrv.topic = vrv.topic || {};
/**
 * 公众方法
 */
vrv.topic.comFn = {
	toTopicTable : function(currentIndex) {
		var action = "topic/topicTable.do";
		var data = {
			currentIndex : currentIndex
		};
		base.AJAX_POST(action, data, "html", function(html) {
			$("#topic_table").empty().append($(html));
		});
	}
},

vrv.topic.topicList = {
	init : function() {
		vrv.topic.comFn.toTopicTable(1);
		this.btn.init();
	},
	btn : {
		init : function() {
			this.addTopic();
		},
		addTopic : function() {
			$("#addTopic").click(function() {
 				var action = "topic/addUpdateTopic.do";
				base.getAction(action);
			});
		}
	}
}, 
vrv.topic.topicTable = {
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
						var topicId = $(this).attr("data-id");
						var action = "topic/addUpdateTopic.do?topicId=" + topicId+'&menuId=7';
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
	                                        url: 'delTopic.do',
	                                        data: {
	                                            id: id
	                                        },
	                                        success: function(data) {
	                                            if ("error" == data) {
	                                                bootbox.alert("删除失败");
	                                            } else if ("false" == data) {
	                                                bootbox.alert("删除失败");
	                                                vrv.topic.comFn.toTopicTable(1);

	                                            } else if ("true" == data || true == data) {
	                                                bootbox.alert("删除成功");
	                                                vrv.topic.comFn.toTopicTable(1);
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
						vrv.topic.comFn.toTopicTable(p, shop_id);
						$("#currentIndex").val($("#currentIndex").val());
					}
				});
			},
			returnAdd : function(id) {
				var action = 'topic/toReturn.do?Id=' + id;
				base.getAction(action);
			},
			detail : function(id) {
				var action = "topic/topicDetail.do?id=" + id;
				base.getAction(action);

			}
		}
},


vrv.topic.addTopic = {
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
                var action = 'topic/topicList.do';
                base.getAction(action);
            });
        },
	   saveTopic : function() {
		$("#saveTopic").click( function() {
			var id = $("#id").val();
			var name = $("#name").val().trim();
			
			if (name == null || name == "" || name == undefined) {
				bootbox.alert("分类名称不能为空！");
				return;
			}
			
			var url= 'updateTopic.do';
			if(id == null || id == "" || id == undefined){
				url = 'saveTopic.do';
			}
			$.ajax({
				type : 'post',
				url : url,
				data : {
					id : id,
					name : name,
				},
				
				success : function(data) {

					console.log(data);
					if (true == data || "true" == data) {
						bootbox.alert("操作成功！", function() {
							var action = 'topic/topicList.do';
							base.getAction(action);
						});
					} else if ("error" == data) {
						bootbox.alert("分类名称重复！");
					}else{
						bootbox.alert("操作异常！");
					}
				}
			});
		});
	},
}
	};
