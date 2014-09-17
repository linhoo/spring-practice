package org.tobby.ws.java.server;

import javax.xml.ws.Endpoint;

import org.tobby.ws.java.service.TimeServiceImpl;

public class TimeServicePublisher {

		public static void main(String[] arg) {
			Endpoint.publish("http://localhost:8089/timeService", new TimeServiceImpl());
			System.out.println("Service is Published");
		}
}
