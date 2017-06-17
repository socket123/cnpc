package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.entity.Article;

public interface ArticleDao extends BaseDao<Article> {

	public Article getUserInfo(Map<String, Object> maps);

	Integer queryPageCount(Map<String, Object> maps);

	List<Article> queryPage(Map<String, Object> maps);

	int insert(Article article);

	int insertSelective(Article article);

	Article selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Article article);

	int updateByPrimaryKey(Article article);
	
	int  deleteByPrimaryKey(Integer id);

	Article selectByPrimaryKey(Integer id);

	List<Article> queryByName(String title);

	List<Article> queryPageAlles (Map<String, Object> maps);
}
