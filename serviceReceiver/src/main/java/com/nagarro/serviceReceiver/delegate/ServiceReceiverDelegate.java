package com.nagarro.serviceReceiver.delegate;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.nagarro.serviceReceiver.model.ServiceRequest;

@Component
public class ServiceReceiverDelegate {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Gson gson;
	public void callManageServiceRequestAndCreateServiceRequest(ServiceRequest serviceRequest){
		
		String url = "http://localhost:9999/manageServiceRequest/";
		restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String serviceRequestObject = gson.toJson(serviceRequest);
		HttpEntity<ServiceRequest> request = 
			      new HttpEntity<ServiceRequest>(serviceRequest, headers);
		restTemplate.postForEntity(url, request, String.class);
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}