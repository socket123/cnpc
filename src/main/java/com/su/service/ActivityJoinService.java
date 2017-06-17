package com.su.service;

import com.su.entity.ActivityJoin;

import java.util.List;

/**
 * Created by James on 2016/10/27.
 */
public interface ActivityJoinService extends BaseService<ActivityJoin> {

    List<ActivityJoin> countByActivityJOIn(Integer activityId);

    int countByActivityId(int activityId);

    int insert(ActivityJoin record);
}
