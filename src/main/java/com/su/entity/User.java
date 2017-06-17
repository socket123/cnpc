package com.su.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Integer id;

	private String username;

	private String password;

	private String nike;

	private Integer roleId;

	private Integer createId;

	private Integer status;
	private List<Menu> menuList = new ArrayList<Menu>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNike() {
		return nike;
	}

	public void setNike(String nike) {
		this.nike = nike;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月18日 上午11:49:03
	 * @return type
	 */

	public Integer getStatus() {
		return status;
	}

	/**
	 * @author zhanghonqgi
	 * @created 2015年8月18日 上午11:49:03
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
