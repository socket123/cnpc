package com.su.dao;

import com.su.entity.FrontMenu;

import java.util.List;
import java.util.Map;

public interface FrontMenuMapper extends BaseDao<FrontMenu> {
    int deleteByPrimaryKey(Integer id);

    int insert(FrontMenu record);

    int insertSelective(FrontMenu record);

    FrontMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrontMenu record);

    int updateByPrimaryKey(FrontMenu record);

    List<FrontMenu> queryAllese(Map<String, Object> maps);
}