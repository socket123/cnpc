package com.su.constant;

public interface Forward {

    public interface AjaxPage {
        public String LEFTMENU = "menu/leftMenu";
    }

    public interface ActionPage {

        public String PUBLIC = "public";

        public String LOGIN = "login";

        public String INDEX = "index.jsp";

        public String USERTABLE = "account/userTable";

        public String USERLIST = "account/userList.jsp";

        public String UPDATEROLE = "account/updateRole.jsp";

        public String ADDUSER = "account/add.jsp";

        public String ROLELIST = "role/roleList.jsp";

        public String ROLETABLE = "role/roleTable";

        public String ROLEMENULIST = "role/menuList.jsp";

        public String UPDATEPWD = "updatePwd.jsp";

        public String LINKUS = "link.jsp";

        public String LINKTABLE = "linkTable";

        public String ERROR = "error.jsp";

        public String TOPICLIST = "topic/topicList.jsp";

        public String TOPICTABLE = "topic/topicTable";

        public String ADDTOPIC = "topic/addTopic.jsp";

        /**
         * 文章
         */
        public String ARTICLETABLE = "article/articleTable";

        public String ARTICLELIST = "article/articleList.jsp";

        public String ARTICLEUPDATE = "article/update.jsp";

        public String ADDARTICLE = "article/add.jsp";

        // 资料分类列表
        public String KEYWORDLIST = "keyword/list.jsp";

        // 资料分类
        public String KEYWORDTABLE = "keyword/listTable";

        // 新增资料分类
        public String ADDKEYWORD = "keyword/add.jsp";

        // 更新操作
        public String UPDATEKEYWORD = "keyword/update.jsp";
        /**
         *前台菜单
         *
         * */
        public String FRONTMENUADD="frontmenu/add.jsp";
        public String FRONTMENULIST="frontmenu/List.jsp";
        public String FRONTMENULISTTABLE="frontmenu/Table";

        public String ACTIVITYADD="activity/add.jsp";
        public String ACTIVITYLIST="activity/List.jsp";
        public String ACTIVITYLISTTABLE="activity/Table";
        public String ACTIVITYJOINTABLE="activity/join.jsp";


        /*
       前台
       * */
        public  String FRONTINDEX = "front/index";//首页
        public  String BAOMING = "front/baoMing";// 报名
        public  String TONGZHI = "front/tongZhi";// 通知
        public  String NEWDONGTAI = "front/newDongtai";//新闻
        public  String WAPRUANJ = "front/wapsRuanj";// 软件产品
        public  String WENZHANGDEAT = "front/wenZhangDeat";//公告文章详情
        public  String NEWDONGDEAT = "front/newdongDeat";//新闻文章详情
        public  String CHANGJIANDEAT = "front/changjianDeat";//问题文章详情
        public  String ZILIAO = "front/ziLiao";// 资料共享
        public  String CHANGJIANWENTI = "front/changjianwenti";// 常见问题
        public  String CHANGJIANWENTIRUANJ = "front/changjianwentiRuanjian";// 常见问题软件分类
        public  String ZILIAODEAT = "front/ziliaoDeat";// 资料详情页
        public  String GUANYUWOMEN = "front/guanyuwome";// 关于我们

        public  String WPSRUANJIANDEAT = "front/wpsRuanjianDeat";// 软件详情



        public String DATAADD="data/add.jsp";
        public String DATALIST="data/List.jsp";
        public String DATALISTTABLE="data/Table";

        public String BannerADD="banner/add.jsp";
        public String BannerLIST="banner/List.jsp";
        public String BannerLISTTABLE="banner/Table";
        public String BannerLOGO="banner/logo.jsp";
    }
}
