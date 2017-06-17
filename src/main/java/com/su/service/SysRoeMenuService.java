/**
 * 
 */
package com.su.service;

import java.util.List;

import com.su.entity.SysRoleMenu;

/**
 * @author Eric
 * 
 */
public interface SysRoeMenuService extends BaseService<SysRoleMenu> {
	List<SysRoleMenu> queryByRoleId(Integer roleId);

	int insert(SysRoleMenu sysRoleMenu);

	int insertSelective(SysRoleMenu sysRoleMenu);

	SysRoleMenu selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysRoleMenu sysRoleMenu);

	int updateByPrimaryKey(SysRoleMenu sysRoleMenu);

	SysRoleMenu selectByPrimaryKey(Integer id);

	List<SysRoleMenu> queryByMenuId(Integer menuId);

	int deleteByPrimaryKey(Integer id);

}
