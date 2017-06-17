package com.su.action;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Activity;
import com.su.entity.ActivityJoin;
import com.su.entity.User;
import com.su.service.ActivityJoinService;
import com.su.service.ActivityService;
import com.su.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/28.
 */
@Controller
@RequestMapping("Activity")
public class ActivityAction extends BaseAction {
    @Autowired
    com.su.service.ActivityService ActivityService;
    @Autowired
    private ActivityJoinService activityJoinService;

    /**
     * 管理分类页面
     */
    @RequestMapping("ActivityList")
    public String ActivityList(HttpServletRequest request, ModelMap map) {

        map.put(StrConstant.PAGE, Forward.ActionPage.ACTIVITYLIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "ActivityTable")
    public String ActivityTable(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }

        List<Activity> activities = new ArrayList<>();
        Page<Activity> pages = ActivityService.queryPage(currentIndex, 10, maps);
        for (Activity a : pages.getDataList()) {
            Integer numbers = 0 ; //参与总人数
            List<ActivityJoin>  activityJoins  = activityJoinService.countByActivityJOIn(a.getId());
            if(null != activityJoins && activityJoins.size() > 0){
                for (ActivityJoin activityJoin : activityJoins){
                   Integer numver =  Integer.parseInt(activityJoin.getNumber());
                    numbers = numver + numbers ;
                }
            }
            a.setCount(String.valueOf(numbers));
            activities.add(a);

        }
        pages.setDataList(activities);

        List<Activity> activitiesList  = new ArrayList<Activity>();
        for (int i = 0 ; i <  pages.getDataList().size() ; i ++){
            Activity activity = new Activity();
            String countactive = StringUtil.getTextFromHtml_12(pages.getDataList().get(i).getContent());
            activity = pages.getDataList().get(i);
            activity.setCountactive(countactive);
            activitiesList.add(activity);
        }
        pages.setDataList(activitiesList);


        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        map.put("pages", pages);
        return Forward.ActionPage.ACTIVITYLISTTABLE;
    }

    /**
     * 添加和修改分类页面
     */
    @RequestMapping(value = "addUpdateActivity")
    public String addActivity(HttpServletRequest request, ModelMap map) {
        String ActivityId = CommonUtil.getRequest(request, "ActivityId");
        if (ActivityId != "") {
            String randomcode = UUIDutil.generate();
            map.put("randomcode", randomcode);
            request.setAttribute("topic", ActivityService.selectByPrimaryKey(Integer.valueOf(ActivityId)));
        }
        map.put(StrConstant.PAGE, Forward.ActionPage.ACTIVITYADD);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 保存添加的分类
     */
    @RequestMapping(value = "saveActivity", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String saveActivity(HttpServletRequest request, ModelMap map, Activity Activity) {
        try {
            if (Activity.getId() == null) {

                Activity.setActivitystatus("1");
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");
                Activity.setCreatetime(DateUtils.currentDate());
                Activity.setCreateuser(loginUser.getUsername());
                ActivityService.insert(Activity);


            }
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 删除分类
     */
    @RequestMapping(value = "delActivity")
    @ResponseBody
    public String delActivity(HttpServletRequest request, ModelMap map, Integer id) {
        try {
            ActivityService.deleteByPrimaryKey(id);
            return "true";
        } catch (Exception e) {

            return "false";
        }
    }

    /**
     * 保存修改的分类信息
     */
    @RequestMapping(value = "updateActivity", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateActivityInfo(HttpServletRequest request, ModelMap map, Activity Activity) {
        try {
            ActivityService.updateByPrimaryKeySelective(Activity);
            return "true";

        } catch (Exception e) {

            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "ActivityJoinTable")
    public String ActivityJoin(HttpServletRequest request, ModelMap map, Integer currentIndex,String activityid) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }
        maps.put("activityId",activityid);
        List<Activity> activities = new ArrayList<>();
        Page<ActivityJoin> pages = activityJoinService.queryPage(currentIndex, 10, maps);
        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        map.put("pages", pages);
        map.put(StrConstant.PAGE, Forward.ActionPage.ACTIVITYJOINTABLE);
        return Forward.ActionPage.PUBLIC;

    }

    @ResponseBody
    @RequestMapping(value = "updateActivityJoin", method = RequestMethod.POST)
    public String toUpdateJoinInfo(ActivityJoin activityJoin){
        activityJoin.setId(activityJoin.getId());
        activityJoin.setStatus(activityJoin.getStatus());
        int result=activityJoinService.updateByPrimaryKeySelective(activityJoin);
        return "true";
    }

    /**
     * 生成随机码
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "randomcodeAction", method = RequestMethod.POST)
    public String randomcodeAction(){
        String randomcode = UUIDutil.generate();
        return randomcode;
    }

}
