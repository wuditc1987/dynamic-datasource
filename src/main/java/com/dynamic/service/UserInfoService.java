package com.dynamic.service;

import java.util.List;

import com.dynamic.model.UserInfo;

public interface UserInfoService {
	
	public int insertUser(UserInfo info);
	
	List<UserInfo> findAll();
}
