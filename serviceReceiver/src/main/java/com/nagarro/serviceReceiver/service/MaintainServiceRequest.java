package com.nagarro.serviceReceiver.service;

import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.model.ServiceRequest;
@Service
public interface MaintainServiceRequest {
	public String bookService(ServiceRequest serviceRequest);
	public Boolean cancelService(String serviceRequestId);
	public ServiceRequest statusOfService(String orderId);
}
