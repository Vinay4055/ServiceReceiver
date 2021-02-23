package com.nagarro.serviceReceiver.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.nagarro.serviceReceiver.common.ServiceRequestStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServiceRequest {
	String id;
	@NotEmpty(message = "ServiceID is Mandatory")
	String serviceId;
	@NotEmpty(message = "Service Date is Mandatory")
	String date;
	@NotNull(message = "Status is Mandatory")
	ServiceRequestStatus statusOfRequest;
	@NotEmpty(message = "Please Enter The email id of user which requested for the service")
	String emailIdOfServiceReceiver;
}
