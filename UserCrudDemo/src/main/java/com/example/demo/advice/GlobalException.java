package com.example.demo.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.UserCrudException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserCrudException.class)
	public ResponseEntity<String> handleUserException(UserCrudException ex){
		return new ResponseEntity<String>(ex.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
}
