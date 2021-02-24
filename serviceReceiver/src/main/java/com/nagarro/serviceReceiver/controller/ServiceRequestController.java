package com.nagarro.serviceReceiver.controller;

import javax.validation.Valid;
import javax.ws.rs.Path;

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
	@Autowired
	MaintainServiceRequest maintainServiceRequest;

	@PostMapping("/")
	public ResponseEntity<String> createServiceRequest(@RequestBody @Valid ServiceRequest serviceRequest,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			String orderId = maintainServiceRequest.bookService(serviceRequest);// orderId and requestId is same
			return new ResponseEntity<>(orderId, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/")
	public ResponseEntity<Void> cancelServiceRequest(@PathVariable(name = "serviceRequestId") String serviceRequestId) {

		maintainServiceRequest.cancelService(serviceRequestId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<ServiceRequest> getServiceStatus(@PathVariable(name = "orderId") String orderId) {
		System.out.println("Inside Status");
		ServiceRequest serviceRequest = maintainServiceRequest.statusOfService(orderId);
		if (serviceRequest != null)
			return new ResponseEntity<ServiceRequest>(serviceRequest, HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
