package com.su.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.su.constant.Forward;
import com.su.constant.StrConstant;
import com.su.entity.SysRole;
import com.su.entity.User;
import com.su.service.RoleService;
import com.su.service.UserInfoService;
import com.su.utils.CommonUtil;
import com.su.utils.Page;

/**
 * \ 子账号设置
 * 
 * @author Administrator
 * 
 */
@Controller
public class AccountAction extends BaseAction {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private RoleService roleService;

	/**
	 * 用户列表页面
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "account/userList")
	public String userList(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.USERLIST);
		return Forward.ActionPage.PUBLIC;
	}

	@RequestMapping(value = "account/userTable")
	public String userTable(HttpServletRequest request, ModelMap map,
			Integer currentIndex) {
		Map<String, Object> maps = new HashMap<String, Object>();
		if (currentIndex == null) {
			currentIndex = 1;
		}

		Page<User> pages = userInfoService.queryPage(currentIndex, 10, maps);
		map.put("pages", pages);

		return Forward.ActionPage.USERTABLE;
	}

	/**
	 * 用户页面
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "account/toUserPage")
	public String toUserPage(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.USERLIST);
		return Forward.ActionPage.PUBLIC;
	}

	/**
	 * 新增用户操作
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "account/addUser")
	public String addUser(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.ADDUSER);
		return Forward.ActionPage.PUBLIC;
	}

	/**
	 * 新增用户操作
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "account/updateRole")
	public String updateUser(HttpServletRequest request, ModelMap map,
			Integer id) {
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("status", 1);
		List<SysRole> roleList = roleService.loadAll(maps);
		map.put("roleList", roleList);
		User user = userInfoService.selectByPrimaryKey(id);
		map.put("user", user);
		map.put(StrConstant.PAGE, Forward.ActionPage.UPDATEROLE);
		return Forward.ActionPage.PUBLIC;
	}

	/**
	 * Add a new User¯
	 * 
	 * @param request
	 * @param user
	 * @return
	 * */
	@ResponseBody
	@RequestMapping(value = "account/saveUser")
	public String saveUser(HttpServletRequest request, User user) {
		User loginUser = (User) CommonUtil.getSessionObj(request,
				StrConstant.USER);
		try {
			// 根據用戶名判斷信息
			List<User> userList = userInfoService.queryByName(user
					.getUsername());
			if (userList.size() <= 0) {
				user.setCreateId(loginUser.getId());
				user.setNike(user.getNike());
				user.setPassword(user.getPassword());
				user.setUsername(user.getUsername());
				user.setStatus(1);
				user.setRoleId(user.getRoleId());
				userInfoService.insert(user);
				return "true";
			}
			return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 更新用戶狀態
	 * */
	@ResponseBody
	@RequestMapping(value = "account/updateUserStatus")
	public String updateUserStatus(String userId, Integer status) {
		try {
			if (userId.equals("1")) {
				return "error";
			} else {
				Integer id = Integer.valueOf(userId);
				User user = userInfoService.selectByPrimaryKey(id);
				user.setStatus(status);
				userInfoService.updateByPrimaryKeySelective(user);
				return "true";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 修改用户信息
	 * */

	@ResponseBody
	@RequestMapping(value = "account/update")
	public String updateUserRole(HttpServletRequest request, ModelMap map,
			User user, String roleIds) {
		try {
			user.setRoleId(Integer.parseInt(roleIds));
			userInfoService.updateByPrimaryKeySelective(user);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 设置默认密码
	 * */
	@ResponseBody
	@RequestMapping(value = "account/updateUserPwd")
	public String resetPass(Integer userId, HttpServletRequest request,
			ModelMap maps) {
		try {
			if (userId.equals("1")) {
				return "error";
			} else {

				User user = userInfoService.selectByPrimaryKey(userId);
				user.setPassword("123456");
				userInfoService.updateByPrimaryKeySelective(user);
				return "true";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}

	}

}
