package com.siva.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.demo.customException.RecordNotFoundException;
import com.siva.demo.model.Admin;
import com.siva.demo.service.AdminUserService;

@RestController
@RequestMapping("/admin")

public class AdminController {
	private static final Logger Log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminUserService service;

	@GetMapping
	public ResponseEntity<List<Admin>> getAllUsers() {

		List<Admin> list = service.getAllUsers();
		Log.info("GetAllUsers >>size>>" + list.size());

		return new ResponseEntity<List<Admin>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Admin> createOrUpdateByUsers(@RequestBody Admin admin) throws RecordNotFoundException {
		Admin create = null;
		if (admin.getRole().equalsIgnoreCase("Admin")) {
			create = service.createOrUpdateByAdmin(admin);
			Log.info("createOrUpdateByUsers >>user>>" + create.toString());
		} else {
			throw new RecordNotFoundException("Except Admin none of the user not permit to create users");
		}
		return new ResponseEntity<Admin>(create, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	    public HttpStatus deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		 service.deleteUserById(id);
	        return HttpStatus.FORBIDDEN;
	    }
	 
	
}
