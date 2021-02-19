package com.nagarro.serviceReceiver.service;

import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
	public void getProfileDetails(String email);
}
