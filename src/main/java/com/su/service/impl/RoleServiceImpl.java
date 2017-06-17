package com.su.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.SysRoleMapper;
import com.su.entity.SysRole;
import com.su.service.RoleService;
import com.su.utils.Page;

@Service
public class RoleServiceImpl extends BaseServiceImpl<SysRole> implements
		RoleService {
	@Autowired
	private SysRoleMapper roleMapper;

	@Override
	public Page<SysRole> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps) {
		return new Page<SysRole>(roleMapper, currentIndex, maps);

	}

	public List<SysRole> loadAll(Map<String, Object> maps) {
		return roleMapper.loadAll(maps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.su.service.RoleService#queryByName(java.lang.String)
	 */
	@Override
	public List<SysRole> queryByName(String sysRoleName) {
		// TODO Auto-generated method stub
		return roleMapper.queryByName(sysRoleName);
	}

	public int insert(SysRole sysRole) {
		return roleMapper.insert(sysRole);
	}

	public int insertSelective(SysRole sysRole) {
		return roleMapper.insertSelective(sysRole);
	}

	public SysRole selectByPrimaryKey(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysRole sysRole) {
		return roleMapper.updateByPrimaryKeySelective(sysRole);
	}

	public int updateByPrimaryKey(SysRole sysRole) {
		return roleMapper.updateByPrimaryKey(sysRole);
	}

	public SysRole selectByPrimaryKey(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}
}
