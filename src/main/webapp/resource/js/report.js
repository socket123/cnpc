var su = su || {};
su.custReport = su.custReport || {};
/**
 * 公众方法
 */
su.custReport.comFn = {
	tocustReportTable : function(currentIndex) {
		var action = "custReport/custTable.do";
		var imei = $("#imei").val();
		var id = $("#id").val();
	
		var data = {
			currentIndex : currentIndex,
			beginTime : $("#beginTime").val(),
			endTime : $("#endTime").val()
			
		};
		base.AJAX_POST(action, data, 'html', function(html) {
			$("#cust_table").empty().append($(html));
		});

	}
},

// 订单列表JS
su.custReport.custReportList = {
	init : function() {
		this.page.init();
		this.btn.init();
	},
	btn : {
		init : function() {
			this.search();
				this.exportExcel();
		},
		
		search : function() {
			$("#search").click(function() {
				var imei = $("#imei").val();
				var id = $("#id").val();
				var action = "cust/custTable.do";
				var data = {
					imei : imei,
					id : id,
					beginTime : $("#beginTime").val(),
					endTime : $("#endTime").val()
				};
				base.AJAX_POST(action, data, 'html', function(html) {
					$("#cust_table").empty().append($(html));
				});

			});
		},

		exportExcel : function() {
			$("#export").click(
					function() {
						var action = '../custReport/toExcel.do?beginTime='
								+ $("#beginTime").val() + '&endTime='
								+ $("#endTime").val() + '&imei='
								+ $("#imei").val() + '&id=' + $("#id").val()
								+ "&currentInd=" + $("#currentIndex").val();
						location.href = action;
					});
		}
	},

	page : {
		init : function() {
			this.loadUserTable();
		},

		loadUserTable : function() {
			su.custReport.comFn.tocustReportTable(1);
		}
	}

},

su.custReport.custReportTable = {
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
					su.custReport.comFn.tocustReportTable(p);
				}
			});
		}
	},
	opreation : {
		init : function() {
		},
		detail : function(id) {
			var action = 'custReport/detail.do?id=' + id;
			base.getAction(action);
		},
		updateStatus : function(id, status) {

			bootbox.dialog({
				message : "确定对此进行该操作？",
				title : "提示信息",
				buttons : {
					OK : {
						label : "确定",
						className : "btn-primary",
						callback : function() {
							$.ajax({
								url : '../custReport/update.do',
								data : {
									aviateId : id,
									status : status
								},
								success : function(data) {
									if ("error" == data) {
										bootbox.alert('此用户不可进行该操作');
									} else if ("false" == data) {
										bootbox.alert("操作失败");
										su.custReport.comFn
												.tocustReportTable(1);

									} else if ("true" == data) {
										bootbox.alert("操作成功");
										su.custReport.comFn
												.tocustReportTable(1);

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
		}
	}

};
su.custReport.addcustReport = {
	init : function() {
		this.btn.init();
	},
	btn : {
		init : function() {
			this.saveUser();
			this.cancelUser();
		},
		cancelUser : function() {
			$("#cancel").click(function() {
				var action = 'report/order.do';
				base.getAction(action);
			});
		},
		saveUser : function() {
			$("#save").click(function() {
				$.ajax({
					type : 'post',
					url : 'save.do',
					data : {
						imei : $("#imel").val(),
						stickerid : $("#stickerid").val()
					},
					beforeSend : function() {
						$("#save").attr("disabled", "disabled");
					},

					success : function(data) {
						if ("true" == data) {
							bootbox.alert("操作成功!", function() {
								var action = 'custReport/custReportList.do';
								base.getAction(action);
							});
						} else if ("false" == data) {
							bootbox.alert("操作失败!", function() {
								var action = 'custReport/custReportList.do';
								base.getAction(action);
							});
						} else if ("error" == data) {
							bootbox.alert("此用户已经被�?�?...");
						} else if ("qrError" == data) {
							bootbox.alert("无效的膜IDD");
						} else if ("errorStatus" == data) {
							bootbox.alert("此膜ID已经失效");
						}
					}

				});
			});
		}
	}
};
