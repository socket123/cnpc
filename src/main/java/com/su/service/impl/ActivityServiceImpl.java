package com.su.service.impl;

import com.su.dao.ActivityMapper;
import com.su.entity.Activity;
import com.su.service.ActivityService;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/27.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Activity> loadAll(Map<String, Object> maps) {
        return activityMapper.loadAll(maps);
    }

    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        return activityMapper.queryPageCount(maps);
    }

    @Override
    public Page<Activity> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<Activity>(activityMapper,currentIndex,pageNum,maps);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Activity activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public int insertSelective(Activity activity) {
        return activityMapper.insertSelective(activity);
    }

    @Override
    public Activity selectByPrimaryKey(String id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    @Override
    public int updateByPrimaryKey(Activity activity) {
        return activityMapper.updateByPrimaryKey(activity);
    }

    @Override
    public Activity selectByPrimaryKey(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Activity> queryAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<Activity> queryBySql(Map<String, Object> maps) {
        return null;
    }

    @Override
    public void save(Activity activity) {

    }

    @Override
    public void update(Activity activity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Activity load(Long id) {
        return null;
    }

    @Override
    public Activity load(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Activity> search(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer searchCount(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Page<Activity> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return null;
    }
}
