package com.nagarro.serviceReceiver.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceReceiver {
	String id;
	String firstName;
	String lastName;
	String title;
	String email;
	String telePhone;
	String address1;
	String address2;
	String city;
	String state;
	Integer zip;
	String country;
	String password;
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.title + " " + this.email + " " + this.telePhone + " "
				+ this.address1 + " " + this.address2 + " " + this.city + " " + this.state + " " + this.zip + " "
				+ this.country + " " + this.password;
	}
}
