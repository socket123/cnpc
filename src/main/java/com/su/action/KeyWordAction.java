package com.su.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Keyword;
import com.su.entity.User;
import com.su.service.KeyWordService;
import com.su.utils.CommonUtil;
import com.su.utils.Page;

/**
 * Created by James on 2016/09/02.
 */
@Controller
@RequestMapping(value = "/keyword")
public class KeyWordAction extends BaseAction {

    @Autowired
    private KeyWordService keyWordService;

    /**
     * 鐢ㄦ埛鍒楄〃椤甸潰
     * 
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/list")
    public String userList(HttpServletRequest request, ModelMap map) {
        map.put(StrConstant.PAGE, Forward.ActionPage.KEYWORDLIST);
        return Forward.ActionPage.PUBLIC;
    }

    @RequestMapping(value = "/listTable")
    public String userTable(HttpServletRequest request, ModelMap map,
            Integer currentIndex) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (currentIndex == null) {
            currentIndex = 1;
        }

        Page<Keyword> pages = keyWordService.queryPage(currentIndex, 10, maps);
        map.put("pages", pages);

        return Forward.ActionPage.KEYWORDTABLE;
    }

    @RequestMapping(value = "/add")
    public String toAdd(HttpServletRequest req, HttpServletResponse rep, ModelMap map) {
        map.put(StrConstant.PAGE, Forward.ActionPage.ADDKEYWORD);
        return Forward.ActionPage.PUBLIC;
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String saveKeyword(Keyword keyword, HttpServletRequest request) {
        try {
            User user = (User) CommonUtil.getSessionObj(request,
                    StrConstant.USER);

            // 根據用戶名判斷信�?
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("keyword", keyword.getKeyword());
            List<Keyword> userList = keyWordService.loadAll(maps);
            if (userList.size() <= 0) {
                keyword.setKeyword(keyword.getKeyword());
                keyword.setCreatetime(com.su.utils.DateUtils.getTimestamp(com.su.utils.DateUtils.currentDatetime()) + "");
                keyword.setCreateuser(user.getId());
                keyword.setCreateusername(user.getUsername());
                keyWordService.insertSelective(keyword);
                return "true";
            }
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }

    @RequestMapping(value = "/toupdate")
    public String toUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap map, Integer id) {

        Keyword keyword = keyWordService.selectByPrimaryKey(id);
        map.put("keyword", keyword);
        map.put(StrConstant.PAGE, Forward.ActionPage.UPDATEKEYWORD);
        return Forward.ActionPage.PUBLIC;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateeyword(Keyword keyword, HttpServletRequest request) {
        try {
            User user = (User) CommonUtil.getSessionObj(request,
                    StrConstant.USER);
            // 根據用戶名判斷信�?

            keyWordService.updateByPrimaryKeySelective(keyword);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deleteKeyword(Keyword keyword, HttpServletRequest request, Integer keywordId) {
        try {
            User user = (User) CommonUtil.getSessionObj(request,
                    StrConstant.USER);
            // 根據用戶名判斷信�?

            keyWordService.deleteByPrimaryKey(keywordId);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }
}
