package com.su.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.BaseDao;
import com.su.service.BaseService;
import com.su.utils.Page;

/**
 * Created by 褰�on 2015/5/4.
 */
@Service
public class BaseServiceImpl<PkEntity> implements BaseService<PkEntity> {
	@Autowired
	private BaseDao<PkEntity> baseDao;

	@Override
	public void save(PkEntity pkEntity) {
		baseDao.save(pkEntity);
	}

	@Override
	public void update(PkEntity pkEntity) {
		baseDao.update(pkEntity);
	}

	@Override
	public void delete(Long id) {
		baseDao.delete(id);
	}

	@Override
	public PkEntity load(Long id) {
		return baseDao.load(id);
	}

	@Override
	public List<PkEntity> loadAll(Map<String, Object> maps) {
		return baseDao.loadAll(maps);
	}

	@Override
	public Page<PkEntity> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps) {

		return new Page<PkEntity>(baseDao, currentIndex, pageNum, maps);
	}

	@Override
	public List<PkEntity> search(Map<String, Object> maps) {
		return baseDao.search(maps);
	}

	@Override
	public Page<PkEntity> searchQueryPage(Integer currentIndex,
			Integer pageNum, Map<String, Object> maps) {
		return new Page<PkEntity>(baseDao, currentIndex, pageNum, maps);
	}

	@Override
	public PkEntity load(String id) {
		return baseDao.load(id);
	}

	@Override
	public void delete(String id) {
		baseDao.delete(id);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PkEntity t) {
		return baseDao.insert(t);
	}

	@Override
	public int insertSelective(PkEntity t) {
		return baseDao.insert(t);
	}

	@Override
	public PkEntity selectByPrimaryKey(String id) {
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PkEntity t) {
		return baseDao.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(PkEntity t) {
		return baseDao.updateByPrimaryKey(t);
	}

	@Override
	public List<PkEntity> queryAll(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(maps);
	}

	@Override
	public List<PkEntity> queryBySql(Map<String, Object> maps) {
		return baseDao.queryBySql(maps);
	}

	@Override
	public Integer queryPageCount(Map<String, Object> maps) {
		return baseDao.queryPageCount(maps);
	}

	@Override
	public Integer searchCount(Map<String, Object> maps) {
		return baseDao.searchCount(maps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.BaseService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public PkEntity selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.BaseService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.deleteByPrimaryKey(id);
	}
}
