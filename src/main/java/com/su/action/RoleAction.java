package com.su.action;

import java.util.ArrayList;
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
import com.su.entity.Menu;
import com.su.entity.SysRole;
import com.su.entity.SysRoleMenu;
import com.su.entity.User;
import com.su.entity.ZtreeEntity;
import com.su.service.MenuService;
import com.su.service.RoleService;
import com.su.service.SysRoeMenuService;
import com.su.utils.CommonUtil;
import com.su.utils.DateUtils;
import com.su.utils.JSONutils;
import com.su.utils.Page;

/**
 * 角色管理
 * 
 * @author Administrator
 */
@Controller
public class RoleAction extends BaseAction {

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private SysRoeMenuService roleMenuService;

	/**
	 * 角色管理页面
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "role/roleList")
	public String roleList(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.ROLELIST);
		return Forward.ActionPage.PUBLIC;
	}

	@RequestMapping(value = "role/roleTable")
	public String roleTable(HttpServletRequest request, ModelMap map) {
		Integer currentIndex = Integer.valueOf(CommonUtil.getRequest(request,
				"currentIndex"));
		Map<String, Object> maps = new HashMap<String, Object>();
		if (currentIndex == 0) {
			currentIndex = 1;
		}
		Page<SysRole> pages = roleService.queryPage(currentIndex, 10, maps);
		map.put("pages", pages);
		return Forward.ActionPage.ROLETABLE;
	}

	/**
	 * 跳转到权限菜单管理页面
	 * */
	@RequestMapping(value = "role/getRoleList")
	public String getRoleMenuList(HttpServletRequest request, ModelMap map,
			String id) {
		List<SysRole> roleList = roleService.loadAll(null);
		if (id != null) {
			Integer roleId = Integer.parseInt(id);
			SysRole role = roleService.selectByPrimaryKey(roleId);
			map.put("role", role);

		}
		map.put("roleList", roleList);
		map.put(StrConstant.PAGE, Forward.ActionPage.ROLEMENULIST);
		return Forward.ActionPage.PUBLIC;
	}

	/**
	 * Ztree树形菜单
	 * */
	@ResponseBody
	@RequestMapping(value = "role/ztree", produces = "text/plain;charset=utf-8")
	public String ztreeList(HttpServletRequest request, ModelMap map,
			Integer roleId) {
		// 增加查询条件
		Map<String, Object> maps = new HashMap<String, Object>();
		// 获取ztree树形结构
		List<ZtreeEntity> ztreeList = new ArrayList<ZtreeEntity>();
		List<SysRoleMenu> roleMenuList = new ArrayList<>();
		List<Menu> menus = menuService.loadAll(maps);
		// 组装ztree格式数据
		for (Menu m : menus) {
			ZtreeEntity z = new ZtreeEntity();
			z.setpId(new Long(m.getParentId()));
			z.setId(new Long(m.getId()));
			z.setName(m.getMenuName());
			if (roleId != null) {
				roleMenuList = roleMenuService.queryByRoleId(roleId);
				for (SysRoleMenu s : roleMenuList) {
					if (s.getMenuId().equals(m.getId())) {
						z.setChecked("true");
					}

				}
			}

			ztreeList.add(z);
		}

		return JSONutils.listToJson(ztreeList);
	}

	@ResponseBody
	@RequestMapping(value = "role/updateRoleStatus")
	public String updateUserStatus(String roleId, Integer status) {
		try {

			Integer id = Integer.valueOf(roleId);
			SysRole role = roleService.selectByPrimaryKey(id);
			role.setStauts(status);
			roleService.updateByPrimaryKeySelective(role);
			return "true";

		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	/**
	 * 鏂板¢炵敤鎴蜂繚瀛樹俊鎭¯
	 * 
	 * @param request
	 * @param user
	 * @return
	 * */
	@ResponseBody
	@RequestMapping(value = "role/saveRole")
	public String saveRole(HttpServletRequest request, SysRole role,
			String menuIds) {
		User loginUser = (User) CommonUtil.getSessionObj(request,
				StrConstant.USER);
		try {
			if (role.getId() != null) {
				role.setDesc(role.getDesc());
				role.setRoleName(role.getRoleName());
				role.setUpdataTime(DateUtils.currentDatetime());
				role.setUpdataUserName(loginUser.getUsername());
				String[] ids = menuIds.split(",");
				List<SysRoleMenu> menus = roleMenuService.queryByRoleId(role
						.getId());
				for (SysRoleMenu s : menus) {
					roleMenuService.deleteByPrimaryKey(s.getId());

				}
				SysRoleMenu sysRoleMenu = new SysRoleMenu();
				for (String m : ids) {
					sysRoleMenu.setRoleId(role.getId());
					sysRoleMenu.setMenuId(Integer.parseInt(m));
					roleMenuService.insert(sysRoleMenu);
				}
				roleService.updateByPrimaryKeySelective(role);

				return "true";
			} else {
				List<SysRole> userList = roleService.queryByName(role
						.getRoleName());
				if (userList.size() <= 0) {

					role.setDesc(role.getDesc());
					role.setRoleName(role.getRoleName());
					role.setCreateTime(DateUtils.currentDatetime());
					role.setCreateUserName(loginUser.getUsername());
					role.setStauts(1);
					roleService.insertSelective(role);
					List<SysRole> roles = roleService.queryByName(role
							.getRoleName());
					String[] ids = menuIds.split(",");
					for (SysRole s : roles) {
						for (String m : ids) {
							SysRoleMenu sysRoleMenu = new SysRoleMenu();
							sysRoleMenu.setRoleId(s.getId());
							sysRoleMenu.setMenuId(Integer.parseInt(m));
							roleMenuService.insert(sysRoleMenu);
						}

					}
					return "true";

				}
				return "error";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
}
