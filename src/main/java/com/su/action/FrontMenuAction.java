package com.su.action;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.FrontMenu;
import com.su.entity.User;
import com.su.service.FrontMenuService;
import com.su.utils.CommonUtil;
import com.su.utils.DateUtils;
import com.su.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by James on 2016/10/27.
 */
@Controller
@RequestMapping("/FrontMenu")
public class FrontMenuAction extends BaseAction {
    @Autowired
    FrontMenuService FrontMenuService;

    /**
     * 管理分类页面
     */
    @RequestMapping("FrontMenuList")
    public String FrontMenuList(HttpServletRequest request, ModelMap map) {

        map.put(StrConstant.PAGE, Forward.ActionPage.FRONTMENULIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "FrontMenuTable")
    public String FrontMenuTable(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }

        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<FrontMenu> pages = FrontMenuService.queryPage(currentIndex, 10, maps);
        map.put("pages", pages);
        return Forward.ActionPage.FRONTMENULISTTABLE;
    }

    /**
     * 添加和修改分类页面
     */
    @RequestMapping(value = "addUpdateFrontMenu")
    public String addFrontMenu(HttpServletRequest request, ModelMap map) {
        String FrontMenuId = CommonUtil.getRequest(request, "FrontMenuId");
        if (FrontMenuId != "") {
            request.setAttribute("FrontMenu", FrontMenuService.selectByPrimaryKey(Integer.valueOf(FrontMenuId)));
        }
        map.put(StrConstant.PAGE, Forward.ActionPage.FRONTMENUADD);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 保存添加的分类
     */
    @RequestMapping(value = "saveFrontMenu", produces = "application/json;charset=utf-8",method= RequestMethod.POST)
    @ResponseBody
    public String saveFrontMenu(HttpServletRequest request, ModelMap map, FrontMenu FrontMenu) {
        try {
            if (FrontMenu.getId() == null) {

                FrontMenu.setStatus("1");
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");
                FrontMenu.setMenucreatetime(DateUtils.currentDate());
                FrontMenu.setMenucreateuser(loginUser.getUsername());
                FrontMenuService.insert(FrontMenu);


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
    @RequestMapping(value = "delFrontMenu")
    @ResponseBody
    public String delFrontMenu(HttpServletRequest request, ModelMap map, Integer id) {
        try {
            FrontMenuService.deleteByPrimaryKey(id);
            return "true";
        } catch (Exception e) {

            return "false";
        }
    }

    /**
     * 保存修改的分类信息
     */
    @RequestMapping(value = "updateFrontMenu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateFrontMenuInfo(HttpServletRequest request, ModelMap map, FrontMenu FrontMenu) {
        try {
            FrontMenuService.updateByPrimaryKeySelective(FrontMenu);
            return "true";

        } catch (Exception e) {

            e.printStackTrace();
            return "false";
        }
    }
}
