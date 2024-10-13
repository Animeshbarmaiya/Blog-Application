package com.example.demo.Entity.ResponsStructure;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {
	private int statusCode;
	private String message;
	private  T data;
	private LocalDateTime time;
}

