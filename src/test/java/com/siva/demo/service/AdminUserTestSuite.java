package com.siva.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.siva.demo.LibraryDemoApplication;
import com.siva.demo.model.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryDemoApplication.class)
public class AdminUserTestSuite {
	private static final Logger Log = LoggerFactory.getLogger(AdminUserTestSuite.class);
	@Autowired
	AdminUserService service;

	@Test
	public void testAllUsersData() {
		List<Admin> getAllData = null;
		try {
			getAllData = service.getAllUsers();
			Log.info("All Users Data" + getAllData.toString());
		} catch (Exception e) {

		}

	}

}
