package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	User user = new User();

	Integer getCountOfUsers() {
		return template.queryForObject("select count(*) from user", Integer.class);
	}

	String getUserName(int id, String address) {
		return template.queryForObject("select name from user where id = ? and address = ?",
				new Object[] { id, address }, String.class);
	}

	Integer createUser(User user) {

		return template.update("insert into user values (?,?,?)",
				new Object[] { user.getId(), user.getAddress(), user.getName() });

	}

	Integer updateUser(String id, User user) {
		return template.update("update user " + " set address = ?, name = ? " + " where id = ?",
				new Object[] { user.getAddress(), user.getName(), user.getId() });
	}

	Integer deleteUser(int id) {
		return template.update("delete from user where id = ?", new Object[] { id });

	}

}
