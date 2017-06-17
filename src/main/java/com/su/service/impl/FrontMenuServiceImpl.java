package com.su.service.impl;

import com.su.dao.FrontMenuMapper;
import com.su.entity.FrontMenu;
import com.su.service.FrontMenuService;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/26.
 */
@Service
public class FrontMenuServiceImpl implements FrontMenuService {
    @Autowired
    private FrontMenuMapper frontMenuMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return frontMenuMapper.deleteByPrimaryKey(id
        );
    }

    @Override
    public int insert(FrontMenu frontMenu) {
        return frontMenuMapper.insert(frontMenu);
    }

    @Override
    public int insertSelective(FrontMenu frontMenu) {
        return frontMenuMapper.insertSelective(frontMenu);
    }

    @Override
    public FrontMenu selectByPrimaryKey(String id) {

        return frontMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FrontMenu frontMenu) {
        return frontMenuMapper.updateByPrimaryKeySelective(frontMenu);
    }

    @Override
    public int updateByPrimaryKey(FrontMenu frontMenu) {
        return frontMenuMapper.updateByPrimaryKey(frontMenu);
    }


    @Override
    public FrontMenu selectByPrimaryKey(Integer id) {
        return frontMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return frontMenuMapper.deleteByPrimaryKey(id
        );
    }
    @Override
    public List<FrontMenu> loadAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        return frontMenuMapper.queryPageCount(maps);
    }


    @Override
    public Page<FrontMenu> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<FrontMenu>(frontMenuMapper, currentIndex, pageNum, maps);
    }



    @Override
    public void save(FrontMenu frontMenu) {

    }

    @Override
    public void update(FrontMenu frontMenu) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public FrontMenu load(Long id) {
        return null;
    }


    @Override
    public FrontMenu load(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
    @Override
    public List<FrontMenu> queryAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<FrontMenu> queryBySql(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<FrontMenu> search(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer searchCount(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Page<FrontMenu> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<FrontMenu>(frontMenuMapper, currentIndex, pageNum, maps);
    }

    @Override
    public List<FrontMenu> queryAllese(Map<String, Object> maps) {
        return frontMenuMapper.queryAllese(maps);
    }
}
