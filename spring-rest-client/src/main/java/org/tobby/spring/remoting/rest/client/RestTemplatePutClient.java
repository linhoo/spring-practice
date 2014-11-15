package org.tobby.spring.remoting.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
import org.tobby.spring.remoting.rest.domain.Spittle;

public class RestTemplatePutClient {

	private RestTemplate restTemplate = new RestTemplate();
	private final String spitterUrl = "http://localhost:8081/spittles/{spittleId}";
	
	public static void main(String[] args) {
		RestTemplatePutClient client = new RestTemplatePutClient();
		Spittle spittle = new Spittle(5, "TobbySpittle");
		client.updateSpittleByPutURI(spittle);
		client.updateSpittleByPutParams(spittle);
		client.updateSpittleByPutMap(spittle);
	}
	
	//Example for RestTemplate.pub(URI url, Object request)
	private void updateSpittleByPutURI(Spittle spittle) {
		try {
			URI url = new URI("http://localhost:8081/spittles/" + spittle.getId());
			restTemplate.put(url, spittle);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//Example for RestTemplate.pub(String url, Object request, Object... uriVariables)
	private void updateSpittleByPutParams(Spittle spittle) {
		restTemplate.put(spitterUrl, spittle, spittle.getId());
	}
	
	//Example for RestTemplate.pub(String url, Object request, Map<String, ?> uriVariables)
	private void updateSpittleByPutMap(Spittle spittle) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("spittleId", spittle.getId());
		restTemplate.put(spitterUrl, spittle, params);
	}
		
}
