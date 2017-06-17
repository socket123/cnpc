var su = su || {};
su.account = su.account || {};

/**
		 * 公共方法
		 */
su.account.comFn = {
    toUserTable: function(currentIndex) {
        var action = "account/userTable.do";
        var data = {
            currentIndex: currentIndex
        };
        base.AJAX_POST(action, data, 'html',
        function(html) {
            $('#user_table').empty().append($(html));
        });
    }
},
/*
		 * 新增页面JS
		 */
su.account.addUser = {
    init: function() {
        this.btn.init();
    },
    btn: {
        init: function() {
            this.saveUser();
            this.cancelUser();
        },
        cancelUser: function() {
            $("#cancel").click(function() {
                var action = 'account/userList.do';
                base.getAction(action);
            });
        },
        saveUser: function() {
            function validateUser(userName, password, nike, conpass) {
                if (userName == "" || userName == null) {
                    bootbox.alert("请输入用户名");
                    return false;
                } else if (password == null || password == "") {
                    bootbox.alert("请输入密码");
                    return false;
                } else if (conpass == null || conpass == "") {
                    bootbox.alert("请确认密码");
                    return false;
                } else if (nike == null || nike == "") {
                    bootbox.alert("请输入使用");
                    return false;
                } else if (conpass != password) {
                    bootbox.alert("两次输入的信息不一样");
                    return false;
                }
                return true;
            };

            $("#saveUser").click(function() {
                var userName = $("#userName").val();
                var password = $("#password").val();
                var nike = $("#nickname").val();
                var roleId = $("#roleId option:selected").val();
                var conpass = $("#conpass").val();
                if (validateUser(userName, password, nike, conpass)) {
                    $.ajax({
                        type: 'post',
                        url: 'saveUser.do',
                        data: {
                            roleId: roleId,
                            username: userName,
                            password: password,
                            nike: nike
                        },
                        beforeSend: function() {
                            $("#saveUser").attr("disabled", "disabled");
                        },

                        success: function(data) {
                            if ("true" == data) {
                                bootbox.alert("操作成功!",
                                function() {
                                    var action = 'account/userList.do?menuId=2';
                                    base.getAction(action);
                                });
                            } else if ("false" == data) {
                                bootbox.alert("操作失败!",
                                function() {
                                    var action = 'account/userList.do?menuId=2';
                                    base.getAction(action);
                                });
                            } else if ("error" == data) {
                                bootbox.alert("此用户已经存在");
                            }
                        }

                    });
                }
            });
        }
    }
};
// 用户列表JS
su.account.userList = {
    init: function() {
        this.page.init();
    },
    page: {
        init: function() {
            this.loadUserTable();
        },

        loadUserTable: function() {
            su.account.comFn.toUserTable(1);
        }
    }

},

su.account.userTable = {
    init: function() {
        this.page.init();
        this.btn.init();
        this.opreation.init();
    },
    btn: {
        init: function() {
            this.addUser();
        },
        addUser: function() {
            $("#addUser").click(function() {
                var action = "account/addUser.do";
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
                    su.account.comFn.toUserTable(p);
                }
            });
        }
    },
    opreation: {
        init: function() 
        {
        	
        },
        editPass: function(id) {
            var action = 'updatePwd.do?id=' + id;
            base.getAction(action);
        },
        updateRole: function(id) {
            var action = 'account/updateRole.do?id=' + id;
            base.getAction(action);
        },
        resetPass:function(id){
            bootbox.dialog({
                message: "确定对该用户进行重置密码操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../account/updateUserPwd.do',
                                data: {
                                    userId: id
                                },
                                success: function(data) {
                                    if ("error" == data) {
                                        bootbox.alert('此用户不可进行该操作');
                                    } else if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        su.account.comFn.toUserTable(1);

                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        su.account.comFn.toUserTable(1);
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
        },
        
        updateStatus: function(userId, status) {
            bootbox.dialog({
                message: "确定对该用户进行该操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../account/updateUserStatus.do',
                                data: {
                                    userId: userId,
                                    status: status
                                },
                                success: function(data) {
                                    if ("error" == data) {
                                        bootbox.alert('此用户不可进行该操作');
                                    } else if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        su.account.comFn.toUserTable(1);

                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        su.account.comFn.toUserTable(1);
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
su.account.update = {
    init: function() {
        this.btn.init();
    },
    btn: {
        init: function() {
            this.saveUser();
            this.cancelUser();
            this.roleId();
        },
        roleId: function() {
            var roleIdInput = $("#roleIdInput").val();
            $("#roleId").val(roleIdInput);
        },
        cancelUser: function() {
            $("#cancel").click(function() {
                var action = 'account/userList.do';
                base.getAction(action);
            });
        },
        saveUser: function() {
            $("#saveUser").click(function() {
                $.ajax({
                    type: 'post',
                    url: 'update.do',
                    data: {
                        roleIds: $("#roleId").val(),
                        id: $("#userId").val()
                    },
                    beforeSend: function() {
                        $("#saveUser").attr("disabled", "disabled");
                    },
                    success: function(data) {
                        if ("true" == data) {
                            bootbox.alert("操作成功!",
                            function() {
                                var action = 'account/userList.do?menuId=2';
                                base.getAction(action);
                            });
                        } else if ("false" == data) {
                            bootbox.alert("操作失败!",
                            function() {
                                var action = 'account/userList.do?menuId=2';
                                base.getAction(action);
                            });
                        } else if ("error" == data) {
                            bootbox.alert("此用户已经存在...",function(){
                            $("#saveUser").attr("disabled", false);           	
                            });
                        }
                    }

                });
            });
        }
    }
};