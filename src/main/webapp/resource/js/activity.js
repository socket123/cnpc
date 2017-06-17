var su = su || {};
su.activity = su.activity || {};
/**
 * 公众方法
 */
su.activity.comFn = {
	toTopicTable : function(currentIndex) {
		var action = "Activity/ActivityTable.do";
		var data = {
			currentIndex : currentIndex
		};
		base.AJAX_POST(action, data, "html", function(html) {
			$("#Activity_table").empty().append($(html));
		});
	}
},

su.activity.ActivityList = {
	init : function() {
		su.activity.comFn.toTopicTable(1);
		this.btn.init();
	},
	btn : {
		init : function() {
			this.addTopic();
		},
		addTopic : function() {
			$("#addTopic").click(function() {
 				var action = "Activity/addUpdateActivity.do";
				base.getAction(action);
			});
		}
	}
}, 
su.activity.ActivityTable = {
		init : function() {
			this.page.init();
			this.btn.init();
		},
		btn : {
			init : function() {	
				this.del();
				this.updateTopic();
				this.join();
			},
			updateTopic : function() {
					$("[name=updateTopic]").click(function() {
						var ActivityId = $(this).attr("data-id");
						var action = "Activity/addUpdateActivity.do?ActivityId=" + ActivityId+'';
						base.getAction(action);
					});
				},
			join:function(){
				$("[name=join]").click(function() {
					var ActivityId = $(this).attr("data-id");
					var action = "Activity/ActivityJoinTable.do?activityid=" + ActivityId+'';
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
	                                        url: 'delActivity.do',
	                                        data: {
	                                            id: id
	                                        },
	                                        success: function(data) {
	                                            if ("error" == data) {
	                                                bootbox.alert("删除失败");
	                                            } else if ("false" == data) {
	                                                bootbox.alert("删除失败");
	                                                su.activity.comFn.toTopicTable(1);

	                                            } else if ("true" == data || true == data) {
	                                                bootbox.alert("删除成功");
	                                                su.activity.comFn.toTopicTable(1);
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
						su.activity.comFn.toTopicTable(p, shop_id);
						$("#currentIndex").val($("#currentIndex").val());
					}
				});
			},
			returnAdd : function(id) {
				var action = 'Activity/toReturn.do?Id=' + id;
				base.getAction(action);
			},
			detail : function(id) {
				var action = "Activity/ActivityDetail.do?id=" + id;
				base.getAction(action);

			}
		}
},


su.activity.addTopic = {
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
                var action = 'Activity/ActivityList.do';
                base.getAction(action);
            });
        },
	   saveTopic : function() {
		$("#saveTopic").click( function() {
			var id = $("#id").val();
			var name = $("#activityname").val()||"";
			var content = $("[name='content']").val()||"";
			var teacher=$("#teacher").val()||"";
			var location=$("#location").val()||"";
			var starttime=$("#starttime").val()||"";
			var endtime=$("#endtime").val()||"";
			var randomcode= $("#randomcode").val();
			if (name == null || name == "" || name == undefined) {
				bootbox.alert("名称不能为空！");
				return;
			}
			if(content==null ||content==""||content==undefined){
				bootbox.alert("内容不能为空！");
				return;

			}			if (teacher == null || teacher == "" || teacher == undefined) {
				bootbox.alert("主讲人不能为空！");
				return;
			}
			if(location==null ||location==""||location==undefined){
				bootbox.alert("上课地点不能为空！");
				return;

			}if (starttime == null || starttime == "" || starttime == undefined) {
				bootbox.alert("开始时间不能为空！");
				return;
			}
			if(endtime==null ||endtime==""||endtime==undefined){
				bootbox.alert("结束时间不能为空！");
				return;

			}
			if(randomcode==null ||randomcode==""||randomcode==undefined){
				bootbox.alert("随机码不能为空");
				return;
			}

			var url= 'updateActivity.do';
			if(id == null || id == "" || id == undefined){
				url = 'saveActivity.do';
			}
			var dataObj= {
					id : id,
					activityename: name,
					content:content,
				teacher:teacher,
				location:location,
				starttime:starttime,
				endtime:endtime,
				randomcode:randomcode
				};
			$.ajax({
				type : 'post',
				url : url,
				data :dataObj,
				success : function(data) {
					console.log(data);
					if (true == data || "true" == data) {
						bootbox.alert("操作成功！", function() {
							var action = 'Activity/ActivityList.do';
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
