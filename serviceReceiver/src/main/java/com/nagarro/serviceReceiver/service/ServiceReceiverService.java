package com.nagarro.serviceReceiver.service;

import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.entity.ServiceReceiver;
@Service
public interface ServiceReceiverService {
	public Boolean createAccount(ServiceReceiver serviceReceiver);
	public Boolean updateAccount(ServiceReceiver serviceReceiver);
	public Boolean deleteAccount(ServiceReceiver serviceReceiver);
	public ServiceReceiver findAccount(String email);
}
