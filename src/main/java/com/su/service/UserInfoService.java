package com.su.service;

import java.util.List;
import java.util.Map;

import com.su.entity.User;
import com.su.utils.Page;

public interface UserInfoService extends BaseService<User> {
	public User getUserInfo(Map<String, Object> maps);

	Page<User> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps);

	int insert(User user);

	int insertSelective(User user);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User user);

	int updateByPrimaryKey(User user);

	User selectByPrimaryKey(Integer id);

	List<User> queryByName(String userName);

}
