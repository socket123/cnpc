var su = su || {};
su.Banner = su.Banner || {};
/**
 * 公众方法
 */
su.Banner.comFn = {
    toTopicTable: function (currentIndex) {
        var action = "Banner/BannerTable.do";
        var type = $("#type").val();

         var Banner = {
            currentIndex: currentIndex,
            type:type
        };
        base.AJAX_POST(action, Banner, "html", function (html) {
            $("#Banner_table").empty().append($(html));
        });
    }
},

    su.Banner.BannerList = {
        init: function () {
            su.Banner.comFn.toTopicTable(1);
            this.btn.init();
        },
        btn: {
            init: function () {
                this.addTopic();
            },
            addTopic: function () {
                $("#addTopic").click(function () {
                    var action = "Banner/addUpdateBanner.do?&type="+$("#type").val();
                    base.getAction(action);
                });
            }
        }
    },
    su.Banner.BannerTable = {
        init: function () {
            this.page.init();
            this.btn.init();
        },
        btn: {
            init: function () {
                this.del();
                this.updateTopic();
            },
            updateTopic: function () {
                $("[name=updateTopic]").click(function () {
                    var BannerId = $(this).attr("data-id");
                    var action = "Banner/addUpdateBanner.do?BannerId=" + BannerId+"&type="+$("#type").val();
                    base.getAction(action);
                });
            },
            del: function () {
                $.each($("[name=del]"), function () {
                    $(this).on("click", function () {
                        var id = $(this).data("id");
                        bootbox.dialog({
                            message: "确定要删除吗？",
                            title: "提示",
                            buttons: {
                                OK: {
                                    label: "确定",
                                    className: "btn-primary",
                                    callback: function () {
                                        $.ajax({
                                            url: 'delBanner.do',
                                            data: {
                                                id: id
                                            },
                                            success: function (Banner) {
                                                if ("error" == Banner) {
                                                    bootbox.alert("删除失败");
                                                } else if ("false" == Banner) {
                                                    bootbox.alert("删除失败");
                                                    su.Banner.comFn.toTopicTable(1);

                                                } else if ("true" == Banner || true == Banner) {
                                                    bootbox.alert("删除成功");
                                                    su.Banner.comFn.toTopicTable(1);
                                                }
                                            }
                                        });
                                    }
                                },
                                Cancel: {
                                    label: "取消",
                                    className: "btn-default",
                                    callback: function () {
                                    }
                                }
                            }
                        });
                    });
                });
            }
        },

        page: {
            init: function () {
                this.pagenation();
            },
            pagenation: function () {
                $(".tcdPageCode").createPage({
                    pageCount: $("#totalPage").val(),
                    current: $("#currentIndex").val(),

                    backFn: function (p) {
                        var shop_id = $('select[name=shopName] option:selected').val();
                        su.Banner.comFn.toTopicTable(p, shop_id);
                        $("#currentIndex").val($("#currentIndex").val());
                    }
                });
            },
            returnAdd: function (id) {
                var action = 'Banner/toReturn.do?Id=' + id;
                base.getAction(action);
            },
            detail: function (id) {
                var action = "Banner/BannerDetail.do?id=" + id;
                base.getAction(action);

            }
        }
    },


    su.Banner.addTopic = {
        init: function () {
            this.btn.init();
        },
        btn: {
            init: function () {
                this.saveTopic();
                this.cancelTopic();
            },
            cancelTopic: function () {
                $("[name=cancel]").click(function () {
                    var action = 'Banner/BannerList.do';
                    base.getAction(action);
                });
            },
            saveTopic: function () {
                $("#saveTopic").click(function () {
                    var id = $("#id").val();
                    var name = $("#name").val() || "";
                    var image = $("#image").val() || "";
                    var type=$("#type").val();
                    if (name == null || name == "" || name == undefined) {
                        bootbox.alert("名称不能为空！");
                        return;
                    }
                    if (image == null || image == "" || image == undefined) {
                        bootbox.alert("请选择图片");
                        return;
                    }

                    var url = 'updateBanner.do';
                    if (id == null || id == "" || id == undefined) {
                        url = 'saveBanner.do';
                    }
                    var BannerObj = {
                        id: id,
                        name: name,
                        url: image,
                        type: type
                    };
                    $.ajax({
                        type: 'post',
                        url: url,
                        data: BannerObj,

                        success: function (Banner) {
                            console.log(Banner);
                            if (true == Banner || "true" == Banner) {
                                bootbox.alert("操作成功！", function () {
                                    var action = 'Banner/BannerList.do?type='+$("#type").val();
                                    base.getAction(action);
                                });
                            } else {
                                bootbox.alert("操作异常！");
                            }
                        }
                    });
                });
            },
        }
    };
