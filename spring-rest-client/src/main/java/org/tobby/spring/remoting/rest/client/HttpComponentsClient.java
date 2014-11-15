package org.tobby.spring.remoting.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.tobby.spring.remoting.rest.domain.Spittle;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpComponentsClient {
	
	public static void main(String args[]) {
		//CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String spitterUrl = "http://localhost:8081/spitters/haa/spittles";
		HttpGet getRequest = new HttpGet(spitterUrl);
		getRequest.setHeader("Accept", "application/json");
		try {
			HttpResponse response = httpClient.execute(getRequest);
			HttpEntity entity = response.getEntity();
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
			String content = br.readLine();
			System.out.println(content);
			
			ObjectMapper mapper = new ObjectMapper();
			Spittle[] spittles = mapper.readValue(content, Spittle[].class);
			System.out.println(spittles[0].getId());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
