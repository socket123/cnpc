package com.su.service;

import java.util.List;
import java.util.Map;

import com.su.entity.Menu;

public interface MenuService extends BaseService<Menu> {
	public List<Menu> loadAllMenu(Map<String, Object> maps);

	public List<Menu> loadAll(Map<String, Object> maps);

}
