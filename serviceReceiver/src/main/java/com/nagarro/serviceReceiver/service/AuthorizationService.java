package com.nagarro.serviceReceiver.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthorizationService {
	public void validateAccount(String email,String password);
}
