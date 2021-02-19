package com.nagarro.serviceReceiver.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Service {
	@NotEmpty(message = "id is mandatory")
	String id;
	@NotEmpty(message = "name is mandatory")
	String name;
	@NotNull(message = "Amount can't be empty")
	Float amount;
	@NotEmpty(message = "category is mandatory")
	String category;
}
