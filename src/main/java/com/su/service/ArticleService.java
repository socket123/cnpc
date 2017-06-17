package com.su.service;

import java.util.List;
import java.util.Map;

import com.su.entity.Article;
import com.su.entity.Article;
import com.su.utils.Page;

/**
 * Created by James on 2016/08/31.
 */
public interface ArticleService extends BaseService<Article>{
    public Article getArticleInfo(Map<String, Object> maps);

    Page<Article> queryPage(Integer currentIndex, Integer pageNum,Map<String, Object> maps);

    int insert(Article article);

    int insertSelective(Article article);

    Article selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article article);

    int updateByPrimaryKey(Article article);

    Article selectByPrimaryKey(Integer id);

    List<Article> queryByName(String articleName);

    List<Article> queryPageAlles (Map<String, Object> maps);
    
    
}
