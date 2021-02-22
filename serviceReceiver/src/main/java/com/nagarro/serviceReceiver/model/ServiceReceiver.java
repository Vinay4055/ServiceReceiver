package com.nagarro.serviceReceiver.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceReceiver {
	@NotEmpty(message = "Id is mandatory")
	String id;
	@NotEmpty(message = "First Name Is Mandatory")
	String firstName;
	@NotEmpty(message = "Last Name Is Mandatory")
	String lastName;
	@NotEmpty(message = "Title is Mandatory")
	String title;
	@NotEmpty(message = "EmailId is Mandatory")
	String email;
	@NotEmpty(message = "TelephoneNo is Mandatory")
	@Size(min = 10, max = 15, message = "Telephone Number should be in range of 10 to 15 Digits")
	String telePhone;
	@NotEmpty(message = "Address is Mandatory")
	String address;
	@NotEmpty(message = "District is Mandatory")
	String district;
	@NotEmpty(message = "City is Mandatory")
	String city;
	@NotEmpty(message = "State is Mandatory")
	String state;
	@NotNull(message = "ZipCode is Mandatory")
	Integer zip;
	@NotEmpty(message = "Country is Mandatory")
	String country;
	@NotEmpty
	@Size(min = 8, message = "Password Should be atleast 8 digits")
	String password;
}
