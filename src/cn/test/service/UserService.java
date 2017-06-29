package cn.test.service;

import cn.test.entity.User;

public interface UserService {

	User getUserByUsername(String username);

	int InsertUser(User user);
	
}
