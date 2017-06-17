package com.su.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Article;
import com.su.entity.Topic;
import com.su.entity.User;
import com.su.service.ArticleService;
import com.su.service.TopicService;

/**
 * @author Administrator
 */
@Controller
public class ArticleAction extends BaseAction {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService keyWordService;

    /**
     * 文章表页面
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "article/articleList")
    public String userList(HttpServletRequest request, ModelMap map) {
        map.put(StrConstant.PAGE, Forward.ActionPage.ARTICLELIST);
        return Forward.ActionPage.PUBLIC;
    }


    @RequestMapping(value = "article/articleTable")
    public String userTable(HttpServletRequest request, ModelMap map,
            Integer currentIndex) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }
        List<Article> dataLIst=new ArrayList<>();
        Page<Article> pages = articleService.queryPage(currentIndex, 10, maps);

        for(Article a:pages.getDataList()){
            if (StringUtils.isNotEmpty(a.getKeywords().toString())) {
                Topic t=keyWordService.queryById(a.getKeywords());
                a.setKeywordText(t.getName());

            }
            dataLIst.add(a);

        }
        pages.setDataList(dataLIst);

            map.put("pages", pages);

        return Forward.ActionPage.ARTICLETABLE;
    }

    /**
     * 文章页面
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "article/toArticlePage")
    public String toArticlePage(HttpServletRequest request, ModelMap map) {
        map.put(StrConstant.PAGE, Forward.ActionPage.ARTICLELIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 添加文章界面
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "article/addArticle")
    public String addArticle(HttpServletRequest request, ModelMap map) {
        List<Topic> keywordList = new ArrayList<Topic>();
        keywordList = keyWordService.loadAll(null);
        map.put("keywordList", keywordList);
        map.put(StrConstant.PAGE, Forward.ActionPage.ADDARTICLE);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 删除文章
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "article/delArticle")
    public String delArticle(HttpServletRequest request, ModelMap map, Integer id) {
        articleService.deleteByPrimaryKey(id);
        map.put(StrConstant.PAGE, Forward.ActionPage.ARTICLELIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 编辑文章
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "article/editArticle")
    public String editArticle(HttpServletRequest request, ModelMap map,
            Integer id) {
        HashMap<String, Object> maps = new HashMap<>();
        Article article = articleService.selectByPrimaryKey(id);
        map.put("article", article);
        List<Topic> keywordList = new ArrayList<>();
        keywordList = keyWordService.loadAll(null);
        map.put("keywordList", keywordList);

        map.put(StrConstant.PAGE, Forward.ActionPage.ARTICLEUPDATE);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 更新文章
     * 
     * @param request
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "article/updateArticle", produces = "application/json;charset=utf-8")
    public String updateArticle(HttpServletRequest request, Article article) {

        try {
            if (article.getId() != null) {
                System.out.print(article.getContent()+">>>");
                article.setContent(article.getContent());
                article.setCreatetime(DateUtils.currentDatetime());
                article.setImage(SystemConfig.readValue("SERVER_URL") + "uploadfile/" + article.getImage());

                articleService.updateByPrimaryKey(article);
                return "true";
            }
            else {
                return "error";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 保存文章
     * 
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "article/saveArticle", produces = "application/json;charset=utf-8")
    public String saveArticle(HttpServletRequest request, Article article) {

        try {
            if (article != null) {
                article.setCreatetime(DateUtils.currentDatetime());
                User user = (User) CommonUtil.getSessionObj(request, StrConstant.USER);// 获取当前用户名
                article.setCreateusername(user.getUsername());
                article.setCreateuser(user.getId());
                article.setImage(SystemConfig.readValue("SERVER_URL") + "uploadfile/" + article.getImage());
                articleService.insert(article);
                return "true";
            }
            else {
                return "error";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
