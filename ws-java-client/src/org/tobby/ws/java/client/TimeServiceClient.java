package org.tobby.ws.java.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.tobby.ws.java.service.TimeService;

public class TimeServiceClient {
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8089/timeService?wsdl");
		QName qName = new QName("http://service.java.ws.tobby.org/", "TimeServiceImplService");
		Service service = Service.create(url, qName);
		TimeService timeServer = service.getPort(TimeService.class);
		System.out.println(timeServer.getTimeAsString());
		System.out.println(timeServer.getTimeAsElapsed());
	}
}
