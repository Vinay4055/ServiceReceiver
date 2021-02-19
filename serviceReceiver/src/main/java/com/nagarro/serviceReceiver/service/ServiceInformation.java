package com.nagarro.serviceReceiver.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ServiceInformation {
	public List<Service> getAllServices();
	public Service getServiceById(String id);
	public Service getServiceByName(String name);
	public Float getServiceCost(String id);
	public List<Service> getServicesByCategory(String categoryName);
}
