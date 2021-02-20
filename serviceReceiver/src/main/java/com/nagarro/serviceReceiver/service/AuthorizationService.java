package com.nagarro.serviceReceiver.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthorizationService {
	public Boolean validateAccount(String email,String password);
}
