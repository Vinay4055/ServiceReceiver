package com.nagarro.serviceReceiver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serviceReceiver.mapper.Mapper;
import com.nagarro.serviceReceiver.model.ServiceReceiver;

@RestController
@RequestMapping("/serviceReceiver")
public class ServiceReceiverController {
	@Autowired
	Mapper mapper;
	@PostMapping("/")
	public ResponseEntity<Void> addUser(@RequestBody @Valid ServiceReceiver serviceReceiver, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else if(employeeService.registerEmployee(mapper.convertServiceReceiverModelToEntity(serviceReceiver))){

			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return	new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@PutMapping("/")
	public ResponseEntity<Void> updateUser(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else if(employeeService.updateEmployee(mapper.convertEmployeeModelToEntity(employee))){

			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return	new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
