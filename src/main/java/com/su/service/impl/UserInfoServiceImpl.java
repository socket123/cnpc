package com.su.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.MenuDao;
import com.su.dao.UserDao;
import com.su.entity.Menu;
import com.su.entity.User;
import com.su.service.UserInfoService;
import com.su.utils.Page;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<User> implements
		UserInfoService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private MenuDao menuDao;

	public User getUserInfo(Map<String, Object> maps) {
		User user = userDao.getUserInfo(maps);
		if (null != user) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roleId", user.getRoleId());
			List<Menu> menuList = menuDao.loadAllMenu(paramMap);
			if (menuList.size() > 0) {
				List<Menu> parentMenuList = new ArrayList<Menu>();
				List<Menu> chilidMenuList = new ArrayList<Menu>();
				for (Menu menu : menuList) {
					if (menu.getParentId() == 0) {
						parentMenuList.add(menu);
					} else {
						chilidMenuList.add(menu);
					}
				}

				this.setMenuVoList(parentMenuList, chilidMenuList);
				user.setMenuList(parentMenuList);
			}
		}
		return user;
	}

	@Override
	public Page<User> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps) {

		return new Page<User>(userDao, currentIndex, pageNum, maps);
	}

	private void setMenuVoList(List<Menu> parentMenuList,
			List<Menu> chilidMenuList) {
		for (Menu parentMenu : parentMenuList) {
			for (Menu chilidMenu : chilidMenuList) {
				if (parentMenu.getId() == chilidMenu.getParentId()) {
					parentMenu.getChildMenu().add(chilidMenu);
				}
			}
		}

	}

	public int insert(User user) {
		return userDao.insert(user);
	}

	public int insertSelective(User user) {
		return userDao.insert(user);
	}

	public User selectByPrimaryKey(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	public int updateByPrimaryKey(User user) {
		return userDao.updateByPrimaryKey(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.UserInfoService#queryByName(java.lang.String)
	 */
	@Override
	public List<User> queryByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.queryByName(userName);
	}

}
