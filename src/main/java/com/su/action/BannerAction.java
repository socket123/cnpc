package com.su.action;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Banner;
import com.su.entity.Keyword;
import com.su.entity.User;
import com.su.service.BannerService;
import com.su.utils.CommonUtil;
import com.su.utils.DateUtils;
import com.su.utils.Page;
import com.su.utils.SystemConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 2016/10/28.
 */
@Controller
@RequestMapping(value = "Banner")
public class BannerAction extends BaseAction {

    @Autowired
    private BannerService BannerService;

    /**
     * 管理分类页面
     */
    @RequestMapping("BannerList")
    public String BannerList(HttpServletRequest request, ModelMap map, String type) {

        map.put("type", type);
        if ("3".equals(type)) {
            map.put(StrConstant.PAGE, Forward.ActionPage.BannerLOGO);
        } else {
            map.put(StrConstant.PAGE, Forward.ActionPage.BannerLIST);
        }

        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "BannerTable",method=RequestMethod.POST)
    public String BannerTable(HttpServletRequest request, ModelMap map, Integer currentIndex,String type) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }
        if (StringUtils.isNotEmpty(type)) {
            maps.put("type", type);
        }

        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<Banner> pages = BannerService.queryPage(currentIndex, 10, maps);
        map.put("pages", pages);
        return Forward.ActionPage.BannerLISTTABLE;
    }

    /**
     * 添加和修改分类页面
     */
    @RequestMapping(value = "addUpdateBanner")
    public String addBanner(HttpServletRequest request, ModelMap map, String BannerId,String type) {
        if (StringUtils.isNotEmpty(BannerId)) {
            request.setAttribute("topic", BannerService.selectByPrimaryKey(Integer.valueOf(BannerId)));
        }
        map.put("type",type);
        map.put(StrConstant.PAGE, Forward.ActionPage.BannerADD);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 保存添加的分类
     */
    @RequestMapping(value = "saveBanner", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String saveBanner(HttpServletRequest request, ModelMap map, Banner Banner) {
        try {
            if (Banner.getId() == null) {
                Banner.setUrl(SystemConfig.readValue("SERVER_URL") + "/uploadfile/" + Banner.getUrl());
                Banner.setName(Banner.getName());
                Banner.setStatus("1");
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");
                Banner.setCreatetime(DateUtils.currentDate());
                Banner.setCreateuser(loginUser.getUsername());
                BannerService.insert(Banner);


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
    @RequestMapping(value = "delBanner")
    @ResponseBody
    public String delBanner(HttpServletRequest request, ModelMap map, Integer id) {
        try {
            BannerService.deleteByPrimaryKey(id);
            return "true";
        } catch (Exception e) {

            return "false";
        }
    }

    /**
     * 保存修改的分类信息
     */
    @RequestMapping(value = "updateBanner", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateBannerInfo(HttpServletRequest request, ModelMap map, Banner Banner) {
        try {
            Banner.setUrl(SystemConfig.readValue("SERVER_URL")+"/uploadfile/"+Banner.getUrl());

            BannerService.updateByPrimaryKeySelective(Banner);
            return "true";

        } catch (Exception e) {

            e.printStackTrace();
            return "false";
        }
    }


}
