package com.su.entity;

/**
 * 菜单角色关联信息实体类
 * 
 * @author zhq
 * */
public class SysRoleMenu {
	// id
	private Integer id;
	// 角色id
	private Integer roleId;
	// 菜单ID
	private Integer menuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}