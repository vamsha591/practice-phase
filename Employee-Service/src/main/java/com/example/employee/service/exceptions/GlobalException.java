package com.example.employee.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.employee.service.response.ApiResponse;

@RestControllerAdvice
public class GlobalException  {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<>(ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(),HttpStatus.NOT_FOUND);
	}
}
