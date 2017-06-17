var su = su || {};
su.article = su.article || {};
/**
 * 公共方法
 */
su.article.comFn = {
    toArticleTable: function (currentIndex) {
        var action = "article/articleTable.do";
        var data = {
            currentIndex: currentIndex
        };
        base.AJAX_POST(action, data, 'html',
            function (html) {
                $('#article_table').empty().append($(html));
            });
    }
},
    /*
     * 新增页面JS
     */
    su.article.addArticle = {
        init: function () {
            this.btn.init();
        },
        btn: {
            init: function () {
                this.saveArticle();
                this.cancelArticle();
            },
            cancelArticle: function () {
                $("#cancel").click(function () {
                    var action = 'article/articleList.do';
                    base.getAction(action);
                });
            },
            saveArticle: function () {    //文章添加
                function validateArticle(articleName, keywords, summary, content, isHome, isTop) {
                    if (articleName == "" || articleName == null) {
                        bootbox.alert("请输入文章标题");
                        return false;
                    } else if (summary == null || summary == "") {
                        bootbox.alert("请输入文章简介");
                        return false;
                    }
                    else if (content == null || content == "") {
                        bootbox.alert("请确入文章内容");
                        return false;
                    }
                    return true;
                };
                $("#saveArticle").click(function () {
                    var articleName = $("#articleName").val();
                    var summary = $("#summary").val();
                    var keywords = $("#keywords").val();
                    var content = $("[name='content']").val();
                    var isHome = $("#isHome").val();
                    //var createUsername = $("#createUsername").val();
                    var isTop = $("#isTop").val();
                    if (validateArticle(articleName, summary, keywords, content, isHome, isTop)) {
                        $.ajax({
                            type: 'post',
                            url: 'saveArticle.do',
                            data: {
                                title: articleName,
                                summary: summary,
                                keywords: keywords,
                                content: content,
                                //createUsername: createUsername,
                                isHome: isHome,
                                isTop: isTop,
                                image: $("#image").val() + "," + $("#image1").val() + "," + $("#image2").val()
                            },
                            beforeSend: function () {
                                $("#saveArticle").attr("disabled", "disabled");
                            },
                            success: function (data) {
                                bootbox.alert("操作成功!",
                                    function () {
                                        var action = 'article/articleList.do';
                                        base.getAction(action);
                                    });
                            }
                        });
                    }
                });
            }
        }
    };
// 用户列表JS
su.article.articleList = {
    init: function () {
        this.page.init();
    },
    page: {
        init: function () {
            this.loadArticleTable();
        },
        loadArticleTable: function () {
            su.article.comFn.toArticleTable(1);
        }
    }
},
    su.article.articleTable = {
        init: function () {
            this.page.init();
            this.btn.init();
            this.opreation.init();
        },
        btn: {
            init: function () {
                this.addArtilce();
            },
            addArtilce: function () {
                $("#addArticle").click(function () {
                    var action = "article/addArticle.do";
                    base.getAction(action);
                });
            }/*,
             updateArticle:function(id){
             $("#addArticle").click(function() {
             var action = "article/addArticle.do";
             base.getAction(action);
             });
             },*/
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
                        su.article.comFn.toArticleTable(p);
                    }
                });
            }
        },
        opreation: {
            init: function () {
            },
            editPass: function (id) {
                var action = 'updatePwd.do?id=' + id;
                base.getAction(action);
            },
            updateRole: function (id) {
                var action = 'article/updateRole.do?id=' + id;
                base.getAction(action);
            },
            delArticle: function (id) {
                bootbox.dialog({
                    message: "确定删除该文章？",
                    title: "提示信息",
                    buttons: {
                        OK: {
                            label: "确定",
                            className: "btn-primary",
                            callback: function () {
                                $.ajax({
                                    url: '../article/delArticle.do',
                                    data: {
                                        id: id
                                    },
                                    success: function (data) {
                                        bootbox.alert("操作成功");
                                        su.article.comFn.toArticleTable(1);
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
            },
            editArticle: function (id) {
                bootbox.dialog({
                    message: "确定对修改文章？",
                    title: "提示信息",
                    buttons: {
                        OK: {
                            label: "确定",
                            className: "btn-primary",
                            callback: function () {
                                $.ajax({
                                    url: '../article/editArticle.do',
                                    data: {
                                        id: id
                                    },
                                    success: function (data) {
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
            }
        }
    };
/*
 * 修改页面JS
 */
su.article.updateArticle = {
    init: function () {
        this.btn.init();
    },
    btn: {
        init: function () {
            this.updateArticle();
            this.cancelArticle();
        },
        cancelArticle: function () {
            $("#cancel").click(function () {
                var action = 'article/articleList.do';
                base.getAction(action);
            });
        },
        updateArticle: function () {
            $("#updateArticle").click(function () {
                var dataobj = {
                    title: $("#articleName").val(),
                    id: $("#articleId").val(),
                    summary: $("#summary").val(),
                    keywords: $("#keywords").val(),
                    content: $("[name='content']").val(),
                    createusername: $("#createUsername").val(),
                    isHome: $("#isHome").val(),
                    isTop: $("#isTop").val(),
                    image: $("#image").val()
                };
                $.ajax({
                    type: 'post',
                    url: '../article/updateArticle.do',
                    data: dataobj,
                    beforeSend: function () {
                        //$("#updateArticle").attr("disabled", "disabled");
                    },
                    success: function (data) {
                        bootbox.alert("操作成功!",
                            function () {
                                var action = 'article/articleList.do';
                                base.getAction(action);
                            });
                    }
                });
            });
        }
    }
};