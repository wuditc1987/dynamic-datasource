package com.dynamic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dynamic.dao.UserInfoDao;
import com.dynamic.model.UserInfo;
import com.dynamic.service.UserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	@Transactional(readOnly=false)
	public int insertUser(UserInfo info) {
		int count = userInfoDao.insertUser(info);
		return count;
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.selectAll();
	}

}
