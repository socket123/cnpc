package com.su.dao;

import java.util.List;
import java.util.Map;

import com.su.entity.SysRole;

/**
 * 系统角色管理DAO
 * */
public interface SysRoleMapper extends BaseDao<SysRole> {
	List<SysRole> loadAll(Map<String, Object> maps);

	int insert(SysRole sysRole);

	int insertSelective(SysRole sysRole);

	SysRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysRole sysRole);

	int updateByPrimaryKey(SysRole sysRole);

	SysRole selectByPrimaryKey(Integer id);

	List<SysRole> queryByName(String sysRoleName);

}