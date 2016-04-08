package api.pengxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.pengxin.dao.UserDao;
import api.pengxin.domain.User;
import api.pengxin.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}
	
}
