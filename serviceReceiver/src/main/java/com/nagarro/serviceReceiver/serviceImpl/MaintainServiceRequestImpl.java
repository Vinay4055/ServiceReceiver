package com.nagarro.serviceReceiver.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.serviceReceiver.delegate.ServiceReceiverDelegate;
import com.nagarro.serviceReceiver.entity.ServiceReceiver;
import com.nagarro.serviceReceiver.model.ServiceRequest;
import com.nagarro.serviceReceiver.service.MaintainServiceRequest;
import com.nagarro.serviceReceiver.service.ServiceReceiverService;
import com.nagarro.serviceReceiver.util.Utility;

@Service
public class MaintainServiceRequestImpl implements MaintainServiceRequest {
	@Autowired
	ServiceReceiverDelegate serviceReceiverDelegate;
	@Autowired
	ServiceReceiverService serviceReceiverService;

	@Override
	public String bookService(ServiceRequest serviceRequest) {
		ServiceReceiver serviceReceiver = serviceReceiverService
				.findAccount(serviceRequest.getEmailIdOfServiceReceiver());
		if (serviceReceiver != null) {
			serviceRequest.setId(Utility.getRandomUuid());

			serviceReceiverDelegate.callManageServiceRequestAndCreateServiceRequest(serviceRequest);
			return serviceRequest.getId();
		} else
			return null;
	}

	@Override
	public void cancelService(String serviceRequestId) {
		serviceReceiverDelegate.callManageServiceRequestAndCancelServiceRequest(serviceRequestId);
	}

	@Override
	public ServiceRequest statusOfService(String orderId) {
		return serviceReceiverDelegate.callManageServiceRequestAndCheckStatusOfServiceRequest(orderId);

	}

}
