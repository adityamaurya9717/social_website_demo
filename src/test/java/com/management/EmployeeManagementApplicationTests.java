package com.management;

import com.management.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		userService.addUser(null);
		System.out.println("tetintg");
	}


}
