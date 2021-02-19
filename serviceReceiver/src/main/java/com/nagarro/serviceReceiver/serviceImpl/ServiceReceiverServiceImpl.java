package com.nagarro.serviceReceiver.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.entity.ServiceReceiver;
import com.nagarro.serviceReceiver.service.ServiceReceiverService;
@Service
public class ServiceReceiverServiceImpl implements ServiceReceiverService {

	static List<ServiceReceiver> serviceReceivers = new ArrayList<ServiceReceiver>();

	@Override
	public Boolean createAccount(ServiceReceiver serviceReceiver) {
		if (this.findAccount(serviceReceiver.getEmail()) == null) {
			serviceReceivers.add(serviceReceiver);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean updateAccount(ServiceReceiver serviceReceiver) {
		ServiceReceiver existingRecord = this.findAccount(serviceReceiver.getEmail());
		if (existingRecord != null) {
			existingRecord.setAddress1(serviceReceiver.getAddress1());
			existingRecord.setAddress2(serviceReceiver.getAddress2());
			existingRecord.setCity(serviceReceiver.getCity());
			existingRecord.setCountry(serviceReceiver.getCountry());
			existingRecord.setFirstName(serviceReceiver.getFirstName());
			existingRecord.setLastName(serviceReceiver.getLastName());
			existingRecord.setState(serviceReceiver.getState());
			existingRecord.setTelePhone(serviceReceiver.getTelePhone());
			existingRecord.setTitle(serviceReceiver.getTitle());
			existingRecord.setZip(serviceReceiver.getZip());
			return true;
		} else
			return false;
	}

	@Override
	public Boolean deleteAccount(ServiceReceiver serviceReceiver) {
		ServiceReceiver existingRecord = this.findAccount(serviceReceiver.getEmail());
		if(existingRecord != null) {
			serviceReceivers.remove(existingRecord);
			return true;
		}
		else
			return false;
	}

	@Override
	public ServiceReceiver findAccount(String email) {
		Optional<ServiceReceiver> foundedServiceReceiver = serviceReceivers.stream()
				.filter(serviceReceiver -> email.equals(serviceReceiver.getEmail())).findFirst();
		if (foundedServiceReceiver.isPresent()) {
			return foundedServiceReceiver.get();
		} else
			return null;
	}

}