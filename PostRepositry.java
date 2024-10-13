package com.example.demo.repositritry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;

public interface PostRepositry extends JpaRepository<Post,Integer>{

}
