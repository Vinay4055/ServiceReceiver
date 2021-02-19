package com.nagarro.serviceReceiver.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serviceReceiver.mapper.Mapper;
import com.nagarro.serviceReceiver.model.ServiceReceiver;
import com.nagarro.serviceReceiver.service.ServiceReceiverService;

@RestController
@RequestMapping("/serviceReceiver")
public class ServiceReceiverController {
	@Autowired
	Mapper mapper;
	@Autowired
	ServiceReceiverService serviceReceiverService;
	@PostMapping("/")
	public ResponseEntity<Void> addUser(@RequestBody ServiceReceiver serviceReceiver, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else if(serviceReceiverService.createAccount(mapper.convertServiceReceiverModelToEntity(serviceReceiver))){

			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return	new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@PutMapping("/")
	public ResponseEntity<Void> updateUser(@RequestBody ServiceReceiver serviceReceiver, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else if(serviceReceiverService.updateAccount(mapper.convertServiceReceiverModelToEntity(serviceReceiver))){

			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return	new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@DeleteMapping("/")
	public ResponseEntity<Void> deleteAccount(@RequestBody ServiceReceiver serviceReceiver, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else if(serviceReceiverService.deleteAccount(mapper.convertServiceReceiverModelToEntity(serviceReceiver))){

			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return	new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
