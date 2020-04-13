package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestService service;

	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}

	@RequestMapping("/user/name/{id}/{address}")
	String getUserName(@PathVariable int id, @PathVariable String address) {
		return service.getUserName(id, address);
	}

	@RequestMapping(method = RequestMethod.POST, value = "user/create")
	String createUser(@RequestBody User user) {
		int res = service.createUser(user);
		if (res == 1) {
			System.out.println("User added!");
			System.exit(0);
		}
		return "error!";

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update/{id}")
	String updateUser(@PathVariable String id, @RequestBody User user) {
		if (service.updateUser(id, user) == 1) {
			System.out.println("Updated user!");
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{id}")
	Integer deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

}
