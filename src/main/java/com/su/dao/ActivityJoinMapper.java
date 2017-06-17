package com.su.dao;

import com.su.entity.ActivityJoin;

import java.util.List;

public interface ActivityJoinMapper extends BaseDao<ActivityJoin> {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityJoin record);

    int insertSelective(ActivityJoin record);

    ActivityJoin selectByPrimaryKey(Integer id);

    List<ActivityJoin> countByActivityJOIn(Integer activityId);

    int updateByPrimaryKeySelective(ActivityJoin record);

    int updateByPrimaryKey(ActivityJoin record);

    int countByActivityId(int activityId);



}