package com.su.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.su.constant.CodeConstant;
import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.User;
import com.su.service.UserInfoService;
import com.su.utils.CommonUtil;

@Controller
public class LoginAction extends BaseAction {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "login")
	public String toLogin(HttpServletRequest request, ModelMap map) {
		return Forward.ActionPage.LOGIN;
	}

	@RequestMapping(value = "vaildUser")
	public ModelAndView vaildUser(HttpServletRequest request, ModelMap map) {
		String name = CommonUtil.getRequest(request, "userName");
		String password = CommonUtil.getRequest(request, "password");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("password", password);
		User user = userInfoService.getUserInfo(paramMap);

		if (null == user) {
			return new ModelAndView("jsonView", "rCode",
					CodeConstant.USER_NOT_CZ);
		}
		CommonUtil.setSession(request, StrConstant.USER, user);
		return new ModelAndView("jsonView", "rCode", CodeConstant.SUCCESS);
	}

	@RequestMapping(value = "eixtLogin")
	public String eixtLogin(HttpServletRequest request, ModelMap map) {
		CommonUtil.removeSession(request, StrConstant.USER);
		return Forward.ActionPage.LOGIN;
	}

	/**
	 * 跳转到修改密码页面
	 * */
	@RequestMapping(value = "updatePwd")
	public String updatePwd(HttpServletRequest request, ModelMap map, String id) {
		map.put("userId", id);
		map.put(StrConstant.PAGE, Forward.ActionPage.UPDATEPWD);
		return Forward.ActionPage.PUBLIC;
	}

	@ResponseBody
	@RequestMapping(value = "savePwd")
	public String updateUserRole(HttpServletRequest request, ModelMap map,
			Integer userId, String oldPass, String newPass) {
		try {
			if (userId == null) {
				User loginUser = (User) CommonUtil.getSessionObj(request,
						StrConstant.USER);
				if (oldPass.equals(loginUser.getPassword())) {
					loginUser.setPassword(newPass);
					userInfoService.updateByPrimaryKeySelective(loginUser);
					return "true";
				}
				return "error";
			} else {
				User user = userInfoService.selectByPrimaryKey(userId);
				if (oldPass.equals(user.getPassword())) {
					user.setPassword(newPass);
					userInfoService.updateByPrimaryKeySelective(user);
					return "true";

				} else {
					return "error";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
}
