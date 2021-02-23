package com.nagarro.serviceReceiver.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.delegate.ServiceReceiverDelegate;
import com.nagarro.serviceReceiver.model.ServiceRequest;
import com.nagarro.serviceReceiver.service.MaintainServiceRequest;
import com.nagarro.serviceReceiver.util.Utility;
@Service
public class MaintainServiceRequestImpl implements MaintainServiceRequest {
	@Autowired
	ServiceReceiverDelegate serviceReceiverDelegate;
	@Override
	public String bookService(ServiceRequest serviceRequest) {
		serviceRequest.setId(Utility.getRandomUuid());
		serviceReceiverDelegate.callManageServiceRequestAndCreateServiceRequest(serviceRequest);
		return serviceRequest.getId();
	}

	@Override
	public Boolean cancelService(ServiceRequest serviceRequest) {
		
		return null;
	}

	@Override
	public ServiceRequest statusOfService(String orderId) {
		return null;
	}

}
