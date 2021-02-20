package com.nagarro.serviceReceiver.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Email {
	@NotEmpty(message = "email is mandatory")
	String email;
}
