package com.nagarro.serviceReceiver.delegate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
	String gatewayServiceUrl = "http://api-gateway:9999/";
	String gatewayUrl = "http://localhost:9999/";
	String url = gatewayUrl;

	public void callManageServiceRequestAndCreateServiceRequest(ServiceRequest serviceRequest) {

		// String url = "http://localhost:9999/manageServiceRequest/";
		// String url = "manageServiceRequest/";
		restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String serviceRequestObject = gson.toJson(serviceRequest);
		HttpEntity<ServiceRequest> request = new HttpEntity<ServiceRequest>(serviceRequest, headers);
		restTemplate.postForEntity(url + "manageServiceRequest/", request, String.class);

	}

	public ServiceRequest callManageServiceRequestAndCheckStatusOfServiceRequest(String serviceRequestId) {
		System.out.println("Status");
		if (serviceRequestId != null) {
			String callUrl = url + "manageServiceRequest/status/{serviceRequestId}";
			ResponseEntity<String> responseEntity = restTemplate.exchange(callUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<String>() {
					}, serviceRequestId);
			if (responseEntity.hasBody())
				return gson.fromJson(responseEntity.getBody(), ServiceRequest.class);
			else
				return null;
		} else
			return null;
	}

	public void callManageServiceRequestAndCancelServiceRequest(String serviceRequestId) {

		String callUrl = url + "cancelServiceRequest/{serviceRequestId}";
		restTemplate = new RestTemplate();

		Map<String, String> params = new HashMap<>();
		params.put("serviceRequestId", serviceRequestId);

		restTemplate.put(callUrl, null, params);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
