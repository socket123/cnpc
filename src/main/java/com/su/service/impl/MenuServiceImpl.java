package com.su.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.MenuDao;
import com.su.entity.Menu;
import com.su.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements
		MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> loadAllMenu(Map<String, Object> maps) {
		return menuDao.loadAllMenu(maps);
	}

	public List<Menu> loadAll(Map<String, Object> maps) {
		return menuDao.loadAll(maps);
	}

}
