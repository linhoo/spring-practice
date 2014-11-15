package org.tobby.spring.remoting.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.tobby.spring.remoting.rest.domain.Spittle;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UrlConnectionClient {

	public static void main(String[] args) {
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader br = null;
		try {
			url = new URL("http://localhost:8081/spitters/haa/spittles");
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.connect();
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			String content = br.readLine();
			System.out.println(content);
			
			ObjectMapper mapper = new ObjectMapper();
			Spittle[] spittles = mapper.readValue(content, Spittle[].class);
			System.out.println(spittles[0].getId());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
