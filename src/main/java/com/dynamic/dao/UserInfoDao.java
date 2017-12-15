package com.dynamic.dao;

import com.dynamic.anno.DataSourceEnum;
import com.dynamic.model.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dynamic.anno.DataSource;

public interface UserInfoDao extends BaseDao<UserInfo>{
	
	@DataSource(DataSourceEnum.SLAVE)
	int insertUser(UserInfo info);
	
	@DataSource(DataSourceEnum.SLAVE)
	int deleteUser(@Param(value="id")Integer id);
	
	@DataSource(DataSourceEnum.SLAVE)
	List<UserInfo> selectAll();

}