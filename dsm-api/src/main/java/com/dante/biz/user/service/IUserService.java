package com.dante.biz.user.service;

import java.util.List;
import java.util.Map;

import com.dante.model.user.User;
import com.github.pagehelper.PageInfo;

public interface IUserService {

	List<User> queryUserList(Map<String, Object> params) throws Exception;

	void addUser(User user) throws Exception;

	User getUserById(User user) throws Exception;

	int updateUser(User user) throws Exception;

	int deleteUser(User user) throws Exception;

	PageInfo<User> pageUserList(Map<String, Object> params) throws Exception;

	User getUserLogin(User user) throws Exception;

}
