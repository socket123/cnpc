package com.su.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Topic;
import com.su.entity.User;
import com.su.service.TopicService;
import com.su.utils.CommonUtil;
import com.su.utils.DateUtils;
import com.su.utils.Page;

/**
 * 分类管理控制层
 * 
 * @author jianzeyang
 */
@Controller
@RequestMapping("topic")
public class TopicAction extends BaseAction {
    @Autowired
    TopicService topicService;

    /**
     * 管理分类页面
     */
    @RequestMapping("topicList")
    public String topicList(HttpServletRequest request, ModelMap map) {

        map.put(StrConstant.PAGE, Forward.ActionPage.TOPICLIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "topicTable")
    public String topicTable(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }

        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<Topic> pages = topicService.queryPage(currentIndex, 10, maps);

        map.put("pages", pages);
        return Forward.ActionPage.TOPICTABLE;
    }

    /**
     * 添加和修改分类页面
     */
    @RequestMapping(value = "addUpdateTopic")
    public String addtopic(HttpServletRequest request, ModelMap map) {
        String topicId = CommonUtil.getRequest(request, "topicId");
        if (topicId != "") {
            request.setAttribute("topic", topicService.queryById(Integer.valueOf(topicId)));
        }
        map.put(StrConstant.PAGE, Forward.ActionPage.ADDTOPIC);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 保存添加的分类
     */
    @RequestMapping(value = "saveTopic", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String savetopic(HttpServletRequest request, ModelMap map, Topic topic) {
        try {
            Topic t = topicService.verifyByName(topic.getName());
            if (t == null) {

                topic.setCreateTime(DateUtils.currentDatetime());
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");
                topic.setCreateUser(loginUser.getId() + "");
                topic.setCreateUserName(loginUser.getUsername());
                if (topicService.addTopic(topic)) {
                    return "true";
                }

            }
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 删除分类
     */
    @RequestMapping(value = "delTopic")
    @ResponseBody
    public String deltopic(HttpServletRequest request, ModelMap map, Integer id) {

        return topicService.delTopic(id) == true ? "true" : "false";
    }

    /**
     * 保存修改的分类信息
     */
    @RequestMapping(value = "updateTopic", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updatetopicInfo(HttpServletRequest request, ModelMap map, Topic topic) {
        try {
            Topic t = topicService.verifyByName(topic.getName());
            if (t == null || t.getId() == topic.getId()) {
                Topic t2 = topicService.queryById(Integer.valueOf(topic.getId()));
                t2.setUpdateTime(DateUtils.currentDatetime());
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");

                t2.setName(topic.getName());

                topicService.updateTopic(t2);
            }
            return "true";

        } catch (Exception e) {

            e.printStackTrace();
            return "false";
        }
    }
}
