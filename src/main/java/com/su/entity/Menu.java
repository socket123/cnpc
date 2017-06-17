package com.su.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private int id;
	
	// 菜单名称
	private String menuName;
	
	// 详细描述
	private String desc;
	
	// 链接请求
	private String link;
	
	// 父级菜单ID
	private int parentId;
	
	// 菜单排序
	private int shwoMenu;
	
	// 菜单图标
	private String icon;
	
	private List<Menu> childMenu = new ArrayList<Menu>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getShwoMenu() {
		return shwoMenu;
	}

	public void setShwoMenu(int shwoMenu) {
		this.shwoMenu = shwoMenu;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

	
}
