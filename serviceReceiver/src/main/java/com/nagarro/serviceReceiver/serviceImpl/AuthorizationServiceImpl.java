package com.nagarro.serviceReceiver.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.entity.ServiceReceiver;
import com.nagarro.serviceReceiver.service.AuthorizationService;
import com.nagarro.serviceReceiver.service.ServiceReceiverService;
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
	@Autowired
	ServiceReceiverService serviceReceiverService;
	@Override
	public Boolean validateAccount(String email, String password) {
		ServiceReceiver user = serviceReceiverService.findAccount(email);
		if(user != null && user.getPassword().equals(password)) 
			return true;
		else
			return false;
	}
}
