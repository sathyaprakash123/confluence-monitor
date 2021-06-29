package com.confluence.monitor.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.confluence.monitor.confAPI.ConfAPI;

@Service
public class NetworkCallService {

	Logger logger = LoggerFactory.getLogger(ConfAPI.class);

	public JSONObject makeHttpCall(String url, String password, String apiPath)

	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String httpurl = url.concat(apiPath);
		headers.set("Accept", "application/json");
		headers.set("Authorization", password);
		HttpEntity entity = new HttpEntity(headers);
		JSONObject jso = new JSONObject(restTemplate.exchange(httpurl, HttpMethod.GET, entity, String.class));
		logger.info(jso.toString());
		logger.info(jso.getString("body"));
		JSONObject json = new JSONObject(jso.getString("body"));
		return json;

	}

}
