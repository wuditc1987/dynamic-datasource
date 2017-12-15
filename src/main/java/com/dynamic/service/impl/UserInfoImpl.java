package com.dynamic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.dao.UserInfoDao;
import com.dynamic.model.UserInfo;
import com.dynamic.service.UserInfoService;

@Service
public class UserInfoImpl implements UserInfoService{
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public int insertUser(UserInfo info) {
		return userInfoDao.insert(info);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.selectAll();
	}

}
