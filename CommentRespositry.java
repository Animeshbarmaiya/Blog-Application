package com.example.demo.repositritry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Comment;



public interface CommentRespositry extends JpaRepository<Comment, Integer> {

}

