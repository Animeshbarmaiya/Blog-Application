package com.example.demo.Exception;

public class EntityNotFoundException extends RuntimeException{
	
	public EntityNotFoundException(String msg){
		super(msg);
	}
}
