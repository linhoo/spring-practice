package org.tobby.spring.remoting.rest.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.tobby.spring.remoting.rest.domain.Spitter;
import org.tobby.spring.remoting.rest.domain.Spittle;

public class RestTemplatePostClient {

	private RestTemplate restTemplate = new RestTemplate();
	
	private final String spitterUrl = "http://localhost:8089/spitters";
	
	public static void main(String[] arg) {
		RestTemplatePostClient client = new RestTemplatePostClient();
		Spitter spitter = new Spitter("Tobby", "123456");
		Spitter responseObject;
		ResponseEntity<Spitter> responseEntity;
		URI responseUri;
		responseObject = client.postSpitterForObjectByPostForObjectURI(spitter);
		responseObject = client.postSpitterForObjectByPostForObjectParams(spitter);
		responseObject = client.postSpitterForObjectByPostForObjectMap(spitter);
		responseEntity = client.postSpitterForEntityByPostForEntiryURI(spitter);
		responseEntity = client.postSpitterForEntityByPostForEntityParams(spitter);
		responseEntity = client.postSpitterForEntityByPostForEntityMap(spitter);
		responseObject = responseEntity.getBody();
		System.out.println(responseObject.getUsername() + ", " + responseObject.getPassword());
		System.out.println(responseEntity.getStatusCode());
		URI url = responseEntity.getHeaders().getLocation();
		System.out.println("Getting uri from header location " + url);
		
		responseUri = client.postSpitterForLocationByPostForLocationURI(spitter);
		System.out.println(responseUri.toString());
		responseUri = client.postSpitterForLocationByPostForLocationParams(spitter);
		System.out.println(responseUri.toASCIIString());
		responseUri	= client.postSpitterForLocationByPostForLocationMap(spitter);
		System.out.println(responseUri.toString());
		
		Spittle s = client.restTemplate.postForObject("http://localhost:8089/spittles", new Spittle(5, "tt"), Spittle.class);
		//System.out.println(s.getId());
	}
	
	//Example for RestTemplate.postForObject(URI url, Object request, Class<T> responseType)
	private Spitter postSpitterForObjectByPostForObjectURI(Spitter spitter) {
		try {
			URI url = new URI(spitterUrl);
			spitter = restTemplate.postForObject(url, spitter, Spitter.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return spitter;
	}
	
	//Example for RestTemplate.postForObject(String url, Object request, Class<T> responseType, Object... uriVariables)
	private Spitter postSpitterForObjectByPostForObjectParams(Spitter spitter) {
		return restTemplate.postForObject(spitterUrl, spitter, Spitter.class);
	}
	
	//Example for RestTemplate.postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables)
	private Spitter postSpitterForObjectByPostForObjectMap(Spitter spitter) {
		return restTemplate.postForObject(spitterUrl, spitter, Spitter.class);
	}
	
	//Example for RestTemplate.postForEntity(URI url, Object request, Class<T> responseType)
	private ResponseEntity<Spitter> postSpitterForEntityByPostForEntiryURI(Spitter spitter) {
		ResponseEntity<Spitter> responseEntity = null;
		try {
			URI url = new URI(spitterUrl);
			responseEntity = restTemplate.postForEntity(url, spitter, Spitter.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//Example for RestTemplate.postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables)
	private ResponseEntity<Spitter> postSpitterForEntityByPostForEntityParams(Spitter spitter) {
		return restTemplate.postForEntity(spitterUrl, spitter, Spitter.class);
	}
	
	//Example for RestTemplate.postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables)
	private ResponseEntity<Spitter> postSpitterForEntityByPostForEntityMap(Spitter spitter) {
		return restTemplate.postForEntity(spitterUrl, spitter, Spitter.class);
	}
	
	//Example for RestTemplate.postForLocation(URI url, Object request)
	private URI postSpitterForLocationByPostForLocationURI(Spitter spitter) {
		URI responseURI = null;
		try {
			URI url = new URI(spitterUrl);
			responseURI = restTemplate.postForLocation(url, spitter);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseURI;
	}
	
	//Example for RestTemplate.postForLocation(String url, Object request, Object... uriVariables)
	private URI postSpitterForLocationByPostForLocationParams(Spitter spitter) {
		return restTemplate.postForLocation(spitterUrl, spitter);
	}
	
	//Example for RestTemplate.postForLocation(String url, Object request, Map<String, ?> uriVariables)
	private URI postSpitterForLocationByPostForLocationMap(Spitter spitter) {
		return restTemplate.postForLocation(spitterUrl, spitter);
	}
	
}
