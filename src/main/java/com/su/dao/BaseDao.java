package com.su.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by 胡彪 on 2014/7/2.
 */
public interface BaseDao<T> {
	void save(T t);

	void update(T t);

	void delete(Long id);

	T load(Long id);

	List<T> loadAll(Map<String, Object> maps);

	/**
	 * 统计查询的数量
	 * 
	 * @param maps
	 * @return
	 */
	Integer queryPageCount(Map<String, Object> maps);

	List<T> searchQueryPage(Map<String, Object> maps);

	List<T> search(Map<String, Object> maps);

	/**
	 * 统计查询的数量
	 * 
	 * @param maps
	 * @return
	 */
	Integer searchCount(Map<String, Object> maps);

	List<T> queryPage(Map<String, Object> maps);

	T load(String id);

	void delete(String id);

	int deleteByPrimaryKey(String id);

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);

	List<T> queryAll(Map<String, Object> maps);

	List<T> queryBySql(Map<String, Object> maps);

	List<Map<String, Object>> query(Map<String, Object> maps);

	int isExistAppId(String serveId);

	T selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);

}
