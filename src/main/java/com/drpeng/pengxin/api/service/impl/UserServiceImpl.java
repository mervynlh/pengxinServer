package com.drpeng.pengxin.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.drpeng.pengxin.api.dao.UserDao;
import com.drpeng.pengxin.api.domain.User;
import com.drpeng.pengxin.api.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(Long id) {
		//test test  test test
		return userDao.getUserById(id);
	}
	
}
