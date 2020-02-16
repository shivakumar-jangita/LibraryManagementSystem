package com.siva.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.demo.customException.RecordNotFoundException;
import com.siva.demo.model.Admin;
import com.siva.demo.repository.UserRepos;

/**
 * @author Sivakumar_Jangita
 *
 */
@Service
public class AdminUserService {

	@Autowired
	UserRepos userRepos;

	/* TO VIEW ALL the USERs LIST */
	public List<Admin> getAllUsers() {
		List<Admin> userList = userRepos.findAll();

		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<Admin>();
		}
	}

	public Admin createOrUpdateByAdmin(Admin entity) throws RecordNotFoundException {
		Optional<Admin> users = userRepos.findById(entity.getId());

		if (users.isPresent()) {
			Admin newEntity = users.get();
			newEntity.setName(entity.getName());
			newEntity.setRole(entity.getRole());
			newEntity.setAddress(entity.getAddress());
			newEntity.setBookissue(entity.getBookissue());
			newEntity.setBookreturn(entity.getBookreturn());
			newEntity = userRepos.save(newEntity);

			return newEntity;
		} else {
			entity = userRepos.save(entity);

			return entity;
		}
	}

	public void deleteUserById(Long id) throws RecordNotFoundException {
		Optional<Admin> users = userRepos.findById(id);

		if (users.isPresent()) {
			userRepos.deleteById(id);
		} else {
			throw new RecordNotFoundException("No User record exist for given id");
		}
	}

}
