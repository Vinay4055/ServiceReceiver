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
}
