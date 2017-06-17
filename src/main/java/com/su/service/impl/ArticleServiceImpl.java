package com.su.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.ArticleDao;
import com.su.entity.Article;
import com.su.entity.Menu;
import com.su.service.ArticleService;
import com.su.utils.Page;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements
ArticleService {

	@Autowired
	private ArticleDao articleDao;

	public Article getArticleInfo(Map<String, Object> maps) {
		Article article = articleDao.getUserInfo(maps);
		if (null != article) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			
			}
		
		return article;
	}

	@Override
	public Page<Article> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps) {

		return new Page<Article>(articleDao, currentIndex, pageNum, maps);
	}

	private void setMenuVoList(List<Menu> parentMenuList,
			List<Menu> chilidMenuList) {
		for (Menu parentMenu : parentMenuList) {
			for (Menu chilidMenu : chilidMenuList) {
				if (parentMenu.getId() == chilidMenu.getParentId()) {
					parentMenu.getChildMenu().add(chilidMenu);
				}
			}
		}

	}

	public int insert(Article article) {
		return articleDao.insert(article);
	}

	public int insertSelective(Article article) {
		return articleDao.insert(article);
	}

	public Article selectByPrimaryKey(Integer id) {
		return articleDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Article article) {
		return articleDao.updateByPrimaryKeySelective(article);
	}

	public int updateByPrimaryKey(Article article) {
		return articleDao.updateByPrimaryKey(article);
	}
    
	public int  deleteByPrimaryKey(Integer id){
	    
	    return articleDao.deleteByPrimaryKey(id);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.UserInfoService#queryByName(java.lang.String)
	 */
	@Override
	public List<Article> queryByName(String userName) {
		// TODO Auto-generated method stub
		return articleDao.queryByName(userName);
	}

	@Override
	public List<Article> queryPageAlles(Map<String, Object> maps) {
		return queryPageAlles(maps);
	}

}
