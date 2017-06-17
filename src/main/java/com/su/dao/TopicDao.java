package com.su.dao;

import com.su.entity.Topic;

public interface TopicDao extends BaseDao<Topic>{
	
	boolean addTopic(Topic topic);
	
	boolean delTopic(Integer id);
	
	boolean queryAll();
	
	boolean updateTopic(Topic topic);
	
	Topic queryById(Integer id);
	
	Topic verifyByName(String name);
}
