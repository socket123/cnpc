package com.su.service.impl;

import com.su.dao.BannerMapper;
import com.su.entity.Banner;
import com.su.service.BannerService;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/27.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;


    @Override
    public List<Banner> loadAll(Map<String, Object> maps) {
        return bannerMapper.loadAll(maps);
    }

    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        return bannerMapper.queryPageCount(maps);
    }

    @Override
    public Page<Banner> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<>(bannerMapper, currentIndex, pageNum, maps);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Override
    public int insertSelective(Banner banner) {
        return bannerMapper.insertSelective(banner);
    }

    @Override
    public Banner selectByPrimaryKey(String id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner banner) {
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public Banner selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Banner banner) {
        return bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public List<Banner> queryAll(Map<String, Object> maps) {
        return null;
    }

    @Override
    public List<Banner> queryBySql(Map<String, Object> maps) {
        return null;
    }


    @Override
    public void save(Banner banner) {

    }

    @Override
    public void update(Banner banner) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Banner load(Long id) {
        return null;
    }

    @Override
    public Banner load(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Banner> search(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Integer searchCount(Map<String, Object> maps) {
        return null;
    }

    @Override
    public Page<Banner> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return null;
    }
}
