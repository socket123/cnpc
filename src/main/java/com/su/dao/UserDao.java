package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.entity.User;

public interface UserDao extends BaseDao<User> {

	public User getUserInfo(Map<String, Object> maps);

	Integer queryPageCount(Map<String, Object> maps);

	List<User> queryPage(Map<String, Object> maps);

	int insert(User user);

	int insertSelective(User user);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User user);

	int updateByPrimaryKey(User user);

	User selectByPrimaryKey(Integer id);

	List<User> queryByName(String userName);

}
