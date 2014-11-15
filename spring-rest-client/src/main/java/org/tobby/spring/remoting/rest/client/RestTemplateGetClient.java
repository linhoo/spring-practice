package org.tobby.spring.remoting.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.tobby.spring.remoting.rest.domain.Spittle;

public class RestTemplateGetClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String spitterUrl = "http://localhost:8081/spitters/{spitter}/spittles";

	public static void main(String[] args) {
		RestTemplateGetClient client = new RestTemplateGetClient();
		Spittle[] spittles;
		ResponseEntity<Spittle[]> response;
		
		spittles = client.retrieveSpittlesForSpitterByGetForObjectUri("TobbyGetForObjectURI");
		System.out.println(spittles[2].getText());
		
		spittles = client.retrieveSpittlesForSpitterByGetForObjectParams("TobbyGetForObjectParams");
		System.out.println(spittles[2].getText());
		
		spittles = client.retrieveSpittlesForSpitterByGetForObjectMap("TobbyGetForObjectMap");
		System.out.println(spittles[2].getText());

		response = client.retrieveSpittlesForSpitterByGetForEntityUri("TobbyGetForEntityURI");
		spittles = response.getBody();
		System.out.println(spittles[2].getText());
		
		response = client.retrieveSpittlesForSpitterByGetForEntityParams("TobbyGetForEntityParams");
		spittles = response.getBody();
		System.out.println(spittles[2].getText());
		
		response = client.retrieveSpittlesForSpitterByGetForEntityMap("TobbyGetForEntityMap");
		spittles = response.getBody();
		System.out.println(spittles[2].getText());
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders().getContentType());
		System.out.println(response.getHeaders().getAccept());
		System.out.println(response.getHeaders().get("Content-Type"));
		System.out.println(response.getHeaders().getFirst("content-type"));
		System.out.println(response.getHeaders().get("Server"));
		System.out.println(response.getHeaders());
	}
	
	//Example for RestTemplate.getForObject(URI url, Class<T> responseType)
	private Spittle[] retrieveSpittlesForSpitterByGetForObjectUri(String username) {
		Spittle[] spittles = null;
		try {
			URI url = new URI("http://localhost:8081/spitters/" + username + "/spittles");
			spittles = restTemplate.getForObject(url, Spittle[].class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return spittles;
	}
	
	//Example for RestTemplate.getForObject(String url, Class<T> responseType, Object... uriVariables)
	private Spittle[] retrieveSpittlesForSpitterByGetForObjectParams(String username) {
		return restTemplate.getForObject(spitterUrl, Spittle[].class, username);
	}
	
	//Example for RestTemplate.getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables)
	private Spittle[] retrieveSpittlesForSpitterByGetForObjectMap(String username) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("spitter", username);
		return restTemplate.getForObject(spitterUrl, Spittle[].class, urlVariables);
	}
	
	//Example for RestTemplate.getForEntity(URI url, Class<T> responseType)
	private ResponseEntity<Spittle[]> retrieveSpittlesForSpitterByGetForEntityUri(String username) {
		ResponseEntity<Spittle[]> responseEntity = null;
		try {
			URI url = new URI("http://localhost:8081/spitters/" + username + "/spittles");
			responseEntity = restTemplate.getForEntity(url, Spittle[].class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//Example for RestTemplate.getForEntiry(String url, Class<T> responseType, Object... uriVariables)
	private ResponseEntity<Spittle[]> retrieveSpittlesForSpitterByGetForEntityParams(String username) {
		return restTemplate.getForEntity(spitterUrl, Spittle[].class, username);
	}
	
	//Example for RestTemplate.getForEntiry(String url, Class<T> responseType, Map<String, ?> uriVariables)
	private ResponseEntity<Spittle[]> retrieveSpittlesForSpitterByGetForEntityMap(String username) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("spitter", username);
		return restTemplate.getForEntity(spitterUrl, Spittle[].class, urlVariables);
	}
	
}
