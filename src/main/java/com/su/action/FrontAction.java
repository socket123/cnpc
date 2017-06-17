package com.su.action;

import com.su.constant.Forward;
import com.su.entity.*;
import com.su.service.ArticleService;
import com.su.service.KeyWordService;
import com.su.service.TopicService;
import com.su.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/10/26.
 * 前台
 */
@Controller
public class FrontAction  extends  BaseAction{
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService keyWordService;

    @Autowired
    private KeyWordService keyWordServicees;

    @Autowired
    com.su.service.ActivityService ActivityService;

    @Autowired
    com.su.service.FrontMenuService     FrontMenuService;

    @Autowired
    private com.su.service.BannerService BannerService;

    @Autowired
    private com.su.service.ActivityJoinService activityJoinService;

    private Logger log = Logger.getLogger(IndexAction.class);

    @Autowired
    com.su.service.DataService DataService;
    /**
     * 前台首页
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "findex")
    public String findex(HttpServletRequest request, ModelMap map,Integer currentIndex) throws ParseException {
        StringUtil ustil = new StringUtil();
        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
        Page<Article> pages = new Page<Article>();
        maps.put("keywordId",9);
         pages = articleService.queryPage(currentIndex, 9, maps);// 通知公告
        if (pages.getPageNum() > 0){
            List<Article> s =   pages.getDataList();
            List <Article> sr = new ArrayList<>();
            for (Article a : s ){

                String Createtime = DateUtils.formatDate( DateUtils.currentdateFormat(a.getCreatetime()));
//
                System.out.println("通知");
                a.setCreatetime(Createtime);
                sr.add(a);
                }


            pages.setDataList(sr);
        }

        Page<Article> pagesnew = new Page<>();
        Map<String, Object> mapsnew = new HashMap<String, Object>();
        mapsnew.put("keywordId",10);
        pagesnew = articleService.queryPage(1, 9, mapsnew);// 新闻动态
        if (pagesnew.getPageNum() > 0){
            List<Article> snew =   pagesnew.getDataList();
            List <Article> srnew = new ArrayList<>();
            for (Article as : snew  ){
                String Createtime = DateUtils.formatDate( DateUtils.currentdateFormat(as.getCreatetime()));
                System.out.println("新闻动态");
                as.setCreatetime(Createtime);
                srnew.add(as);
            }
            pagesnew.setDataList(srnew);
        }

        Map<String, Object> mapsyAxtivit  = new HashMap<String, Object>();
        Page<Activity> pagesAxtivit = new Page<>();

        pagesAxtivit = ActivityService.queryPage(currentIndex,9, maps);// 培训公告

        Map<String, Object> mapsMenu = new HashMap<String, Object>();

        Page<FrontMenu> pagesMenu = FrontMenuService.queryPage(1, 100, mapsMenu);//前台菜单分类

        Map<String, Object> mapsBanner = new HashMap<String, Object>();
        String type = "1";
        if (StringUtils.isNotEmpty(type)) {
            mapsBanner.put("type", type);
        }
        Page<Banner> pageBanner = BannerService.queryPage(1, 100, mapsBanner);//前台首页banner图片

        Map<String, Object> mapsBannerZB = new HashMap<String, Object>();
        String typezb = "2";
        if (StringUtils.isNotEmpty(typezb)) {
            mapsBannerZB.put("type", typezb);
        }
        Page<Banner> pageBannerZB = BannerService.queryPage(1, 100, mapsBannerZB);//前台首页banner图片

        Map<String, Object> mapskeyword = new HashMap<String, Object>();

        Page<Keyword> pageskeyw = keyWordServicees.queryPage(1, 10, mapskeyword);// 产品分类

        Map<String, Object> mapsdata = new HashMap<String, Object>();

//        mapsdata.put("",)
        Page<Data> pagesdata = DataService.queryPage(1, 3, mapsdata);

        request.setAttribute("pageskeyw",pageskeyw);

        request.setAttribute("pageBannerZB",pageBannerZB);
        request.setAttribute("pageBanner",pageBanner);
        request.setAttribute("pagesMenu",pagesMenu);
        request.setAttribute("pagesnew",pagesnew);
        request.setAttribute("pagesAxtivit",pagesAxtivit);
        request.setAttribute("pages",pages);

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
        return Forward.ActionPage.FRONTINDEX;
    }



    /**
     * 通知公告
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "tongzhi")
    public String tongzhi(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
//        maps.put("specialId",9);
        maps.put("keywordId",9);
        Page<Article> pages = articleService.queryPage(currentIndex, 20, maps);
            request.setAttribute("pages",pages);

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.TONGZHI" + Forward.ActionPage.TONGZHI);
        return Forward.ActionPage.TONGZHI;
    }


    /**
     * 软件新闻 WinRAR产品介绍
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "winRAR")
    public String winRARwapruanjian(HttpServletRequest request, ModelMap map,Integer keywordId ) {

        if (keywordId == null){
            log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
            return Forward.ActionPage.FRONTINDEX;
        }else {

            Article articles  = articleService.selectByPrimaryKey(keywordId);// 上部


            request.setAttribute("articles",articles);

        }

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);
        log.info("Forward.ActionPage.WAPRUANJ" + Forward.ActionPage.WAPRUANJ);
        return Forward.ActionPage.WAPRUANJ;
    }
    /**
     * 软件新闻 WPS产品介绍
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "wps")
    public String WPSWapruanjian(HttpServletRequest request, ModelMap map,Integer keywordId ) {

        if (keywordId == null){
            log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
            return Forward.ActionPage.FRONTINDEX;
        }else {


          Article articles  = articleService.selectByPrimaryKey(keywordId);// 上部


            request.setAttribute("articles",articles);

        }

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

       List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);


        log.info("Forward.ActionPage.WAPRUANJ" + Forward.ActionPage.WAPRUANJ);
        return Forward.ActionPage.WAPRUANJ;
    }
    /**
     * 软件新闻 oracle产品介绍
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "oracle")
    public String oracleWapruanjian(HttpServletRequest request, ModelMap map,Integer keywordId ) {

        if (keywordId == null){
            log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
            return Forward.ActionPage.FRONTINDEX;
        }else {


            Article articles  = articleService.selectByPrimaryKey(keywordId);// 上部


            request.setAttribute("articles",articles);

        }

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.WAPRUANJ" + Forward.ActionPage.WAPRUANJ);
        return Forward.ActionPage.WAPRUANJ;
    }
    /**
     * 软件新闻 window产品介绍
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "window")
    public String windowWapruanjian(HttpServletRequest request, ModelMap map,Integer keywordId ) {

        if (keywordId == null){
            log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
            return Forward.ActionPage.FRONTINDEX;
        }else {


            Article articles  = articleService.selectByPrimaryKey(keywordId);// 上部


            request.setAttribute("articles",articles);

        }

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);
        log.info("Forward.ActionPage.WAPRUANJ" + Forward.ActionPage.WAPRUANJ);
        return Forward.ActionPage.WAPRUANJ;
    }

    /**
     * 关于我们
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "user")
    public String guanyuMe(HttpServletRequest request, ModelMap map, Integer keywordId) {

        if (keywordId == null){
            log.info("Forward.ActionPage.FRONTINDEX" + Forward.ActionPage.FRONTINDEX);
            return Forward.ActionPage.FRONTINDEX;
        }else {

            Article articles  = articleService.selectByPrimaryKey(keywordId);// 上部


            request.setAttribute("articles",articles);

        }

        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.GUANYUWOMEN" + Forward.ActionPage.GUANYUWOMEN);
        return Forward.ActionPage.GUANYUWOMEN;
    }
    /**
     * 新闻资讯
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "newzixun")
    public String newzixun(HttpServletRequest request, ModelMap map,Integer currentIndex) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
        maps.put("keywordId",10);
//        maps.put("specialId",10);

        Page<Article> pages = articleService.queryPage(currentIndex, 20, maps);
        request.setAttribute("pages",pages);

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.NEWDONGTAI" + Forward.ActionPage.NEWDONGTAI);
        return Forward.ActionPage.NEWDONGTAI;
    }


    /**
     * 资料共享
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "ziliaofen")
    public String ziliaofen(HttpServletRequest request, ModelMap map, Integer currentIndex,String type ) throws UnsupportedEncodingException {


        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }
        String result ="";
        if (StringUtils.isNotEmpty(type)){

            result = new String(type.getBytes("iso-8859-1"),"utf-8");
            maps.put("type", result);
        }

        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<Data> pages = DataService.queryPage(currentIndex, 20, maps);

        Map<String, Object> mapskeyword = new HashMap<String, Object>();

        Page<Keyword> pageskeyw = keyWordServicees.queryPage(1, 100, mapskeyword);

        request.setAttribute("type",result);
        request.setAttribute("pageskeyw",pageskeyw);
        request.setAttribute("pages",pages);


        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);


        log.info("Forward.ActionPage.ZILIAO" + Forward.ActionPage.ZILIAO);
        return Forward.ActionPage.ZILIAO;
    }
    /**
     * 资料共享详情页
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "ziliaofendeat")
    public String ziliaofendeat(HttpServletRequest request, ModelMap map, Integer currentIndex,Integer id  ) throws UnsupportedEncodingException {

        Data  date =   DataService.selectByPrimaryKey(id);

        request.setAttribute("date",date);

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);


        log.info("Forward.ActionPage.ZILIAODEAT" + Forward.ActionPage.ZILIAODEAT);
        return Forward.ActionPage.ZILIAODEAT;
    }


    /**
     * 常见问题
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "changjianWt")
    public String changjianWt(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
        maps.put("keywordidstr",14);
        Page<Article> pages = articleService.queryPage(currentIndex, 20, maps);

        Map<String, Object> mapskeyword = new HashMap<String, Object>();

        Page<Keyword> pageskeyw = keyWordServicees.queryPage(1, 20, mapskeyword);

        request.setAttribute("pageskeyw",pageskeyw);
        request.setAttribute("pages",pages);


        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);
        log.info("Forward.ActionPage.CHANGJIANWENTI" + Forward.ActionPage.CHANGJIANWENTI);
        return Forward.ActionPage.CHANGJIANWENTI;
    }
    /**
     * 常见问题软件问题分类
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "changjianWtruanj")
    public String changjianWtruanj(HttpServletRequest request, ModelMap map, Integer currentIndex,Integer keywordId ) {

        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
        if (keywordId == null) {
            keywordId = 14;
        }

        maps.put("keywordId",keywordId);
//        maps.put("specialId",10);

        Page<Article> pages = articleService.queryPage(currentIndex, 20, maps);

//        Map<String, Object> mapskeyword = new HashMap<String, Object>();
//
//        Page<Keyword> pageskeyw = keyWordServicees.queryPage(1, 10, mapskeyword);
//
//        request.setAttribute("pageskeyw",pageskeyw);
        request.setAttribute("pages",pages);
        request.setAttribute("keywordId",keywordId);



        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.CHANGJIANWENTIRUANJ" + Forward.ActionPage.CHANGJIANWENTIRUANJ);
        return Forward.ActionPage.CHANGJIANWENTIRUANJ;
    }


    /**
     * 培训计划
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "baoming")
    public String baoming(HttpServletRequest request, ModelMap map, Integer currentIndex) throws ParseException {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }
        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<Activity> pages = ActivityService.queryPage(currentIndex, 12, maps);
        List<Activity> activitiesList  = new ArrayList<Activity>();
       for (int i = 0 ; i <  pages.getDataList().size() ; i ++){
           Activity activity = new Activity();
           String countactive = StringUtil.getTextFromHtml_12(pages.getDataList().get(i).getContent());
           activity = pages.getDataList().get(i);
           activity.setCountactive(countactive);
           activitiesList.add(activity);
       }
        pages.setDataList(activitiesList);
        map.put("pages", pages);


        Map<String, Object> mapsfromt = new HashMap<String, Object>();

        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.BAOMING" + Forward.ActionPage.BAOMING);
        return Forward.ActionPage.BAOMING;
    }
//    /**
//     * 培训计划提交
//     * @param request
//     * @param map
//     * @return
//     */
//    @RequestMapping(value = "baomingtijiao")
//    public String baomingtijiao(HttpServletRequest request, ModelMap map, Integer currentIndex,ActivityJoin activityJoin) {
//        Map<String, Object> maps = new HashMap<String, Object>();
//        if (currentIndex == null || currentIndex == 0) {
//            currentIndex = 1;
//        }
//        if(activityJoin == null){
//            log.info("Forward.ActionPage.BAOMING" + Forward.ActionPage.BAOMING);
//            return Forward.ActionPage.BAOMING;
//        }
//        activityJoinService.insert(activityJoin);
//        String  message = "1";
//        maps.put("currentIndex", currentIndex);
//        maps.put("endIndex", currentIndex);
//        Page<Activity> pages = ActivityService.queryPage(currentIndex, 5, maps);
//        map.put("pages", pages);
//        map.put("message", message);
//        log.info("Forward.ActionPage.BAOMING" + Forward.ActionPage.BAOMING);
//        return Forward.ActionPage.BAOMING;
//    }


    /**
     * 培训计划时间选择显示
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("baomingtijiatime")
    public ModelAndView baomingtijiatime(HttpServletRequest request, ModelMap map, Integer id) throws ParseException {
//        Map<String, Object> mapsle = new HashMap<String, Object>();
        Activity activity =  ActivityService.selectByPrimaryKey(id);
       String [] string =  ArrayUtil.strToArray(activity.getStarttime(),"-");
       String strings =  ArrayUtil.str(string);
       String [] strinend =  ArrayUtil.strToArray(activity.getEndtime(),"-");
       String stringenf =  ArrayUtil.str(strinend);
        List<String > stringss  = DateUtil.timeList(strings,stringenf);
        if(null != stringss && stringss.size() == 0){
            stringss.add(strings);
        }
        return new ModelAndView("jsonView", "rCode", stringss);
    }

    /**
     * 培训计划提交
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("baomingtijiaoActions")
    public String baomingtijiaoActions(HttpServletRequest request, ModelMap map,ActivityJoin activityJoin){
    if (   activityJoinService.insert(activityJoin) > 0){
            return "true";
        }else {
            return "false";
        }
    }
    /**
     * 判断随机码
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("randomcodeActions")
    public String randomcodeActions(HttpServletRequest request, ModelMap map, String randomcode,Integer id){
       Activity activity =  ActivityService.selectByPrimaryKey(id);
        if (activity.getRandomcode().equals(randomcode)){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 新闻文章详情计划
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "newAcdetails")
    public String newAcdetails(HttpServletRequest request, ModelMap map ,Integer id) {
        Article article =  articleService.selectByPrimaryKey(id);
        request.setAttribute("article",article);


        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);


        log.info("Forward.ActionPage.NEWDONGDEAT" + Forward.ActionPage.NEWDONGDEAT);
        return Forward.ActionPage.NEWDONGDEAT;
    }
    /**
     * 问题文章详情计划
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "changjWendetails")
    public String changjWendetails(HttpServletRequest request, ModelMap map ,Integer id) {
        Article article =  articleService.selectByPrimaryKey(id);
        request.setAttribute("article",article);


        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.CHANGJIANDEAT" + Forward.ActionPage.CHANGJIANDEAT);
        return Forward.ActionPage.CHANGJIANDEAT;
    }
    /**
     *通知公告 文章详情计划
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "Articledetails")
    public String Articledetails(HttpServletRequest request, ModelMap map ,Integer id) {
        Article article =  articleService.selectByPrimaryKey(id);
        request.setAttribute("article",article);


        List<FrontMenu> frontMenus = FrontMenuService.queryAllese(null);

        List<FrontMenu> fronList = new ArrayList<FrontMenu>();
        List<FrontMenu> fronListGuan = new ArrayList<FrontMenu>();
        for (FrontMenu fonr:   frontMenus ){
            if ("WPS".equals(fonr.getMenuname()) || "WinRAR".equals(fonr.getMenuname()) || "Oracle".equals(fonr.getMenuname()) || "微软产品产品".equals(fonr.getMenuname()) ){
                fronList.add(fonr);
            }
            if ("关于我们".equals(fonr.getMenuname()) ){
                fronListGuan.add(fonr); ;
            }
        }
        request.setAttribute("fronList",fronList);
        request.setAttribute("fronListGuan",fronListGuan);

        log.info("Forward.ActionPage.WENZHANGDEAT" + Forward.ActionPage.WENZHANGDEAT);
        return Forward.ActionPage.WENZHANGDEAT;
    }

}
