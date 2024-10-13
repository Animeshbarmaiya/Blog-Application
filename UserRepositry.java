package com.example.demo.repositritry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface UserRepositry extends JpaRepository<User, Integer>{
	public boolean existsByEmail(String email);
	public boolean existsByPhoneNO(Long string);
}
