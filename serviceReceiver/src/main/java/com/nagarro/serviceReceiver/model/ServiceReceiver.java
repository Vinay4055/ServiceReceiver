package com.nagarro.serviceReceiver.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nagarro.serviceReceiver.validation.annotation.ValidEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceReceiver {
	@NotEmpty(message="First Name Is Mandatory")
	String firstName;
	@NotEmpty(message="Last Name Is Mandatory")
	String lastName;
	@NotEmpty(message = "Title is Mandatory")
	String title;
	@NotEmpty(message = "EmailId is Mandatory")
	@ValidEmail(message = "Please Enter Valid EmailId")
	String email;
	@NotEmpty(message = "TelephoneNo is Mandatory")
	@Size(min = 10, max = 15, message = "Telephone Number should be in range of 10 to 15 Digits")
	@Pattern(regexp="^(0|[1-9][0-9]*)$")
	String telePhone;
	@NotEmpty(message = "Address1 is Mandatory")
	String address1;
	String address2;
	@NotEmpty(message = "City is Mandatory")
	String city;
	@NotEmpty(message = "State is Mandatory")
	String state;
	@NotNull(message = "ZipCode is Mandatory")
	Integer zip;
	@NotEmpty(message = "Country is Mandatory")
	String country;
	@NotEmpty
	@Size(min = 8,message="Password Should be atleast 8 digits")
	String password;
}
