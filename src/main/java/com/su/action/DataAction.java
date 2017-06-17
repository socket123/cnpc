package com.su.action;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.Data;
import com.su.entity.Keyword;
import com.su.entity.User;
import com.su.service.KeyWordService;
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
@RequestMapping("Data")
public class DataAction  extends  BaseAction{
    @Autowired
    com.su.service.DataService DataService;

    @Autowired
    private KeyWordService keyWordService;
    /**
     * 管理分类页面
     */
    @RequestMapping("DataList")
    public String DataList(HttpServletRequest request, ModelMap map) {

        map.put(StrConstant.PAGE, Forward.ActionPage.DATALIST);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 显示分类列表内容
     */
    @RequestMapping(value = "DataTable")
    public String DataTable(HttpServletRequest request, ModelMap map, Integer currentIndex) {

        Map<String, Object> maps = new HashMap<String, Object>();

        if (currentIndex == null || currentIndex == 0) {
            currentIndex = 1;
        }

        maps.put("currentIndex", currentIndex);
        maps.put("endIndex", currentIndex);
        Page<Data> pages = DataService.queryPage(currentIndex, 10, maps);
        map.put("pages", pages);
        return Forward.ActionPage.DATALISTTABLE;
    }

    /**
     * 添加和修改分类页面
     */
    @RequestMapping(value = "addUpdateData")
    public String addData(HttpServletRequest request, ModelMap map,String DataId) {
        if (StringUtils.isNotEmpty(DataId)) {
            System.out.print("DataID>>>"+DataId);
            request.setAttribute("topic", DataService.selectByPrimaryKey(Integer.valueOf(DataId)));
        }
        List<Keyword> keywordList=keyWordService.loadAll(null);
        map.put("keywordList",keywordList);
        map.put(StrConstant.PAGE, Forward.ActionPage.DATAADD);
        return Forward.ActionPage.PUBLIC;
    }

    /**
     * 保存添加的分类
     */
    @RequestMapping(value = "saveData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String saveData(HttpServletRequest request, ModelMap map, Data Data) {
        System.out.print(Data.toString());
        try {
            if (Data.getId() == null) {

                Data.setStatus("1");
                Data.setUrl(SystemConfig.readValue("SERVER_URL")+"/uploadfile/"+Data.getUrl());
                User loginUser = (User) CommonUtil.getSessionObj(request, "user");
                Data.setCreatetime(DateUtils.currentDate());
                Data.setCreateuser(loginUser.getUsername());
                DataService.insert(Data);


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
    @RequestMapping(value = "delData")
    @ResponseBody
    public String delData(HttpServletRequest request, ModelMap map, Integer id) {
        try {
            DataService.deleteByPrimaryKey(id);
            return "true";
        } catch (Exception e) {

            return "false"; 
        }
    }

    /**
     * 保存修改的分类信息
     */
    @RequestMapping(value = "updateData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateDataInfo(HttpServletRequest request, ModelMap map, Data Data) {
        try {
            Data.setUrl(SystemConfig.readValue("SERVER_URL")+"/uploadfile/"+Data.getUrl());

            DataService.updateByPrimaryKeySelective(Data);
            return "true";

        } catch (Exception e) {

            e.printStackTrace();
            return "false";
        }
    }

}
