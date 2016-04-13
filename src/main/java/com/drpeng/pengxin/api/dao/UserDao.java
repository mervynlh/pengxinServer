package com.drpeng.pengxin.api.dao;

import com.drpeng.pengxin.api.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	User getUserById(Long id);
}
