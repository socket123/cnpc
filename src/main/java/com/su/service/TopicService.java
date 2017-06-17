package com.su.service;

import java.util.Map;

import com.su.entity.Topic;
import com.su.utils.Page;

public interface TopicService extends BaseService<Topic> {

    boolean addTopic(Topic topic);

    boolean delTopic(Integer id);

    boolean queryAll();

    boolean updateTopic(Topic topic);

    Page<Topic> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps);

    Topic queryById(Integer id);

    Topic verifyByName(String name);
}
