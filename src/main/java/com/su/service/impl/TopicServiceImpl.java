package com.su.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.TopicDao;
import com.su.entity.Topic;
import com.su.service.TopicService;
import com.su.utils.Page;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicDao topicDao;

    @Override
    public boolean addTopic(Topic topic) {
        return topicDao.addTopic(topic);
    }

    @Override
    public boolean delTopic(Integer id) {
        return topicDao.delTopic(id);
    }

    @Override
    public boolean queryAll() {
        return topicDao.queryAll();
    }

    @Override
    public boolean updateTopic(Topic topic) {
        return topicDao.updateTopic(topic);
    }

    @Override
    public Page<Topic> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        return new Page<Topic>(topicDao, currentIndex, maps);
    }

    @Override
    public Topic queryById(Integer id) {
        return topicDao.queryById(id);
    }

    @Override
    public Topic verifyByName(String name) {
        return topicDao.verifyByName(name);
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t <br>
     */
    @Override
    public void save(Topic t) {
        // TODO Auto-generated method stub

    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t <br>
     */
    @Override
    public void update(Topic t) {
        // TODO Auto-generated method stub

    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id <br>
     */
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public Topic load(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public List<Topic> loadAll(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return topicDao.loadAll(maps);
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public Integer queryPageCount(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public List<Topic> search(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public Integer searchCount(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param currentIndex
     * @param pageNum
     * @param maps
     * @return <br>
     */
    @Override
    public Page<Topic> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public Topic load(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id <br>
     */
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t
     * @return <br>
     */
    @Override
    public int insert(Topic t) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t
     * @return <br>
     */
    @Override
    public int insertSelective(Topic t) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public Topic selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t
     * @return <br>
     */
    @Override
    public int updateByPrimaryKeySelective(Topic t) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t
     * @return <br>
     */
    @Override
    public int updateByPrimaryKey(Topic t) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public List<Topic> queryAll(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public List<Topic> queryBySql(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public Topic selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param id
     * @return <br>
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

}
