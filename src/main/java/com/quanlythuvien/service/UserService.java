package com.quanlythuvien.service;

import com.quanlythuvien.domain.User;
import com.quanlythuvien.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repository;

	public Boolean create(User user) {
		User existingUser = repository.findByUsername(user.getUsername());
		if (existingUser != null) {
			return false;
		}
		user.getRole().setUser(user);
		User saved = repository.save(user);
		if (saved == null) {
			return false;
		}
		return true;
	}

	public Boolean update(User user) {
		User existingUser = repository.findByUsername(user.getUsername());
		if (existingUser == null) {
			return false;
		}
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.getRole().setRole(user.getRole().getRole());

		User saved = repository.save(existingUser);

		if (saved == null) {
			return false;
		}
		return true;
	}

	public Boolean delete(User user) {
		User existingUser = repository.findOne(user.getId());
		if (existingUser == null)
			return false;

		repository.delete(existingUser);
		User deletedUser = repository.findOne(user.getId());
		if (deletedUser != null)
			return false;

		return true;
	}

}
