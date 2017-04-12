package com.dante.biz.role.service;

import java.util.List;
import java.util.Map;

import com.dante.model.role.Role;
import com.github.pagehelper.PageInfo;


public interface IRoleService {

	Role getRoleById(Role r) throws Exception;

	List<Role> queryRoleList(Map<String, Object> params) throws Exception;

	void addRole(Role role) throws Exception;

	int deleteRole(Role role) throws Exception;

	int updateRole(Role role) throws Exception;

	PageInfo<Role> pageRoleList(Map<String, Object> params) throws Exception;

}
