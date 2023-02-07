package com.example.department.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.department.service.response.ApiResponse;

@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(),HttpStatus.NOT_FOUND);
	}
}
