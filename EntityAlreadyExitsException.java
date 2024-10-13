package com.example.demo.Exception;

public class EntityAlreadyExitsException extends RuntimeException{
	
	public	EntityAlreadyExitsException(String msg){
		super(msg);
	}
}
