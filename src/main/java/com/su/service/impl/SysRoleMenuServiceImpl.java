/**
 * 
 */
package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.SysRoleMenuMapper;
import com.su.entity.SysRoleMenu;
import com.su.service.SysRoeMenuService;

/**
 * @author Eric
 * 
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu>
		implements SysRoeMenuService {

	@Autowired
	private SysRoleMenuMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.SysRoeMenuService#queryByRoleId(java.lang.Integer)
	 */
	@Override
	public List<SysRoleMenu> queryByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return mapper.queryByRoleId(roleId);
	}

	public int insert(SysRoleMenu sysRoleMenu) {
		return mapper.insert(sysRoleMenu);
	}

	public int insertSelective(SysRoleMenu sysRoleMenu) {
		return mapper.insertSelective(sysRoleMenu);
	}

	public SysRoleMenu selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysRoleMenu sysRoleMenu) {
		return mapper.updateByPrimaryKeySelective(sysRoleMenu);
	}

	public int updateByPrimaryKey(SysRoleMenu sysRoleMenu) {
		return mapper.updateByPrimaryKey(sysRoleMenu);
	}

	public SysRoleMenu selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.SysRoeMenuService#queryByMenuId(java.lang.Integer)
	 */
	@Override
	public List<SysRoleMenu> queryByMenuId(Integer menuId) {
		// TODO Auto-generated method stub
		return mapper.queryByMenuId(menuId);
	}

	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);

	}

}
