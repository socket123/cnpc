var su = su || {};
su.keyword = su.keyword || {};

/**
		 * 公共方法
		 */
su.keyword.comFn = {
    tokeywordTable: function(currentIndex) {
        var action = "keyword/listTable.do";
        var data = {
            currentIndex: currentIndex
        };
        base.AJAX_POST(action, data, 'html',
        function(html) {
            $('#keyword_table').empty().append($(html));
        });
    }
},
/*
		 * 新增页面JS
		 */
su.keyword.addkeyword = {
    init: function() {
        this.btn.init();
    },
    btn: {
        init: function() {
            this.savekeyword();
            this.cancelkeyword();
        },
        cancelkeyword: function() {
            $("#cancel").click(function() {
                var action = 'keyword/list.do';
                base.getAction(action);
            });
        },
        savekeyword: function() {
            function validatekeyword(keywordName, password, nike, conpass) {
                if (keywordName == "" || keywordName == null) {
                    bootbox.alert("请输入关键字");
                    return false;
                } 
                return true;
            };

            $("#saveKeyword").click(function() {
                var keywordName = $("#keyword").val();
                var password = $("#password").val();
                var nike = $("#nickname").val();
                var roleId = $("#roleId option:selected").val();
                var conpass = $("#conpass").val();
                if (validatekeyword(keywordName, password, nike, conpass)) {
                    $.ajax({
                        type: 'post',
                        url: 'save.do',
                        data: {
                            roleId: roleId,
                            keyword: keywordName,
                            password: password,
                            nike: nike
                        },
                        beforeSend: function() {
                            $("#savekeyword").attr("disabled", "disabled");
                        },

                        success: function(data) {
                            if ("true" == data) {
                                bootbox.alert("操作成功!",
                                function() {
                                    var action = 'keyword/list.do';
                                    base.getAction(action);
                                });
                            } else if ("false" == data) {
                                bootbox.alert("操作失败!",
                                function() {
                                    var action = 'keyword/list.do';
                                    base.getAction(action);
                                });
                            } else if ("error" == data) {
                                bootbox.alert("已经存在...");
                            }
                        }

                    });
                }
            });
        }
    }
};
// 用户列表JS
su.keyword.keywordList = {
    init: function() {
        this.page.init();
    },
    page: {
        init: function() {
            this.loadkeywordTable();
        },

        loadkeywordTable: function() {
            su.keyword.comFn.tokeywordTable(1);
        }
    }

},

su.keyword.keywordTable = {
    init: function() {
        this.page.init();
        this.btn.init();
        this.opreation.init();
    },
    btn: {
        init: function() {
            this.addkeyword();
        },
        addkeyword: function() {
            $("#addkeyword").click(function() {
                var action = "keyword/add.do";
                base.getAction(action);
            });
        }

    },
    page: {
        init: function() {
            this.pagenation();
        },
        pagenation: function() {
            $(".tcdPageCode").createPage({
                pageCount: $("#totalPage").val(),
                current: $("#currentIndex").val(),
                backFn: function(p) {
                    su.keyword.comFn.tokeywordTable(p);
                }
            });
        }
    },
    opreation: {
        init: function() 
        {
        	
        },
        update: function(id) {
            var action = 'keyword/toupdate.do?id=' + id;
            base.getAction(action);
        },
        updateRole: function(id) {
            var action = 'keyword/updateRole.do?id=' + id;
            base.getAction(action);
        },
       deleteKeyWord: function(keywordId) {
            bootbox.dialog({
                message: "确定对该记录进行该操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../keyword/delete.do',
                                data: {
                                    keywordId: keywordId
                                },
                                success: function(data) {
                                    if ("error" == data) {
                                        bootbox.alert('此用户不可进行该操作');
                                    } else if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        su.keyword.comFn.tokeywordTable(1);
                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        su.keyword.comFn.tokeywordTable(1);
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
        }
    }
};
/*
 * 修改页面JS
 */
su.keyword.update = {
    init: function() {
        this.btn.init();
    },
    btn: {
        init: function() {
            this.savekeyword();
            this.cancelkeyword();
        },
        cancelkeyword: function() {
            $("#cancel").click(function() {
                var action = 'keyword/list.do';
                base.getAction(action);
            });
        },
        savekeyword: function() {
            $("#saveKeyword").click(function() {
                $.ajax({
                    type: 'post',
                    url: 'update.do',
                    data: {
                    	id:$("#id").val(),
                        keyword: $("#keyword").val()
                    },
                    beforeSend: function() {
                        $("#savekeyword").attr("disabled", "disabled");
                    },
                    success: function(data) {
                        if ("true" == data) {
                            bootbox.alert("操作成功!",
                            function() {
                                var action = 'keyword/list.do';
                                base.getAction(action);
                            });
                        } else if ("false" == data) {
                            bootbox.alert("操作失败!",
                            function() {
                                var action = 'keyword/list.do';
                                base.getAction(action);
                            });
                        } else if ("error" == data) {
                            bootbox.alert("已经存在...",function(){
                            $("#savekeyword").attr("disabled", false);           	
                            });
                        }
                    }

                });
            });
        }
    }
};