package org.tobby.spring.remoting.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.tobby.spring.remoting.rest.domain.Spitter;

public class RestTemplateExchange {

	private RestTemplate restTemplate = new RestTemplate();
	
	private String spitterUrl = "http://localhost:8089/spitters/{4}";
	
	public static void main(String[] args) {
		RestTemplateExchange client = new RestTemplateExchange();
		Spitter spitter = client.getSpitter(889999l);
		System.out.println(spitter.getUsername());
		System.out.println(spitter.getPassword());
		
		System.out.println("-------------------");
		spitter = client.exchangeSpitter(3345l);
		System.out.println(spitter.getId());
		System.out.println(spitter.getPassword());
		
		System.out.println("------------------");
		spitter = client.exchangeSpitter2(213l);
		System.out.println(spitter.getUsername());
	}
	
	private Spitter getSpitter(Long spitterId) {
		ResponseEntity<Spitter> response = restTemplate.getForEntity(spitterUrl, Spitter.class, spitterId);
		return response.getBody();
	}
	
	private Spitter exchangeSpitter(Long spitterId) {
		ResponseEntity<Spitter> response = restTemplate.exchange(spitterUrl, HttpMethod.GET, null, Spitter.class, spitterId);
		return response.getBody();
	}
	
	private Spitter exchangeSpitter2(Long spitterId) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Accept", "application/json");
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		ResponseEntity<Spitter> response = restTemplate.exchange(spitterUrl, HttpMethod.GET, requestEntity, Spitter.class, spitterId);
		return response.getBody();
	}
}
