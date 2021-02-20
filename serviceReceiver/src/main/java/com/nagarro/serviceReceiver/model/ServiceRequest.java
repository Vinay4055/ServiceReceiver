package com.nagarro.serviceReceiver.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class ServiceRequest {
	@NotEmpty(message = "ServiceID is Mandatory")
	String id;
	@NotEmpty(message = "Service Date is Mandatory")
	Date date;
	@NotEmpty(message = "Status is Mandatory")
	String status;
	@NotEmpty(message = "Please Enter The email id of user which requested for the service")
	String requestMadeBy;
}
