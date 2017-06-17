package com.su.service;

import java.util.List;
import java.util.Map;

import com.su.utils.Page;

/**
 * Created by 2015/5/4.
 */
public interface BaseService<T> {

	List<T> loadAll(Map<String, Object> maps);

	/**
	 * 统计查询的数量
	 *
	 * @param maps
	 * @return
	 */
	Integer queryPageCount(Map<String, Object> maps);


	Page<T> queryPage(Integer currentIndex, Integer pageNum,
					  Map<String, Object> maps);
	int deleteByPrimaryKey(String id);

	int insert(T t);

	int insertSelective(T t);

	T selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);

	T selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);


	List<T> queryAll(Map<String, Object> maps);

	List<T> queryBySql(Map<String, Object> maps);

	void save(T t);

	void update(T t);

	void delete(Long id);

	T load(Long id);


	T load(String id);

	void delete(String id);

	List<T> search(Map<String, Object> maps);

	/**
	 * 统计查询的数量
	 *
	 * @param maps
	 * @return
	 */
	Integer searchCount(Map<String, Object> maps);

	Page<T> searchQueryPage(Integer currentIndex, Integer pageNum,
							Map<String, Object> maps);

}
