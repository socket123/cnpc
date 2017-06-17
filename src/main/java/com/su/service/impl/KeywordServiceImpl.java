/**************************************************************************************** 

 ****************************************************************************************/
package com.su.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.KeywordMapper;
import com.su.entity.Keyword;
import com.su.service.KeyWordService;
import com.su.utils.Page;

/**
 * <Description> <br>
 * 
 * @author James<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年9月2日 <br>
 */

@Service
public class KeywordServiceImpl implements KeyWordService {

    @Autowired
    private KeywordMapper keywordMapper;

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param maps
     * @return <br>
     */
    @Override
    public List<Keyword> loadAll(Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return keywordMapper.loadAll(maps);
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
        return keywordMapper.queryPageCount(maps);
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
    public List<Keyword> search(Map<String, Object> maps) {
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
    public Page<Keyword> queryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
        // TODO Auto-generated method stub
        return new Page<Keyword>(keywordMapper, currentIndex, pageNum, maps);
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
    public Keyword load(String id) {
        // TODO Auto-generated method stub
        return keywordMapper.load(id);
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
        return keywordMapper.deleteByPrimaryKey(id);
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
    public int insert(Keyword t) {
        // TODO Auto-generated method stub
        return keywordMapper.insert(t);
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
    public int insertSelective(Keyword t) {
        // TODO Auto-generated method stub
        return keywordMapper.insertSelective(t);
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
    public Keyword selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return keywordMapper.selectByPrimaryKey(id);
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
    public int updateByPrimaryKeySelective(Keyword t) {
        // TODO Auto-generated method stub
        return keywordMapper.updateByPrimaryKey(t);
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
    public int updateByPrimaryKey(Keyword t) {
        // TODO Auto-generated method stub
        return keywordMapper.updateByPrimaryKey(t);
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
    public List<Keyword> queryAll(Map<String, Object> maps) {
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
    public List<Keyword> queryBySql(Map<String, Object> maps) {
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
    public Keyword selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return keywordMapper.selectByPrimaryKey(id);
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
        return keywordMapper.deleteByPrimaryKey(id);
    }

    /**
     * Description: <br>
     * 
     * @author James<br>
     * @taskId <br>
     * @param t <br>
     */
    @Override
    public void save(Keyword t) {
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
    public void update(Keyword t) {
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
    public Keyword load(Long id) {
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
    public Page<Keyword> searchQueryPage(Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
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
}
