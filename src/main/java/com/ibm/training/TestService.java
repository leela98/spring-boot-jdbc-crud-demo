package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	UserDao dao;

	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}

	String getUserName(int id, String address) {
		return dao.getUserName(id, address);
	}

	Integer createUser(User user) {
		return dao.createUser(user);

	}

	Integer updateUser(String id,User user) {
		return dao.updateUser(id,user);
	}

	Integer deleteUser(int id) {
		return dao.deleteUser(id);
	}
}
