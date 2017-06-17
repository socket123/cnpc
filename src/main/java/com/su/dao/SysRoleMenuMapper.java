package com.su.dao;

import java.util.List;

import com.su.entity.SysRoleMenu;

/**
 * 系统菜单角色DAO
 * 
 * @author 张宏齐
 * */
public interface SysRoleMenuMapper extends BaseDao<SysRoleMenu> {
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