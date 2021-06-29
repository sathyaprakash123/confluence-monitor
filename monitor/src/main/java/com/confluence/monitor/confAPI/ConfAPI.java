package com.confluence.monitor.confAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.confluence.monitor.service.NetworkCallService;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ConfAPI {

	Logger logger = LoggerFactory.getLogger(ConfAPI.class);

	@Autowired
	NetworkCallService networkcallservice;

	@RequestMapping("/status")
	public String healthCheck()

	{
		return "Monitor Running";
	}

	@RequestMapping("spacesize")
	public String getSpaceSize() {
		
		/*
		String url = "http://localhost:8090/rest/api/space";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic c2F0aHlhOnNhdGh5YQ==");
		HttpEntity entity = new HttpEntity(headers);
        JSONObject jso = new JSONObject(restTemplate.exchange(url, HttpMethod.GET, entity, String.class));
		logger.info(jso.toString());
		logger.info(jso.getString("body"));
		JSONObject json = new JSONObject(jso.getString("body"));
		return Integer.toString(json.getInt("size"));
		*/
		
		JSONObject json = networkcallservice.makeHttpCall("http://localhost:8090", "Basic c2F0aHlhOnNhdGh5YQ==", "/rest/api/space");
		return Integer.toString(json.getInt("size"));
		
		

	}

}
