package org.tobby.spring.remoting.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class RestTemplateDeleteClient {

	private RestTemplate restTemplate = new RestTemplate();
	
	private final String spittleUrl = "http://localhost:8081/spittles/{spittleId}";
	
	public static void main(String[] args) {
		RestTemplateDeleteClient client = new RestTemplateDeleteClient();
		client.deleteSpittleByDeleteURI(7);
		client.deleteSpittleByDeleteParams(8);
		client.deleteSpittleByDeleteMap(9);
	}
	
	//Example for RestTemplate.delete(URI url)
	private void deleteSpittleByDeleteURI(long id) {
		try {
			URI url = new URI("http://localhost:8081/spittles/" + id);
			restTemplate.delete(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//Example for RestTemplate.delete(String url, Object... uriVariables)
	private void deleteSpittleByDeleteParams(long id) {
		restTemplate.delete(spittleUrl, id);
	}
	
	//Example for RestTemplate.delete(String url, Map<String, ?> uriVariables)
	private void deleteSpittleByDeleteMap(long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("spittleId", id);
		restTemplate.delete(spittleUrl, id);
	}
}
