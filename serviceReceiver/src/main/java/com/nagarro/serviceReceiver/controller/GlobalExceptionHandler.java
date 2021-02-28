package com.nagarro.serviceReceiver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(org.springframework.web.client.HttpClientErrorException.class)
	public ResponseEntity<Void> responseBodyEmpty(org.springframework.web.client.HttpClientErrorException e) {
		System.out.println("Exception occurs"+e);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
