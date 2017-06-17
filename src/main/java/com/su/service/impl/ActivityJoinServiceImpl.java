package com.su.service.impl;

import com.su.dao.ActivityJoinMapper;
import com.su.entity.ActivityJoin;
import com.su.service.ActivityJoinService;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/27.
 */
@Service
public class ActivityJoinServiceImpl implements ActivityJoinService{
    @Autowired
    private ActivityJoinMapper activityJoinMapper;


    @Override
    public List<ActivityJoin> loadAll(Map<String, Object> maps) {
        return activityJoinMapper.loadAll(maps);
    }

    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        return activityJoinMapper.queryPageCount(maps);
    }

    @Override
    public Page<ActivityJoin> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<ActivityJoin>(activityJoinMapper,currentIndex,pageNum,maps);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return activityJoinMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ActivityJoin activityJoin) {
        return activityJoinMapper.insert(activityJoin);
    }

    @Override
    public int insertSelective(ActivityJoin activityJoin) {
        return activityJoinMapper.insertSelective(activityJoin);
    }

    @Override
    public ActivityJoin selectByPrimaryKey(String id) {
        return activityJoinMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ActivityJoin activityJoin) {
        return activityJoinMapper.updateByPrimaryKeySelective(activityJoin);
    }

    @Override
    public int updateByPrimaryKey(ActivityJoin activityJoin) {
        return activityJoinMapper.updateByPrimaryKey(activityJoin);
    }

    @Override
    public ActivityJoin selectByPrimaryKey(Integer id) {
        return activityJoinMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return activityJoinMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ActivityJoin> queryAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<ActivityJoin> queryBySql(Map<String, Object> maps) {
        return null;
    }

    @Override
    public void save(ActivityJoin activityJoin) {

    }

    @Override
    public void update(ActivityJoin activityJoin) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ActivityJoin load(Long id) {
        return null;
    }

    @Override
    public ActivityJoin load(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<ActivityJoin> search(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer searchCount(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Page<ActivityJoin> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return null;
    }

    @Override
    public  List<ActivityJoin>  countByActivityJOIn(Integer activityId) {
        return activityJoinMapper.countByActivityJOIn(activityId);
    }

    @Override
    public int countByActivityId(int activityId) {
        return activityJoinMapper.countByActivityId(activityId);
    }
}
