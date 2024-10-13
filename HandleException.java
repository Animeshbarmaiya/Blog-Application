package com.example.demo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Entity.ResponsStructure.ResponseStructure;
@ControllerAdvice
public class HandleException {
	@ExceptionHandler(EntityAlreadyExitsException.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityAlreadyExists(EntityAlreadyExitsException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CONFLICT.value());
		structure.setMessage("Entity Alrady Exists");
		structure.setData(e.getMessage());
		structure.setTime(LocalDateTime.now());

		return new ResponseEntity<>(structure, HttpStatus.CONFLICT);
	} 

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityNotFoundException(EntityNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), "Entity Not Found",
				e.getMessage(), LocalDateTime.now());

		return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStructure<String>> handleException(Exception e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal Server Error Please Try again", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(structure, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
