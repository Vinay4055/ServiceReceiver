package com.nagarro.serviceReceiver.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.serviceReceiver.model.ServiceReceiver;


@Component
public class Mapper {
	@Autowired
	ModelMapper modelMapper;

	public ServiceReceiver convertServiceReceiverEntityToModel(com.nagarro.serviceReceiver.entity.ServiceReceiver source) {
		return modelMapper.map(source, ServiceReceiver.class);
	}

	public com.nagarro.serviceReceiver.entity.ServiceReceiver convertServiceReceiverModelToEntity(ServiceReceiver source) {
		return modelMapper.map(source, com.nagarro.serviceReceiver.entity.ServiceReceiver.class);
	}

	
	
}
