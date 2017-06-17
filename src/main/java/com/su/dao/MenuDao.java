package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.entity.Menu;

public interface MenuDao extends BaseDao<Menu> {

	public List<Menu> loadAllMenu(Map<String, Object> maps);

	List<Menu> loadAll(Map<String, Object> maps);
}
