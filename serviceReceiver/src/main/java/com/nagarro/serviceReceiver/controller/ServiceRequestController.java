package com.nagarro.serviceReceiver.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serviceReceiver.mapper.Mapper;
import com.nagarro.serviceReceiver.model.ServiceRequest;
import com.nagarro.serviceReceiver.service.MaintainServiceRequest;

@RestController
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
	@Autowired
	Mapper mapper;
	//@Autowired
	MaintainServiceRequest maintainServiceRequest;
	@PostMapping("/")
	public ResponseEntity<String> createServiceRequest(@PathVariable("email") String email,@RequestBody ServiceRequest serviceRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			String orderId = maintainServiceRequest.bookService(serviceRequest,email);
			return	new ResponseEntity<>(orderId,HttpStatus.ACCEPTED);
		}
	}
	@DeleteMapping("/")
	public ResponseEntity<Void> deleteServiceRequest(@PathVariable("email") String email, @RequestBody ServiceRequest serviceRequest, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			maintainServiceRequest.cancelService(serviceRequest,email);
			return	new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	@GetMapping("/")
	public ResponseEntity<ServiceRequest> getServiceStatus(@PathVariable("orderId") String orderId){
		ServiceRequest serviceRequest = maintainServiceRequest.statusOfService(orderId);
		return	new ResponseEntity<>(serviceRequest,HttpStatus.ACCEPTED);
	}
	
}
