package com.su.service.impl;

import com.su.dao.DataMapper;
import com.su.entity.Data;
import com.su.service.DataService;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/27.
 */
@Service
public class DataServiceImpl implements DataService{

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Data> loadAll(Map<String, Object> maps) {
        return dataMapper.loadAll(maps);
    }

    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        return dataMapper.queryPageCount(maps);
    }

    @Override
    public Page<Data> queryPage(Integer currentIndex, Integer pageNum,Map<String, Object> maps) {
        return new Page<Data>(dataMapper,currentIndex,pageNum,maps);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Data data) {
        return dataMapper.insert(data);
    }

    @Override
    public int insertSelective(Data data) {
        return dataMapper.insertSelective(data);
    }

    @Override
    public Data selectByPrimaryKey(String id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Data data) {
        return dataMapper.updateByPrimaryKeySelective(data);
    }

    @Override
    public int updateByPrimaryKey(Data data) {
        return dataMapper.updateByPrimaryKey(data);
    }

    @Override
    public Data selectByPrimaryKey(Integer id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Data> queryAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<Data> queryBySql(Map<String, Object> maps) {
        return null;
    }

    @Override
    public void save(Data data) {

    }

    @Override
    public void update(Data data) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Data load(Long id) {
        return null;
    }

    @Override
    public Data load(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Data> search(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer searchCount(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Page<Data> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return null;
    }
}
