package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
import com.example.demo.Exception.EntityAlreadyExitsException;
import com.example.demo.Exception.EntityNotFoundException;
import com.example.demo.repositritry.UserRepositry;

@Repository
public class UserDao {
	@Autowired
	private UserRepositry repositry;

	public User saveUser(User user) {
		boolean existsByEmail = repositry.existsByEmail(user.getEmail());
		boolean existsByPhoneNO = repositry.existsByPhoneNO(user.getPhoneNO());
		if (existsByEmail) {
			throw new EntityAlreadyExitsException("User already exists with email : " + user.getEmail());
		}
		if (existsByPhoneNO) {
			throw new EntityAlreadyExitsException("User already exists with phoneNo : " + user.getPhoneNO());
		}
		return repositry.save(user);
	}

	public User updateUser(User user, int id) {
		user.setId(id);
		boolean existsById = repositry.existsById(id);
		if (!existsById) {
			throw new EntityNotFoundException("User not found with the ID :" + id);
		}

		return saveUser(user);

	}

	public User fetchUser(int id) {
		Optional<User> optional = repositry.findById(id);
		if (optional.isEmpty()) {
			throw new EntityNotFoundException("User not found with the ID :" + id);
		}
		return optional.get();
	}

	public List<User> fetchAllUsers() {
		List<User> list = repositry.findAll();
		if (list.isEmpty()) {
			throw new EntityNotFoundException("Users data not available in the database ");
		}

		return list;

	}

	public User deleteUser(int id) {
		User user = fetchUser(id);
		return user;
	}

}
