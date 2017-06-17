package com.su.service;

import java.util.List;
import java.util.Map;

import com.su.entity.SysRole;
import com.su.utils.Page;

public interface RoleService extends BaseService<SysRole> {
	public Page<SysRole> queryPage(Integer currentIndex, Integer pageNum,
			Map<String, Object> maps);

	List<SysRole> loadAll(Map<String, Object> maps);

	int insert(SysRole sysRole);

	int insertSelective(SysRole sysRole);

	SysRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysRole sysRole);

	int updateByPrimaryKey(SysRole sysRole);

	SysRole selectByPrimaryKey(Integer id);

	List<SysRole> queryByName(String sysRoleName);

}
